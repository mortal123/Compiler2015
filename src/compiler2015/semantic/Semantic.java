package compiler2015.semantic;

import java.util.*;

import compiler2015.ast.*;
import compiler2015.env.*;
import compiler2015.table.*;

class ExprInfo {
	public Type type;
	public Boolean isLeft;
	public Integer isConst;
	public ExprInfo(Type _type, Boolean _isLeft, Integer _isConst) {
		type = _type;
		isLeft = _isLeft;
		isConst = _isConst;
	}
}

public class Semantic {
	private Environment env;
	private int loopLevel = 0;
	private List<Error> errors = new LinkedList<Error>();
	
	public Semantic(AST ast) { 
		env = new Environment();
		loopLevel = 0;
		checkAST(ast);
//		showError();
	}
	
	public void error(String message) {
		errors.add(new Error(message));
		//throw new NullPointerException();
	}
	
	public boolean hasError() {
		return errors.size() > 0;
	}
	
	public void showError() {
		if (errors.size() == 0) {
			System.out.println("Pass!");
		} else {
			System.out.println("There is(are) " + errors.size() + " errors!");
			for (Error it : errors) {
				System.out.println(it.toString());
			}
		}
	}
	
	public Boolean i2b(Integer x) {
		if (x == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public Integer b2i(boolean x) {
		if (x == true) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int sizeof(Type type) {
		if (type instanceof CharType) {
			return 1;
		} else if (type instanceof IntType) {
			return 4;
		} else if (type instanceof PointerType) {
			return 4;
		} else if (type instanceof ArrayType) {
			ArrayType tmp = (ArrayType)type;
			if (tmp.sizeOf != -1) {
				return tmp.sizeOf;
			} else {
				return tmp.sizeOf = sizeof(tmp.baseType) * tmp.size;
			}
		} else if (type instanceof StructType) {
			StructDecl st = (StructDecl)(env.getByType(((StructType)type).tag));
			if (st.sizeOf != -1) {
				return st.sizeOf;
			} else {
				int ret = 0;
				for (VarDecl i : st.fields) {
					ret += sizeof(i.type);
				}
				return st.sizeOf = ret;
			}
		} else if (type instanceof UnionType) {
			UnionDecl ut = (UnionDecl)(env.getByType(((UnionType)type).tag));
			if (ut.sizeOf != -1) {
				return ut.sizeOf;
			} else {
				int ret = 0;
				for (VarDecl i : ut.fields) {
					ret = Math.max(ret, sizeof(i.type));
				}
				return ut.sizeOf = ret;
			}
		} else if (type instanceof VoidType) {
			return 1;
		} else {
			error("Unknown sizeof type");
			return 0;
		}
	}
	
	public boolean sameType(Type a, Type b) {
		if (a instanceof IntType && b instanceof IntType) {
			return true;
		} else if (a instanceof CharType && b instanceof CharType) {
			return true;
		} else if (a instanceof VoidType && b instanceof VoidType) {
			return true;
		} else if (a instanceof PointerType && b instanceof PointerType) {
			return sameType(((PointerType)a).baseType, ((PointerType)b).baseType);
		} else if (a instanceof ArrayType && b instanceof ArrayType) {
			return sameType(((ArrayType)a).baseType, ((ArrayType)b).baseType);
		} else if (a instanceof StructType && b instanceof StructType) {
			return ((StructType)a).tag == ((StructType)b).tag;
		} else if (a instanceof UnionType && b instanceof UnionType) {
			return ((UnionType)a).tag == ((UnionType)b).tag;
		} else {
			error("Impossible Type!!");
			return false;
		}
	}
	
	public boolean transable(Type a, Type b) {
		if (b instanceof VoidType) {
			return true;
		} else if (b instanceof StructType) {
			if (!(a instanceof StructType)) {
				return false;
			} else {
				return ((StructType)a).tag == ((StructType)b).tag;
			}
		} else if (b instanceof UnionType) {
			if (!(a instanceof UnionType)) {
				return false;
			} else {
				return ((UnionType)a).tag == ((UnionType)b).tag;
			}
		}
		
		if (a instanceof StructType || a instanceof UnionType) {
			return false;
		}
		
		if (b instanceof ArrayType) {
			return false;
		}
		
		return true;
	}
	
	public boolean funcTransable(Type a, Type b) {
		if (b instanceof VoidType) {
			return true;
		} else if (b instanceof StructType) {
			if (!(a instanceof StructType)) {
				return false;
			} else {
				return ((StructType)a).tag == ((StructType)b).tag;
			}
		} else if (b instanceof UnionType) {
			if (!(a instanceof UnionType)) {
				return false;
			} else {
				return ((UnionType)a).tag == ((UnionType)b).tag;
			}
		}
		
		if (a instanceof StructType || a instanceof UnionType) {
			return false;
		}
		
		return true;
	}
	
	public boolean intOrChar(Type a) {
		return (a instanceof IntType || a instanceof CharType);
	}
	
	private void checkDecl(Decl decl) {
		if (decl instanceof FunctionDecl) {
			checkFunctionDecl((FunctionDecl) decl);
		} else if (decl instanceof StructDecl) {
			checkStructDecl((StructDecl) decl);
		} else if (decl instanceof UnionDecl) {
			checkUnionDecl((UnionDecl) decl);
		} else if (decl instanceof VarDecl) {
			checkVarDecl((VarDecl) decl);
		}
	}
	
	private void checkAST(AST ast) {
		for (Decl decl : ast.decls) {
			checkDecl(decl);
		}
	}
	
	private void checkFunctionDecl(FunctionDecl decl) {
		//printf
		//malloc
		//getchar
		if (env.redByIden(decl.name)) {
			error("Function redeclared");
		}
		env.putIden(decl.name, decl);
		checkType(decl.returnType);
		
		env.beginScope();
		checkParams(decl.params);
		checkCompoundStmt(decl.body, decl.returnType);
		env.endScope();
	}
	
	private void checkStructDecl(StructDecl decl) {
		if (env.redByType(decl.tag)) {
			error("Struct redeclared");
		}
		env.putType(decl.tag, decl);
		env.beginScope();
		for (VarDecl var : decl.fields) {
			checkVarDecl(var);
		}
		env.endScope();
	}
	
	private void checkUnionDecl(UnionDecl decl) {
		if (env.redByType(decl.tag)) {
			error("Union redeclared");
		}
		env.putType(decl.tag, decl);
		env.beginScope();
		for (VarDecl var : decl.fields) {
			checkVarDecl(var);
		}
		env.endScope();
	}
	
	private void checkVarDecl(VarDecl decl) {
		if (env.level == 0) {
			if (decl.init != null) {
				if (env.initset.contains(decl.name.toString())) {
					error("level 0 reinitialize");
				} else {
					env.initset.add(decl.name.toString());
				}
			}
			Decl tmp = env.getByIden(decl.name);
			if (tmp != null) {
				if (tmp instanceof FunctionDecl) {
					error("Function define previous!  level 0!");
				} else {
					VarDecl tmp2 = (VarDecl)tmp;
					if (!sameType(tmp2.type, decl.type)) {
						error("conflicting type! level0!");
					}
				}
			}
		} else {
			if (env.redByIden(decl.name)) {
				error("Var redeclared");
			}
		}
		env.putIden(decl.name, decl);
		checkType(decl.type);
		if (decl.type instanceof VoidType) {
			error("Can't define voidType!");
		}
		if (decl.init != null) {
			checkInitializer(decl.init, decl.type, true);
		}
	}
	
	private void checkInitializer(Initializer init, Type type, boolean flag) {
		if (init instanceof InitValue) {
			ExprInfo info = checkExpr(((InitValue)init).expr);
			if (info == null) {
				return ;
			}
			if (!flag) {
				return ;
			}
			
			if (info.type instanceof PointerType && ((PointerType)info.type).baseType instanceof VoidType) {
				return ;
			}
			
			if (info.type instanceof StringType) {
				if (type instanceof PointerType) {
					return ;
				} else if (type instanceof ArrayType 
						&& ((ArrayType)type).baseType instanceof CharType) {
					return ;
				}
			}
			
			if (type instanceof ArrayType) {
				error("Can't pass a single value to an ArrayType!");
				return ;
			}
			
			if (env.getLevel() == 0 && info.isConst == null) {
				error("Initialier value must be const in global!");
			}
			
			if (info != null && funcTransable(info.type, type) == false) {
				error("Initializer type error");
			}
		} else if (init instanceof InitList) {
			if (flag && ((InitList)init).inits.size() == 0) {
				error("Initlist can't be empty!");
				return ;
			}
			
			Initializer o = init;
			while (o instanceof InitList && ((InitList)o).inits.size() == 1) {
				o = ((InitList)o).inits.get(0);
			}
			
			if (o instanceof InitValue) {
				ExprInfo info = checkExpr(((InitValue)o).expr);
				if (info.type instanceof StringType) {
					checkInitializer(o, type, flag);
					return ;
				}
			}
			
			Type tmp;
			if (type instanceof PointerType) {
				tmp = ((PointerType)type).baseType;
			} else if (type instanceof ArrayType) {
				tmp = ((ArrayType)type).baseType;
			} else {
				boolean first = true;
				for (Initializer i : ((InitList)init).inits) {
					checkInitializer(i, type, first);
					first = false;
				}
				return ;
			}
			
			if (flag) {
				for (Initializer i : ((InitList)init).inits) {
					checkInitializer(i, tmp, true);
				}
			} else {
				boolean first = true;
				for (Initializer i : ((InitList)init).inits) {
					checkInitializer(i, type, first);
					first = false;
				}
			}
		} else {
			error("Unknown in Initializer !");
		}
	}
	
	private void checkType(Type type) {
		if (type instanceof PointerType) {
			
		} else if (type instanceof StructType) {
			Decl obj = env.getByType(((StructType)type).tag);
			if (obj != null && (obj instanceof StructDecl)) {
				return ;
			} else {
				error("type declare error Struct");
			}
		} else if (type instanceof UnionType) {
			Decl obj = env.getByType(((UnionType)type).tag);
			if (obj != null && (obj instanceof UnionDecl)) {
				return ;
			} else {
				error("type declare error Union");
			}
		} else if (type instanceof ArrayType) {
			ArrayType array = (ArrayType)type;
			checkType(array.baseType);
			ExprInfo expr = checkExpr(array.arraySize);
			if (expr != null && expr.isConst == null) {
				error("global and not const arraySize");
				return ;
			}
			if (expr != null && expr.isConst < 0) {
				error("arraySize can't be negtive!");
				return ;
			}
			array.size = expr.isConst;
		} else {
			// int char void ... 
		}
	}
	
	private void checkParams(List<VarDecl> params) {
		for (VarDecl it : params) {
			checkVarDecl(it);
		}
	}
	
	private void checkCompoundStmt(CompoundStmt cstmt, Type retType) {
		env.beginScope();
		for (Decl decl : cstmt.decls) {
			checkDecl(decl);
		}
		for (Stmt stmt : cstmt.stats) {
			checkStmt(stmt, retType);
		}
		env.endScope();
	}
	
	private void checkStmt(Stmt stmt, Type retType) {
		if (stmt instanceof BreakStmt) {
			if (loopLevel == 0) {
				error("break out of loop");
			}
		} else if (stmt instanceof ContinueStmt) {
			if (loopLevel == 0) {
				error("continue out of loop");
			}
		} else if (stmt instanceof IfStmt) {
			IfStmt tmp = (IfStmt)stmt;
			if (tmp.condition != null) {
				ExprInfo info = checkExpr(tmp.condition);
				if (info != null && !transable(info.type, new IntType())) {
					error("IfStmt condition error");
				}
			} else {
				error("IfStmt condition can't be empty!");
			}
			checkStmt(tmp.consequent, retType);
			if (tmp.alternative != null) {
				checkStmt(tmp.alternative, retType);
			}
		} else if (stmt instanceof ForLoop) {
			ForLoop tmp = (ForLoop)stmt;
			if (tmp.init != null) {
				checkExpr(tmp.init);
			}
			if (tmp.condition != null) {
				ExprInfo info = checkExpr(tmp.condition);
				if (info != null && !transable(info.type, new IntType())) {
					error("Forloop condition error");
				}
			}
			if (tmp.step != null) { 
				checkExpr(tmp.step);
			}
			++loopLevel;
			checkStmt(tmp.body, retType);
			--loopLevel;
		} else if (stmt instanceof WhileLoop) {
			WhileLoop tmp = (WhileLoop)stmt;
			if (tmp.condition != null) {
				ExprInfo info = checkExpr(tmp.condition);
				if (info != null && !transable(info.type, new IntType())) {
					error("Forloop condition error");
				}
			} else {
				error("whileLoop condition can't be empty!");
			}
			loopLevel++;
			checkStmt(tmp.body, retType);
			loopLevel--;
		} else if (stmt instanceof ReturnStmt) {
			ReturnStmt tmp = (ReturnStmt)stmt;
			ExprInfo info = checkExpr(tmp.expr);
			if (info.type == null && !(retType instanceof VoidType)) {
				error("should return something!  ReturnStmt");
			}
			if (info.type != null && !transable(info.type, retType)) {
				error("return type can't transable to returnType");
			}
		} else if (stmt instanceof CompoundStmt) {
			checkCompoundStmt((CompoundStmt)stmt, retType);
		} else if (stmt instanceof Expr) {
			checkExpr((Expr)stmt);
		}
	}
	
	private ExprInfo checkExpr(Expr expr) {
		if (expr instanceof EmptyExpr) {
			return new ExprInfo(null, false, null);
		} else if (expr instanceof BinaryExpr) {
			return checkBinaryExpr((BinaryExpr)expr); 
		} else if (expr instanceof UnaryExpr) {
			return checkUnaryExpr((UnaryExpr)expr);
		} else if (expr instanceof SizeofExpr) {
			return checkSizeofExpr((SizeofExpr)expr);
		} else if (expr instanceof CastExpr) {
			return checkCastExpr((CastExpr)expr);
		} else if (expr instanceof PointerAccess) {
			return checkPointerAccess((PointerAccess)expr);
		} else if (expr instanceof RecordAccess) {
			return checkRecordAccess((RecordAccess)expr);
		} else if (expr instanceof SelfIncrement) {
			return checkSelfIncrement((SelfIncrement)expr);
		} else if (expr instanceof SelfDecrement) {
			return checkSelfDecrement((SelfDecrement)expr);
		} else if (expr instanceof ArrayAccess) {
			return checkArrayAccess((ArrayAccess)expr);
		} else if (expr instanceof FunctionCall) {
			return checkFunctionCall((FunctionCall)expr);
		} else if (expr instanceof Identifier) {
			return checkIdentifier((Identifier)expr);
		} else if (expr instanceof IntConst) {
			return new ExprInfo((Type)(new IntType()), false, ((IntConst)expr).value);
		} else if (expr instanceof CharConst) {
			return new ExprInfo((Type)(new CharType()), false, Integer.valueOf(((CharConst)expr).value));
		} else if (expr instanceof StringConst) {
			return new ExprInfo((Type)(new StringType(((StringConst)expr).value.length())), false, null);
		} else {
			error("Unknown Expression!");
			return null;
		}
	}	
	
	public Integer BinaryCalc(Integer left, BinaryOp op, Integer right) {
		if (left == null || right == null) {
			return null;
		}
		switch (op) {
		case ASSIGN: return right;
		case ASSIGN_MUL: return left * right;
		case ASSIGN_DIV: return left / right;
		case ASSIGN_MOD: return left % right;
		case ASSIGN_ADD: return left + right;
		case ASSIGN_SUB: return left - right;
		case ASSIGN_SHL: return left << right;
		case ASSIGN_SHR: return left >> right;
		case ASSIGN_AND: return left & right;
		case ASSIGN_XOR: return left ^ right;
		case ASSIGN_OR : return left | right;
		
		case LOGICAL_OR: return b2i(i2b(left) || i2b(right));
		case LOGICAL_AND: return b2i(i2b(left) && i2b(right));
		case OR : return left | right;
		case XOR: return left ^ right;
		case AND: return left & right;
		case EQ : return b2i(left.compareTo(right) == 0);
		case NE : return b2i(left.compareTo(right) != 0);
		case LT : return b2i(left.compareTo(right) < 0);
		case GT : return b2i(left.compareTo(right) > 0);
		case LE : return b2i(left.compareTo(right) <= 0);
		case GE : return b2i(left.compareTo(right) >= 0);
		case SHL : return left << right;
		case SHR : return left >> right;
		case ADD : return left + right;
		case SUB : return left - right;
		case MUL: return left * right;
		case DIV: return left / right;
		case MOD: return left % right;
		default: error("Impossible BinaryOp  " + op.toString()); return null;
		}
	}
	
	public ExprInfo checkBinaryExpr(BinaryExpr expr) {
		ExprInfo left = checkExpr(expr.left);
		BinaryOp op = expr.op;
		ExprInfo right = checkExpr(expr.right);
		if (left == null || right == null) {
			return null;
		}
		Integer retConst = BinaryCalc(left.isConst, op, right.isConst);
		if (op == BinaryOp.COMMA) {
			return right;
		} else if (op == BinaryOp.ASSIGN) {
			if (left.isLeft == false) {
				error("assign but not left value in (BinaryExpr 1)");
				return null;
			}
			if (!transable(right.type, left.type)) {
				error("assign but right type can't transform to left type");
				return null;
			}
			return new ExprInfo(left.type, false, retConst);
		} else if (op == BinaryOp.ASSIGN_ADD || op == BinaryOp.ASSIGN_SUB) { 
			if (left.isLeft == false) {
				error("assign but not left value in (BinaryExpr 2.1");
				return null;
			}
			if (!intOrChar(left.type) && !(left.type instanceof PointerType)) {
				return null;
			}
			return new ExprInfo(left.type, false, retConst);
		} else if (op == BinaryOp.ASSIGN_MUL || op == BinaryOp.ASSIGN_DIV || op == BinaryOp.ASSIGN_MOD
				|| op == BinaryOp.ASSIGN_SHR || op == BinaryOp.ASSIGN_AND || op == BinaryOp.ASSIGN_XOR
				|| op == BinaryOp.ASSIGN_OR || op == BinaryOp.ASSIGN_SHL) {
			if (left.isLeft == false) {
				error("assign but not left value in (BinaryExpr 2.2)");
				return null;
			}
			if (!intOrChar(left.type)) {
				error("Illegal left type in (BinaryExpr 2.3)");
				return null;
			}
			if (!intOrChar(right.type)) {
				error("Illegal right type in (BinaryExpr 2.4");
				return null;
			}
			return new ExprInfo(left.type, false, retConst);
		} else if (op == BinaryOp.LOGICAL_OR || op == BinaryOp.LOGICAL_AND) {
			if (!transable(left.type, new IntType()) || !transable(right.type, new IntType())) {
				error("illegal type in LOGICAL OR or AND in (BinaryExpr 4)");
				return null;
			}
			return new ExprInfo(new IntType(), false, retConst);
		} else if (op == BinaryOp.OR || op == BinaryOp.XOR || op == BinaryOp.AND) {
			if (!intOrChar(left.type) || !intOrChar(right.type)) {
				error("illegal type in OR or XOR or AND in (BinaryExpr 5)");
				return null;
			}
			return new ExprInfo(new IntType(), false, retConst);
		} else if (op == BinaryOp.EQ || op == BinaryOp.NE || op == BinaryOp.LT || op == BinaryOp.GT
				|| op == BinaryOp.LE || op == BinaryOp.GE) {
			if (!transable(left.type, new IntType()) || !transable(right.type, new IntType())) {
				error("illegal type in EQ ~ GE in (BinaryExpr 6)");
				return null;
			}
			return new ExprInfo(new IntType(), false, retConst);
		} else if (op == BinaryOp.SHL || op == BinaryOp.SHR) {
			if (!intOrChar(left.type) || !intOrChar(right.type)) {
				error("illegal type in << or >> in (BinaryExpr 7");
				return null;
			}
			return new ExprInfo(new IntType(), false, retConst);
		} else if (op == BinaryOp.ADD || op == BinaryOp.SUB) {
			if (!transable(left.type, new IntType()) || !transable(right.type, new IntType())) {
				error("Illegal type in (BinaryExpr 8.1");
				return null;
			}
			if (!intOrChar(left.type) && !intOrChar(right.type)) {
				return new ExprInfo(new IntType(), false, retConst);
			} else if (left.type instanceof PointerType || left.type instanceof ArrayType
					|| left.type instanceof StringType) {
				return new ExprInfo(left.type, false, retConst);
			} else if (right.type instanceof PointerType || right.type instanceof ArrayType
					|| right.type instanceof StringType) {
				return new ExprInfo(right.type, false, retConst);	
			} else {
				return new ExprInfo(new IntType(), false, retConst);
			}
		} else if (op == BinaryOp.MUL || op == BinaryOp.DIV || op == BinaryOp.MOD) {
			if (!intOrChar(left.type) || !intOrChar(right.type)) {
				error("Illegal type in (BinaryExpr 9)");
				return null;
			}
			return new ExprInfo(new IntType(), false, retConst);
			
		} else {
			error("Unknown BinaryOp!");
			return null;
		}
	}
	
	public ExprInfo checkUnaryExpr(UnaryExpr expr) {
		ExprInfo tmp = checkExpr(expr.expr);
		if (tmp == null) {
			return null;
		}
		UnaryOp sign = expr.op;
		if (sign == UnaryOp.INC || sign == UnaryOp.DEC) {
			if (tmp.isLeft == false) {
				error("not left value in UnaryExpr (INC or DEC)");
				return null;
			}
			if (tmp.type instanceof IntType || tmp.type instanceof CharType 
					|| tmp.type instanceof PointerType) {
				return new ExprInfo(tmp.type, false, null);
			} else {
				error("not int or char or pointer in UnaryExpr (INC or DEC)");
				return null;
			}
		} else if (sign == UnaryOp.ASTERISK) {
			if (tmp.type instanceof ArrayType) {
				Type baseType = ((ArrayType)tmp.type).baseType;
				if (baseType instanceof VoidType) { //!!!!!
					error("Can't fetch void value");
					return null;
				}
				if (baseType instanceof ArrayType) {
					return new ExprInfo(baseType, false, null);
				} else {
					return new ExprInfo(baseType, true, null);
				}
			} else if (tmp.type instanceof PointerType) {
				Type baseType = ((PointerType)tmp.type).baseType;
				if (baseType instanceof VoidType) { //!!!!!
					error("Can't fetch void value");
					return null;
				}
				return new ExprInfo(baseType, true, null);
			} else if (tmp.type instanceof StringType) {
				return new ExprInfo(new CharType(), false, null);
			} else {
				error("illegal type in UnaryExpr (*)");
				return null;
			}
		} else if (sign == UnaryOp.AMPERSAND) {
			if (tmp.isLeft == false) {
				error("not left value in UnaryExpr (&)");
				return null;
			} else {
				return new ExprInfo(new PointerType(tmp.type), false, null);
			}
		} else if (sign == UnaryOp.SIZEOF) {
			return new ExprInfo(new IntType(), false, sizeof(tmp.type));
		} else if (sign == UnaryOp.PLUS || sign == UnaryOp.MINUS || sign == UnaryOp.TILDE) {
			if (tmp.type instanceof IntType || tmp.type instanceof CharType) {
				if (tmp.isConst == null) {
					return new ExprInfo(new IntType(), false, null);
				}
				switch (sign) {
				case PLUS : return new ExprInfo(new IntType(), false, tmp.isConst);
				case MINUS: return new ExprInfo(new IntType(), false, -tmp.isConst); 
				case TILDE: return new ExprInfo(new IntType(), false, ~tmp.isConst);
				default: error("Impossible UnaryOp Here!"); return null;
				}
			} else {
				error("illegal type in UnaryExpr (sizeof)");
				return null;
			}
		} else if (sign == UnaryOp.NOT) {
			if (tmp.type instanceof IntType || tmp.type instanceof CharType 
					|| tmp.type instanceof PointerType) {
				return new ExprInfo(new IntType(), false, null);
			} else {
				error("illeagal type in UnaryExpr (not !)");
				return null;
			}
		} else {
			error("Unknown UnaryOp!");
			return null;
		}
	}
	
	public ExprInfo checkSizeofExpr(SizeofExpr expr) {
		checkType(expr.type);
		return new ExprInfo(new IntType(), false, sizeof(expr.type));
	}
	
	public ExprInfo checkCastExpr(CastExpr expr) { 
		checkType(expr.cast);
		ExprInfo tmp = checkExpr(expr.expr);
		if (tmp == null) {
			return null;
		}
		if (tmp != null && !transable(tmp.type, expr.cast)) {
			error("Case expression transform error");
			return null;
		} else {
			return new ExprInfo(expr.cast, true, null);
		}
	}
	
	public ExprInfo checkPointerAccess(PointerAccess expr) {
		ExprInfo body = checkExpr(expr.body);
		if (body == null) {
			return null;
		}
		
		Type type = body.type;
		if (type instanceof ArrayType) {
			type = new PointerType(((ArrayType) type).baseType);
		}
		if (type instanceof PointerType) {
			Type base = ((PointerType)type).baseType;
			if (base instanceof StructType) {
				Object tmp = env.getByType(((StructType)base).tag);
				if (tmp == null) {
					error("Undefined struct in PointerAccess");
					return null;
				} else {
					StructDecl decl = (StructDecl)tmp;
					for (VarDecl it : decl.fields) {
						if (expr.attribute == it.name) {
							return new ExprInfo(it.type, true, null);
						}
					}
					error("PointerAcess attribute not exist (struct)");
					return null;
				}
			} else if (base instanceof UnionType) {
				Object tmp = env.getByType(((UnionType)base).tag);
				if (tmp == null) {
					error("Undefined union in PointerAccess");
					return null;
				} else {
					UnionDecl decl = (UnionDecl)tmp;
					for (VarDecl it : decl.fields) {
						if (expr.attribute == it.name) {
							if (expr.attribute == it.name) {
								return new ExprInfo(it.type, true, null);
							}
						}
					}
					error("PointerAcess attribute not exist (union)");
					return null;
				}
			} else {
				error("PointerAccess baseType not struct or union");
				return null;
			}
		} else {
			error("PointerAccess (not pointer) error");
			return null;
		}
	}
	
	public ExprInfo checkRecordAccess(RecordAccess expr) {
		ExprInfo body = checkExpr(expr.body);
		if (body == null) {
			return null;
		}
		
		Type type = body.type;
		if (type instanceof StructType) {
			Object tmp = env.getByType(((StructType)type).tag);
			if (tmp == null) {
				error("Undefined struct in recordAccess!");
				return null;
			} else {
				StructDecl decl = (StructDecl)tmp;
				for (VarDecl it : decl.fields) {
					if (it.name == expr.attribute) {
						return new ExprInfo(it.type, true, null);
					}
				}
				error("RecordAccess attribute not exist (struct)");
				return null;
			}
		} else if (type instanceof UnionType) {
			Object tmp = env.getByType(((UnionType)type).tag);
			if (tmp == null) {
				error("Undefined union in recordAccess!");
				return null;
			} else {
				UnionDecl decl = (UnionDecl)tmp;
				for (VarDecl it : decl.fields) {
					if (it.name == expr.attribute) {
						return new ExprInfo(it.type, true, null);
					}
				}
				error("RecordAccess attribute not exist (union)");
				return null;
			}
		} else {
			error("RecordAccess error (not struct or union)");
			return null;
		}
	}
	
	public ExprInfo checkSelfIncrement(SelfIncrement expr) {
		ExprInfo tmp = checkExpr(expr.body);
		if (tmp == null) {
			return null;
		}
		
		if (tmp.isLeft == false) {
			error("selfincrement on left value");
			return null;
		}
		
		Type type = tmp.type;
		if (type instanceof IntType || type instanceof CharType || type instanceof PointerType) {
			return new ExprInfo(type, false, null);
		} else {
			error("unknown type selfincrement");
			return null;
		}
	}
	
	public ExprInfo checkSelfDecrement(SelfDecrement expr) {
		ExprInfo tmp = checkExpr(expr.body);
		if (tmp == null) {
			return null;
		}
		
		if (tmp.isLeft == false) {
			error("selfdecrement on left value");
			return null;
		}
		
		Type type = tmp.type;
		if (type instanceof IntType || type instanceof CharType || type instanceof PointerType) {
			return new ExprInfo(type, false, null);
		} else {
			error("unknown type selfdecrement");
			return null;
		}
	}
	
	public ExprInfo checkArrayAccess(ArrayAccess expr) {
		ExprInfo body = checkExpr(expr.body);
		if (body == null) {
			return null;
		}
		
		Type base;
		if (body.type instanceof ArrayType) {
			base = ((ArrayType)body.type).baseType;
		} else if (body.type instanceof PointerType) {
			base = ((PointerType)body.type).baseType;
		} else if (body.type instanceof StringType) {
			base = new CharType();
		} else {
			error("ArrayAccess body type is not arrayType or pointerType");
			return null;
		}
		ExprInfo subscript = checkExpr(expr.subscript);
		if (subscript == null) {
			return null;
		}
		if (!(subscript.type instanceof IntType) && !(subscript.type instanceof CharType)) {
			error("ArrayAccess subscript is not integer or char");
		}
		if (base instanceof ArrayType) {
			return new ExprInfo(base, false, Integer.valueOf(0));
		} else {
			return new ExprInfo(base, true, null);
		}
	}
	
	public ExprInfo checkFunctionCall(FunctionCall expr) {
		if (expr.body == Symbol.get("printf")) {
			List<Expr> args = expr.args;
			if (args.size() == 0) {
				error("printf args can't be empty!");
				return null;
			}
			ExprInfo info = checkExpr(args.get(0));
			if (!(info.type instanceof StringType) 
				&& !(info.type instanceof ArrayType && ((ArrayType)info.type).baseType instanceof CharType)
				&& !(info.type instanceof PointerType && ((PointerType)info.type).baseType instanceof CharType)) {
				//error("")
				error("printf args[0] must be wrong!");
				return null;
			}
			for (int i = 1; i < args.size(); i++) {
				info = checkExpr(args.get(i));
				if (info == null) {
					return null;
				}
				if (info.type instanceof VoidType) {
					error("printf args can't be void");
					return null;
				}
			}
			return new ExprInfo(new IntType(), false, null);
		} else if (expr.body == Symbol.get("malloc")) {
			List<Expr> args = expr.args;
			if (args.size() != 1) {
				error("malloc have exactly one arg!");
				return null;
			}
			ExprInfo tmp = checkExpr(args.get(0));
			if (tmp == null) {
				return null;
			}
			Type type = tmp.type;
			if (!intOrChar(type) && !(type instanceof PointerType) && !(type instanceof ArrayType)) {
				error("Illegal args type in malloc");
				return null;
			}
			return new ExprInfo(new PointerType(new VoidType()), false, null);
		} else if (expr.body == Symbol.get("getchar")) {
			if (expr.args.size() != 0) {
				error("getchar have no args!");
				return null;
			}
			return new ExprInfo(new CharType(), false, null);
		}
		
		Object tmp = env.getByIden(expr.body);
		if (tmp == null) {
			error("Undefined function in functionCall");
			return null;
		}
		
		if (!(tmp instanceof FunctionDecl)) {
			error("This symbol is not function in functionCall");
			return null;
		}
		
		FunctionDecl func = (FunctionDecl)tmp;
		List<VarDecl> params = func.params;
		
		if (params.size() == 0) {
			return new ExprInfo(func.returnType, false, null);
		} else {
			if (params.size() != expr.args.size()) {
				error("FunctionCall parameters number is not equal");
				return null;
			}
			for (int i = 0; i < params.size(); i++) {
				ExprInfo info = checkExpr(expr.args.get(i));
				if (info == null) {
					return null;
				}
				if (!funcTransable(info.type, params.get(i).type)) {
					error("");
					error(func.name.toString() + " at " + i);
					error("FunctionCall parameters type not match");
					return null;
				}
			}
			return new ExprInfo(func.returnType, false, null);
		}
	}
	
	public ExprInfo checkIdentifier(Identifier expr) {
		Object tmp = env.getByIden(expr.symbol);
		if (tmp == null) {
			error("Undefined identifier!");
			return null;
		}
		/*
		if (!(tmp instanceof Type)) {
			System.err.println("!!!!!!! " + expr.symbol.toString());
			return null;
		}
		*/
		Decl decl = (Decl)tmp;
		if (decl instanceof FunctionDecl) {
			error("Identifier associated to functionDecl!");
			return null;
		} else if (decl instanceof VarDecl) {
			Type type = ((VarDecl)decl).type;
			if (type instanceof ArrayType) {
				return new ExprInfo(type, false, Integer.valueOf(0));
			} else {
				return new ExprInfo(type, true, null);
			}
		} else {
			error("Identifier Impossible!");
			return null;
		}
	}
}
