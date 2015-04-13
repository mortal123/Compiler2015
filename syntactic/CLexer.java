// Generated from C.g4 by ANTLR 4.5

    package Compiler2015.syntactic;
 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, Identifier=57, Constant=58, StringLiteral=59, 
		LineDirective=60, PragmaDirective=61, Whitespace=62, Newline=63, BlockComment=64, 
		LineComment=65;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
		"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "Identifier", 
		"IdentifierNondigit", "Nondigit", "Digit", "UniversalCharacterName", "HexQuad", 
		"Constant", "IntegerConstant", "DecimalConstant", "OctalConstant", "HexadecimalConstant", 
		"HexadecimalPrefix", "NonzeroDigit", "OctalDigit", "HexadecimalDigit", 
		"IntegerSuffix", "UnsignedSuffix", "LongSuffix", "LongLongSuffix", "FloatingConstant", 
		"DecimalFloatingConstant", "HexadecimalFloatingConstant", "FractionalConstant", 
		"ExponentPart", "Sign", "DigitSequence", "HexadecimalFractionalConstant", 
		"BinaryExponentPart", "HexadecimalDigitSequence", "FloatingSuffix", "CharacterConstant", 
		"CCharSequence", "CChar", "EscapeSequence", "SimpleEscapeSequence", "OctalEscapeSequence", 
		"HexadecimalEscapeSequence", "StringLiteral", "EncodingPrefix", "SCharSequence", 
		"SChar", "LineDirective", "PragmaDirective", "Whitespace", "Newline", 
		"BlockComment", "LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "','", "'='", "'{'", "'}'", "'void'", "'char'", 
		"'int'", "'struct'", "'union'", "'['", "']'", "'*'", "'if'", "'else'", 
		"'while'", "'for'", "'continue'", "'break'", "'return'", "'*='", "'/='", 
		"'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'||'", 
		"'&&'", "'|'", "'^'", "'&'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", 
		"'<<'", "'>>'", "'+'", "'-'", "'/'", "'%'", "'++'", "'--'", "'sizeof'", 
		"'~'", "'!'", "'.'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "Identifier", "Constant", 
		"StringLiteral", "LineDirective", "PragmaDirective", "Whitespace", "Newline", 
		"BlockComment", "LineComment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2C\u02f1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3"+
		"%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3"+
		".\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3"+
		"\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\3"+
		"9\39\3:\3:\3:\7:\u018c\n:\f:\16:\u018f\13:\3;\3;\5;\u0193\n;\3<\3<\3="+
		"\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u01a3\n>\3?\3?\3?\3?\3?\3@\3@\5@"+
		"\u01ac\n@\3A\3A\5A\u01b0\nA\3A\3A\5A\u01b4\nA\3A\3A\5A\u01b8\nA\5A\u01ba"+
		"\nA\3B\3B\7B\u01be\nB\fB\16B\u01c1\13B\3C\3C\7C\u01c5\nC\fC\16C\u01c8"+
		"\13C\3D\3D\6D\u01cc\nD\rD\16D\u01cd\3E\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\5"+
		"I\u01db\nI\3I\3I\3I\3I\3I\5I\u01e2\nI\3I\3I\5I\u01e6\nI\5I\u01e8\nI\3"+
		"J\3J\3K\3K\3L\3L\3L\3L\5L\u01f2\nL\3M\3M\5M\u01f6\nM\3N\3N\5N\u01fa\n"+
		"N\3N\5N\u01fd\nN\3N\3N\3N\5N\u0202\nN\5N\u0204\nN\3O\3O\3O\3O\5O\u020a"+
		"\nO\3O\3O\3O\3O\5O\u0210\nO\5O\u0212\nO\3P\5P\u0215\nP\3P\3P\3P\3P\3P"+
		"\5P\u021c\nP\3Q\3Q\5Q\u0220\nQ\3Q\3Q\3Q\5Q\u0225\nQ\3Q\5Q\u0228\nQ\3R"+
		"\3R\3S\6S\u022d\nS\rS\16S\u022e\3T\5T\u0232\nT\3T\3T\3T\3T\3T\5T\u0239"+
		"\nT\3U\3U\5U\u023d\nU\3U\3U\3U\5U\u0242\nU\3U\5U\u0245\nU\3V\6V\u0248"+
		"\nV\rV\16V\u0249\3W\3W\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3"+
		"X\3X\3X\3X\3X\3X\3X\5X\u0264\nX\3Y\6Y\u0267\nY\rY\16Y\u0268\3Z\3Z\5Z\u026d"+
		"\nZ\3[\3[\3[\3[\5[\u0273\n[\3\\\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]"+
		"\3]\5]\u0283\n]\3^\3^\3^\3^\6^\u0289\n^\r^\16^\u028a\3_\5_\u028e\n_\3"+
		"_\3_\5_\u0292\n_\3_\3_\3`\3`\3`\5`\u0299\n`\3a\6a\u029c\na\ra\16a\u029d"+
		"\3b\3b\5b\u02a2\nb\3c\3c\5c\u02a6\nc\3c\3c\5c\u02aa\nc\3c\3c\7c\u02ae"+
		"\nc\fc\16c\u02b1\13c\3c\3c\3d\3d\5d\u02b7\nd\3d\3d\3d\3d\3d\3d\3d\3d\3"+
		"d\7d\u02c2\nd\fd\16d\u02c5\13d\3d\3d\3e\6e\u02ca\ne\re\16e\u02cb\3e\3"+
		"e\3f\3f\5f\u02d2\nf\3f\5f\u02d5\nf\3f\3f\3g\3g\3g\3g\7g\u02dd\ng\fg\16"+
		"g\u02e0\13g\3g\3g\3g\3g\3g\3h\3h\3h\3h\7h\u02eb\nh\fh\16h\u02ee\13h\3"+
		"h\3h\3\u02de\2i\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\67m8o9q:s;u\2w\2y\2{\2}\2\177<\u0081\2\u0083\2\u0085\2\u0087"+
		"\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099"+
		"\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab"+
		"\2\u00ad\2\u00af\2\u00b1\2\u00b3\2\u00b5\2\u00b7\2\u00b9\2\u00bb\2\u00bd"+
		"=\u00bf\2\u00c1\2\u00c3\2\u00c5>\u00c7?\u00c9@\u00cbA\u00cdB\u00cfC\3"+
		"\2\22\5\2C\\aac|\3\2\62;\4\2ZZzz\3\2\63;\3\2\629\5\2\62;CHch\4\2WWww\4"+
		"\2NNnn\4\2--//\6\2HHNNhhnn\6\2\f\f\17\17))^^\f\2$$))AA^^cdhhppttvvxx\5"+
		"\2NNWWww\6\2\f\f\17\17$$^^\4\2\f\f\17\17\4\2\13\13\"\"\u030c\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2\177\3\2\2\2\2\u00bd\3\2\2\2\2\u00c5\3\2\2\2"+
		"\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf"+
		"\3\2\2\2\3\u00d1\3\2\2\2\5\u00d3\3\2\2\2\7\u00d5\3\2\2\2\t\u00d7\3\2\2"+
		"\2\13\u00d9\3\2\2\2\r\u00db\3\2\2\2\17\u00dd\3\2\2\2\21\u00df\3\2\2\2"+
		"\23\u00e4\3\2\2\2\25\u00e9\3\2\2\2\27\u00ed\3\2\2\2\31\u00f4\3\2\2\2\33"+
		"\u00fa\3\2\2\2\35\u00fc\3\2\2\2\37\u00fe\3\2\2\2!\u0100\3\2\2\2#\u0103"+
		"\3\2\2\2%\u0108\3\2\2\2\'\u010e\3\2\2\2)\u0112\3\2\2\2+\u011b\3\2\2\2"+
		"-\u0121\3\2\2\2/\u0128\3\2\2\2\61\u012b\3\2\2\2\63\u012e\3\2\2\2\65\u0131"+
		"\3\2\2\2\67\u0134\3\2\2\29\u0137\3\2\2\2;\u013b\3\2\2\2=\u013f\3\2\2\2"+
		"?\u0142\3\2\2\2A\u0145\3\2\2\2C\u0148\3\2\2\2E\u014b\3\2\2\2G\u014e\3"+
		"\2\2\2I\u0150\3\2\2\2K\u0152\3\2\2\2M\u0154\3\2\2\2O\u0157\3\2\2\2Q\u015a"+
		"\3\2\2\2S\u015c\3\2\2\2U\u015e\3\2\2\2W\u0161\3\2\2\2Y\u0164\3\2\2\2["+
		"\u0167\3\2\2\2]\u016a\3\2\2\2_\u016c\3\2\2\2a\u016e\3\2\2\2c\u0170\3\2"+
		"\2\2e\u0172\3\2\2\2g\u0175\3\2\2\2i\u0178\3\2\2\2k\u017f\3\2\2\2m\u0181"+
		"\3\2\2\2o\u0183\3\2\2\2q\u0185\3\2\2\2s\u0188\3\2\2\2u\u0192\3\2\2\2w"+
		"\u0194\3\2\2\2y\u0196\3\2\2\2{\u01a2\3\2\2\2}\u01a4\3\2\2\2\177\u01ab"+
		"\3\2\2\2\u0081\u01b9\3\2\2\2\u0083\u01bb\3\2\2\2\u0085\u01c2\3\2\2\2\u0087"+
		"\u01c9\3\2\2\2\u0089\u01cf\3\2\2\2\u008b\u01d2\3\2\2\2\u008d\u01d4\3\2"+
		"\2\2\u008f\u01d6\3\2\2\2\u0091\u01e7\3\2\2\2\u0093\u01e9\3\2\2\2\u0095"+
		"\u01eb\3\2\2\2\u0097\u01f1\3\2\2\2\u0099\u01f5\3\2\2\2\u009b\u0203\3\2"+
		"\2\2\u009d\u0211\3\2\2\2\u009f\u021b\3\2\2\2\u00a1\u0227\3\2\2\2\u00a3"+
		"\u0229\3\2\2\2\u00a5\u022c\3\2\2\2\u00a7\u0238\3\2\2\2\u00a9\u0244\3\2"+
		"\2\2\u00ab\u0247\3\2\2\2\u00ad\u024b\3\2\2\2\u00af\u0263\3\2\2\2\u00b1"+
		"\u0266\3\2\2\2\u00b3\u026c\3\2\2\2\u00b5\u0272\3\2\2\2\u00b7\u0274\3\2"+
		"\2\2\u00b9\u0282\3\2\2\2\u00bb\u0284\3\2\2\2\u00bd\u028d\3\2\2\2\u00bf"+
		"\u0298\3\2\2\2\u00c1\u029b\3\2\2\2\u00c3\u02a1\3\2\2\2\u00c5\u02a3\3\2"+
		"\2\2\u00c7\u02b4\3\2\2\2\u00c9\u02c9\3\2\2\2\u00cb\u02d4\3\2\2\2\u00cd"+
		"\u02d8\3\2\2\2\u00cf\u02e6\3\2\2\2\u00d1\u00d2\7=\2\2\u00d2\4\3\2\2\2"+
		"\u00d3\u00d4\7*\2\2\u00d4\6\3\2\2\2\u00d5\u00d6\7+\2\2\u00d6\b\3\2\2\2"+
		"\u00d7\u00d8\7.\2\2\u00d8\n\3\2\2\2\u00d9\u00da\7?\2\2\u00da\f\3\2\2\2"+
		"\u00db\u00dc\7}\2\2\u00dc\16\3\2\2\2\u00dd\u00de\7\177\2\2\u00de\20\3"+
		"\2\2\2\u00df\u00e0\7x\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e2\7k\2\2\u00e2"+
		"\u00e3\7f\2\2\u00e3\22\3\2\2\2\u00e4\u00e5\7e\2\2\u00e5\u00e6\7j\2\2\u00e6"+
		"\u00e7\7c\2\2\u00e7\u00e8\7t\2\2\u00e8\24\3\2\2\2\u00e9\u00ea\7k\2\2\u00ea"+
		"\u00eb\7p\2\2\u00eb\u00ec\7v\2\2\u00ec\26\3\2\2\2\u00ed\u00ee\7u\2\2\u00ee"+
		"\u00ef\7v\2\2\u00ef\u00f0\7t\2\2\u00f0\u00f1\7w\2\2\u00f1\u00f2\7e\2\2"+
		"\u00f2\u00f3\7v\2\2\u00f3\30\3\2\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6\7"+
		"p\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7p\2\2\u00f9\32"+
		"\3\2\2\2\u00fa\u00fb\7]\2\2\u00fb\34\3\2\2\2\u00fc\u00fd\7_\2\2\u00fd"+
		"\36\3\2\2\2\u00fe\u00ff\7,\2\2\u00ff \3\2\2\2\u0100\u0101\7k\2\2\u0101"+
		"\u0102\7h\2\2\u0102\"\3\2\2\2\u0103\u0104\7g\2\2\u0104\u0105\7n\2\2\u0105"+
		"\u0106\7u\2\2\u0106\u0107\7g\2\2\u0107$\3\2\2\2\u0108\u0109\7y\2\2\u0109"+
		"\u010a\7j\2\2\u010a\u010b\7k\2\2\u010b\u010c\7n\2\2\u010c\u010d\7g\2\2"+
		"\u010d&\3\2\2\2\u010e\u010f\7h\2\2\u010f\u0110\7q\2\2\u0110\u0111\7t\2"+
		"\2\u0111(\3\2\2\2\u0112\u0113\7e\2\2\u0113\u0114\7q\2\2\u0114\u0115\7"+
		"p\2\2\u0115\u0116\7v\2\2\u0116\u0117\7k\2\2\u0117\u0118\7p\2\2\u0118\u0119"+
		"\7w\2\2\u0119\u011a\7g\2\2\u011a*\3\2\2\2\u011b\u011c\7d\2\2\u011c\u011d"+
		"\7t\2\2\u011d\u011e\7g\2\2\u011e\u011f\7c\2\2\u011f\u0120\7m\2\2\u0120"+
		",\3\2\2\2\u0121\u0122\7t\2\2\u0122\u0123\7g\2\2\u0123\u0124\7v\2\2\u0124"+
		"\u0125\7w\2\2\u0125\u0126\7t\2\2\u0126\u0127\7p\2\2\u0127.\3\2\2\2\u0128"+
		"\u0129\7,\2\2\u0129\u012a\7?\2\2\u012a\60\3\2\2\2\u012b\u012c\7\61\2\2"+
		"\u012c\u012d\7?\2\2\u012d\62\3\2\2\2\u012e\u012f\7\'\2\2\u012f\u0130\7"+
		"?\2\2\u0130\64\3\2\2\2\u0131\u0132\7-\2\2\u0132\u0133\7?\2\2\u0133\66"+
		"\3\2\2\2\u0134\u0135\7/\2\2\u0135\u0136\7?\2\2\u01368\3\2\2\2\u0137\u0138"+
		"\7>\2\2\u0138\u0139\7>\2\2\u0139\u013a\7?\2\2\u013a:\3\2\2\2\u013b\u013c"+
		"\7@\2\2\u013c\u013d\7@\2\2\u013d\u013e\7?\2\2\u013e<\3\2\2\2\u013f\u0140"+
		"\7(\2\2\u0140\u0141\7?\2\2\u0141>\3\2\2\2\u0142\u0143\7`\2\2\u0143\u0144"+
		"\7?\2\2\u0144@\3\2\2\2\u0145\u0146\7~\2\2\u0146\u0147\7?\2\2\u0147B\3"+
		"\2\2\2\u0148\u0149\7~\2\2\u0149\u014a\7~\2\2\u014aD\3\2\2\2\u014b\u014c"+
		"\7(\2\2\u014c\u014d\7(\2\2\u014dF\3\2\2\2\u014e\u014f\7~\2\2\u014fH\3"+
		"\2\2\2\u0150\u0151\7`\2\2\u0151J\3\2\2\2\u0152\u0153\7(\2\2\u0153L\3\2"+
		"\2\2\u0154\u0155\7?\2\2\u0155\u0156\7?\2\2\u0156N\3\2\2\2\u0157\u0158"+
		"\7#\2\2\u0158\u0159\7?\2\2\u0159P\3\2\2\2\u015a\u015b\7>\2\2\u015bR\3"+
		"\2\2\2\u015c\u015d\7@\2\2\u015dT\3\2\2\2\u015e\u015f\7>\2\2\u015f\u0160"+
		"\7?\2\2\u0160V\3\2\2\2\u0161\u0162\7@\2\2\u0162\u0163\7?\2\2\u0163X\3"+
		"\2\2\2\u0164\u0165\7>\2\2\u0165\u0166\7>\2\2\u0166Z\3\2\2\2\u0167\u0168"+
		"\7@\2\2\u0168\u0169\7@\2\2\u0169\\\3\2\2\2\u016a\u016b\7-\2\2\u016b^\3"+
		"\2\2\2\u016c\u016d\7/\2\2\u016d`\3\2\2\2\u016e\u016f\7\61\2\2\u016fb\3"+
		"\2\2\2\u0170\u0171\7\'\2\2\u0171d\3\2\2\2\u0172\u0173\7-\2\2\u0173\u0174"+
		"\7-\2\2\u0174f\3\2\2\2\u0175\u0176\7/\2\2\u0176\u0177\7/\2\2\u0177h\3"+
		"\2\2\2\u0178\u0179\7u\2\2\u0179\u017a\7k\2\2\u017a\u017b\7|\2\2\u017b"+
		"\u017c\7g\2\2\u017c\u017d\7q\2\2\u017d\u017e\7h\2\2\u017ej\3\2\2\2\u017f"+
		"\u0180\7\u0080\2\2\u0180l\3\2\2\2\u0181\u0182\7#\2\2\u0182n\3\2\2\2\u0183"+
		"\u0184\7\60\2\2\u0184p\3\2\2\2\u0185\u0186\7/\2\2\u0186\u0187\7@\2\2\u0187"+
		"r\3\2\2\2\u0188\u018d\5u;\2\u0189\u018c\5u;\2\u018a\u018c\5y=\2\u018b"+
		"\u0189\3\2\2\2\u018b\u018a\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2"+
		"\2\2\u018d\u018e\3\2\2\2\u018et\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0193"+
		"\5w<\2\u0191\u0193\5{>\2\u0192\u0190\3\2\2\2\u0192\u0191\3\2\2\2\u0193"+
		"v\3\2\2\2\u0194\u0195\t\2\2\2\u0195x\3\2\2\2\u0196\u0197\t\3\2\2\u0197"+
		"z\3\2\2\2\u0198\u0199\7^\2\2\u0199\u019a\7w\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u01a3\5}?\2\u019c\u019d\7^\2\2\u019d\u019e\7W\2\2\u019e\u019f\3\2\2\2"+
		"\u019f\u01a0\5}?\2\u01a0\u01a1\5}?\2\u01a1\u01a3\3\2\2\2\u01a2\u0198\3"+
		"\2\2\2\u01a2\u019c\3\2\2\2\u01a3|\3\2\2\2\u01a4\u01a5\5\u008fH\2\u01a5"+
		"\u01a6\5\u008fH\2\u01a6\u01a7\5\u008fH\2\u01a7\u01a8\5\u008fH\2\u01a8"+
		"~\3\2\2\2\u01a9\u01ac\5\u0081A\2\u01aa\u01ac\5\u00afX\2\u01ab\u01a9\3"+
		"\2\2\2\u01ab\u01aa\3\2\2\2\u01ac\u0080\3\2\2\2\u01ad\u01af\5\u0083B\2"+
		"\u01ae\u01b0\5\u0091I\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0"+
		"\u01ba\3\2\2\2\u01b1\u01b3\5\u0085C\2\u01b2\u01b4\5\u0091I\2\u01b3\u01b2"+
		"\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01ba\3\2\2\2\u01b5\u01b7\5\u0087D"+
		"\2\u01b6\u01b8\5\u0091I\2\u01b7\u01b6\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8"+
		"\u01ba\3\2\2\2\u01b9\u01ad\3\2\2\2\u01b9\u01b1\3\2\2\2\u01b9\u01b5\3\2"+
		"\2\2\u01ba\u0082\3\2\2\2\u01bb\u01bf\5\u008bF\2\u01bc\u01be\5y=\2\u01bd"+
		"\u01bc\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0\u0084\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c6\7\62\2\2\u01c3"+
		"\u01c5\5\u008dG\2\u01c4\u01c3\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4"+
		"\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u0086\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9"+
		"\u01cb\5\u0089E\2\u01ca\u01cc\5\u008fH\2\u01cb\u01ca\3\2\2\2\u01cc\u01cd"+
		"\3\2\2\2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u0088\3\2\2\2\u01cf"+
		"\u01d0\7\62\2\2\u01d0\u01d1\t\4\2\2\u01d1\u008a\3\2\2\2\u01d2\u01d3\t"+
		"\5\2\2\u01d3\u008c\3\2\2\2\u01d4\u01d5\t\6\2\2\u01d5\u008e\3\2\2\2\u01d6"+
		"\u01d7\t\7\2\2\u01d7\u0090\3\2\2\2\u01d8\u01da\5\u0093J\2\u01d9\u01db"+
		"\5\u0095K\2\u01da\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01e8\3\2\2"+
		"\2\u01dc\u01dd\5\u0093J\2\u01dd\u01de\5\u0097L\2\u01de\u01e8\3\2\2\2\u01df"+
		"\u01e1\5\u0095K\2\u01e0\u01e2\5\u0093J\2\u01e1\u01e0\3\2\2\2\u01e1\u01e2"+
		"\3\2\2\2\u01e2\u01e8\3\2\2\2\u01e3\u01e5\5\u0097L\2\u01e4\u01e6\5\u0093"+
		"J\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e8\3\2\2\2\u01e7"+
		"\u01d8\3\2\2\2\u01e7\u01dc\3\2\2\2\u01e7\u01df\3\2\2\2\u01e7\u01e3\3\2"+
		"\2\2\u01e8\u0092\3\2\2\2\u01e9\u01ea\t\b\2\2\u01ea\u0094\3\2\2\2\u01eb"+
		"\u01ec\t\t\2\2\u01ec\u0096\3\2\2\2\u01ed\u01ee\7n\2\2\u01ee\u01f2\7n\2"+
		"\2\u01ef\u01f0\7N\2\2\u01f0\u01f2\7N\2\2\u01f1\u01ed\3\2\2\2\u01f1\u01ef"+
		"\3\2\2\2\u01f2\u0098\3\2\2\2\u01f3\u01f6\5\u009bN\2\u01f4\u01f6\5\u009d"+
		"O\2\u01f5\u01f3\3\2\2\2\u01f5\u01f4\3\2\2\2\u01f6\u009a\3\2\2\2\u01f7"+
		"\u01f9\5\u009fP\2\u01f8\u01fa\5\u00a1Q\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa"+
		"\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01fd\5\u00adW\2\u01fc\u01fb\3\2\2"+
		"\2\u01fc\u01fd\3\2\2\2\u01fd\u0204\3\2\2\2\u01fe\u01ff\5\u00a5S\2\u01ff"+
		"\u0201\5\u00a1Q\2\u0200\u0202\5\u00adW\2\u0201\u0200\3\2\2\2\u0201\u0202"+
		"\3\2\2\2\u0202\u0204\3\2\2\2\u0203\u01f7\3\2\2\2\u0203\u01fe\3\2\2\2\u0204"+
		"\u009c\3\2\2\2\u0205\u0206\5\u0089E\2\u0206\u0207\5\u00a7T\2\u0207\u0209"+
		"\5\u00a9U\2\u0208\u020a\5\u00adW\2\u0209\u0208\3\2\2\2\u0209\u020a\3\2"+
		"\2\2\u020a\u0212\3\2\2\2\u020b\u020c\5\u0089E\2\u020c\u020d\5\u00abV\2"+
		"\u020d\u020f\5\u00a9U\2\u020e\u0210\5\u00adW\2\u020f\u020e\3\2\2\2\u020f"+
		"\u0210\3\2\2\2\u0210\u0212\3\2\2\2\u0211\u0205\3\2\2\2\u0211\u020b\3\2"+
		"\2\2\u0212\u009e\3\2\2\2\u0213\u0215\5\u00a5S\2\u0214\u0213\3\2\2\2\u0214"+
		"\u0215\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\7\60\2\2\u0217\u021c\5"+
		"\u00a5S\2\u0218\u0219\5\u00a5S\2\u0219\u021a\7\60\2\2\u021a\u021c\3\2"+
		"\2\2\u021b\u0214\3\2\2\2\u021b\u0218\3\2\2\2\u021c\u00a0\3\2\2\2\u021d"+
		"\u021f\7g\2\2\u021e\u0220\5\u00a3R\2\u021f\u021e\3\2\2\2\u021f\u0220\3"+
		"\2\2\2\u0220\u0221\3\2\2\2\u0221\u0228\5\u00a5S\2\u0222\u0224\7G\2\2\u0223"+
		"\u0225\5\u00a3R\2\u0224\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0226"+
		"\3\2\2\2\u0226\u0228\5\u00a5S\2\u0227\u021d\3\2\2\2\u0227\u0222\3\2\2"+
		"\2\u0228\u00a2\3\2\2\2\u0229\u022a\t\n\2\2\u022a\u00a4\3\2\2\2\u022b\u022d"+
		"\5y=\2\u022c\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022c\3\2\2\2\u022e"+
		"\u022f\3\2\2\2\u022f\u00a6\3\2\2\2\u0230\u0232\5\u00abV\2\u0231\u0230"+
		"\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0234\7\60\2\2"+
		"\u0234\u0239\5\u00abV\2\u0235\u0236\5\u00abV\2\u0236\u0237\7\60\2\2\u0237"+
		"\u0239\3\2\2\2\u0238\u0231\3\2\2\2\u0238\u0235\3\2\2\2\u0239\u00a8\3\2"+
		"\2\2\u023a\u023c\7r\2\2\u023b\u023d\5\u00a3R\2\u023c\u023b\3\2\2\2\u023c"+
		"\u023d\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0245\5\u00a5S\2\u023f\u0241"+
		"\7R\2\2\u0240\u0242\5\u00a3R\2\u0241\u0240\3\2\2\2\u0241\u0242\3\2\2\2"+
		"\u0242\u0243\3\2\2\2\u0243\u0245\5\u00a5S\2\u0244\u023a\3\2\2\2\u0244"+
		"\u023f\3\2\2\2\u0245\u00aa\3\2\2\2\u0246\u0248\5\u008fH\2\u0247\u0246"+
		"\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a"+
		"\u00ac\3\2\2\2\u024b\u024c\t\13\2\2\u024c\u00ae\3\2\2\2\u024d\u024e\7"+
		")\2\2\u024e\u024f\5\u00b1Y\2\u024f\u0250\7)\2\2\u0250\u0264\3\2\2\2\u0251"+
		"\u0252\7N\2\2\u0252\u0253\7)\2\2\u0253\u0254\3\2\2\2\u0254\u0255\5\u00b1"+
		"Y\2\u0255\u0256\7)\2\2\u0256\u0264\3\2\2\2\u0257\u0258\7w\2\2\u0258\u0259"+
		"\7)\2\2\u0259\u025a\3\2\2\2\u025a\u025b\5\u00b1Y\2\u025b\u025c\7)\2\2"+
		"\u025c\u0264\3\2\2\2\u025d\u025e\7W\2\2\u025e\u025f\7)\2\2\u025f\u0260"+
		"\3\2\2\2\u0260\u0261\5\u00b1Y\2\u0261\u0262\7)\2\2\u0262\u0264\3\2\2\2"+
		"\u0263\u024d\3\2\2\2\u0263\u0251\3\2\2\2\u0263\u0257\3\2\2\2\u0263\u025d"+
		"\3\2\2\2\u0264\u00b0\3\2\2\2\u0265\u0267\5\u00b3Z\2\u0266\u0265\3\2\2"+
		"\2\u0267\u0268\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u00b2"+
		"\3\2\2\2\u026a\u026d\n\f\2\2\u026b\u026d\5\u00b5[\2\u026c\u026a\3\2\2"+
		"\2\u026c\u026b\3\2\2\2\u026d\u00b4\3\2\2\2\u026e\u0273\5\u00b7\\\2\u026f"+
		"\u0273\5\u00b9]\2\u0270\u0273\5\u00bb^\2\u0271\u0273\5{>\2\u0272\u026e"+
		"\3\2\2\2\u0272\u026f\3\2\2\2\u0272\u0270\3\2\2\2\u0272\u0271\3\2\2\2\u0273"+
		"\u00b6\3\2\2\2\u0274\u0275\7^\2\2\u0275\u0276\t\r\2\2\u0276\u00b8\3\2"+
		"\2\2\u0277\u0278\7^\2\2\u0278\u0283\5\u008dG\2\u0279\u027a\7^\2\2\u027a"+
		"\u027b\5\u008dG\2\u027b\u027c\5\u008dG\2\u027c\u0283\3\2\2\2\u027d\u027e"+
		"\7^\2\2\u027e\u027f\5\u008dG\2\u027f\u0280\5\u008dG\2\u0280\u0281\5\u008d"+
		"G\2\u0281\u0283\3\2\2\2\u0282\u0277\3\2\2\2\u0282\u0279\3\2\2\2\u0282"+
		"\u027d\3\2\2\2\u0283\u00ba\3\2\2\2\u0284\u0285\7^\2\2\u0285\u0286\7z\2"+
		"\2\u0286\u0288\3\2\2\2\u0287\u0289\5\u008fH\2\u0288\u0287\3\2\2\2\u0289"+
		"\u028a\3\2\2\2\u028a\u0288\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u00bc\3\2"+
		"\2\2\u028c\u028e\5\u00bf`\2\u028d\u028c\3\2\2\2\u028d\u028e\3\2\2\2\u028e"+
		"\u028f\3\2\2\2\u028f\u0291\7$\2\2\u0290\u0292\5\u00c1a\2\u0291\u0290\3"+
		"\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294\7$\2\2\u0294"+
		"\u00be\3\2\2\2\u0295\u0296\7w\2\2\u0296\u0299\7:\2\2\u0297\u0299\t\16"+
		"\2\2\u0298\u0295\3\2\2\2\u0298\u0297\3\2\2\2\u0299\u00c0\3\2\2\2\u029a"+
		"\u029c\5\u00c3b\2\u029b\u029a\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029b"+
		"\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u00c2\3\2\2\2\u029f\u02a2\n\17\2\2"+
		"\u02a0\u02a2\5\u00b5[\2\u02a1\u029f\3\2\2\2\u02a1\u02a0\3\2\2\2\u02a2"+
		"\u00c4\3\2\2\2\u02a3\u02a5\7%\2\2\u02a4\u02a6\5\u00c9e\2\u02a5\u02a4\3"+
		"\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a9\5\u0083B\2"+
		"\u02a8\u02aa\5\u00c9e\2\u02a9\u02a8\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa"+
		"\u02ab\3\2\2\2\u02ab\u02af\5\u00bd_\2\u02ac\u02ae\n\20\2\2\u02ad\u02ac"+
		"\3\2\2\2\u02ae\u02b1\3\2\2\2\u02af\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0"+
		"\u02b2\3\2\2\2\u02b1\u02af\3\2\2\2\u02b2\u02b3\bc\2\2\u02b3\u00c6\3\2"+
		"\2\2\u02b4\u02b6\7%\2\2\u02b5\u02b7\5\u00c9e\2\u02b6\u02b5\3\2\2\2\u02b6"+
		"\u02b7\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02b9\7r\2\2\u02b9\u02ba\7t\2"+
		"\2\u02ba\u02bb\7c\2\2\u02bb\u02bc\7i\2\2\u02bc\u02bd\7o\2\2\u02bd\u02be"+
		"\7c\2\2\u02be\u02bf\3\2\2\2\u02bf\u02c3\5\u00c9e\2\u02c0\u02c2\n\20\2"+
		"\2\u02c1\u02c0\3\2\2\2\u02c2\u02c5\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c4"+
		"\3\2\2\2\u02c4\u02c6\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c6\u02c7\bd\2\2\u02c7"+
		"\u00c8\3\2\2\2\u02c8\u02ca\t\21\2\2\u02c9\u02c8\3\2\2\2\u02ca\u02cb\3"+
		"\2\2\2\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd"+
		"\u02ce\be\2\2\u02ce\u00ca\3\2\2\2\u02cf\u02d1\7\17\2\2\u02d0\u02d2\7\f"+
		"\2\2\u02d1\u02d0\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d5\3\2\2\2\u02d3"+
		"\u02d5\7\f\2\2\u02d4\u02cf\3\2\2\2\u02d4\u02d3\3\2\2\2\u02d5\u02d6\3\2"+
		"\2\2\u02d6\u02d7\bf\2\2\u02d7\u00cc\3\2\2\2\u02d8\u02d9\7\61\2\2\u02d9"+
		"\u02da\7,\2\2\u02da\u02de\3\2\2\2\u02db\u02dd\13\2\2\2\u02dc\u02db\3\2"+
		"\2\2\u02dd\u02e0\3\2\2\2\u02de\u02df\3\2\2\2\u02de\u02dc\3\2\2\2\u02df"+
		"\u02e1\3\2\2\2\u02e0\u02de\3\2\2\2\u02e1\u02e2\7,\2\2\u02e2\u02e3\7\61"+
		"\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e5\bg\2\2\u02e5\u00ce\3\2\2\2\u02e6"+
		"\u02e7\7\61\2\2\u02e7\u02e8\7\61\2\2\u02e8\u02ec\3\2\2\2\u02e9\u02eb\n"+
		"\20\2\2\u02ea\u02e9\3\2\2\2\u02eb\u02ee\3\2\2\2\u02ec\u02ea\3\2\2\2\u02ec"+
		"\u02ed\3\2\2\2\u02ed\u02ef\3\2\2\2\u02ee\u02ec\3\2\2\2\u02ef\u02f0\bh"+
		"\2\2\u02f0\u00d0\3\2\2\2=\2\u018b\u018d\u0192\u01a2\u01ab\u01af\u01b3"+
		"\u01b7\u01b9\u01bf\u01c6\u01cd\u01da\u01e1\u01e5\u01e7\u01f1\u01f5\u01f9"+
		"\u01fc\u0201\u0203\u0209\u020f\u0211\u0214\u021b\u021f\u0224\u0227\u022e"+
		"\u0231\u0238\u023c\u0241\u0244\u0249\u0263\u0268\u026c\u0272\u0282\u028a"+
		"\u028d\u0291\u0298\u029d\u02a1\u02a5\u02a9\u02af\u02b6\u02c3\u02cb\u02d1"+
		"\u02d4\u02de\u02ec\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}