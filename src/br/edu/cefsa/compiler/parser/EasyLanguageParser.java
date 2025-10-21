// Generated from EasyLanguage.g4 by ANTLR 4.12.0
package br.edu.cefsa.compiler.parser;

	import br.edu.cefsa.compiler.datastructures.EasySymbol;
	import br.edu.cefsa.compiler.datastructures.EasyVariable;
	import br.edu.cefsa.compiler.datastructures.EasySymbolTable;
	import br.edu.cefsa.compiler.exceptions.EasySemanticException;
	import br.edu.cefsa.compiler.abstractsyntaxtree.EasyProgram;
	import br.edu.cefsa.compiler.abstractsyntaxtree.AbstractCommand;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandLeitura;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandEscrita;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandAtribuicao;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandDecisao;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandEnquanto;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandLaço;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandVetor;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EasyLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TIPO_NUMERO=13, TIPO_TEXTO=14, TIPO_BOOLEANO=15, 
		AP=16, AC=17, FC=18, FP=19, SC=20, OP=21, ATTR=22, VIR=23, ACH=24, FCH=25, 
		DP=26, OPBOOL=27, BOOLEANO=28, OPREL=29, ID=30, NUMBER=31, WS=32;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdEnquanto = 10, RULE_cmdLaço = 11, RULE_declaracao_array = 12, 
		RULE_expr = 13, RULE_id_ou_array = 14, RULE_termo = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"cmdattrib", "cmdselecao", "cmdEnquanto", "cmdLaço", "declaracao_array", 
			"expr", "id_ou_array", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'leia'", "'escreva'", "'se'", "'senao'", 
			"'enquanto'", "'fa\\u00E7a'", "'para'", "'de'", "'ate'", "'passo'", "'numero'", 
			"'texto'", "'booleano'", "'('", "'['", "']'", "')'", "';'", null, "'='", 
			"','", "'{'", "'}'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TIPO_NUMERO", "TIPO_TEXTO", "TIPO_BOOLEANO", "AP", "AC", "FC", 
			"FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "DP", "OPBOOL", "BOOLEANO", 
			"OPREL", "ID", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "EasyLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private int _tipo;
		private String _varName;
		private String _varValue;
		private EasySymbolTable symbolTable = new EasySymbolTable();
		private EasySymbol symbol;
		private EasyProgram program = new EasyProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new EasySemanticException("Symbol "+id+" not declared");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}

	public EasyLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);

			           curThread = new ArrayList<AbstractCommand>();
			           stack.push(curThread); 
			       
			setState(34);
			decl();
			setState(35);
			bloco();
			setState(36);
			match(T__1);

			           program.setVarTable(symbolTable);
			           program.setComandos(stack.pop()); 
			       
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public List<Declaracao_arrayContext> declaracao_array() {
			return getRuleContexts(Declaracao_arrayContext.class);
		}
		public Declaracao_arrayContext declaracao_array(int i) {
			return getRuleContext(Declaracao_arrayContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(41);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(39);
					declaravar();
					}
					break;
				case 2:
					{
					setState(40);
					declaracao_array();
					}
					break;
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			tipo();
			setState(46);
			match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new EasyVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                  }
				                  else{
				                  	 throw new EasySemanticException("Symbol "+_varName+" already declared");
				                  }
			                    
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(48);
				match(VIR);
				setState(49);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  symbol = new EasyVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new EasySemanticException("Symbol "+_varName+" already declared");
					                  }
				                    
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode TIPO_NUMERO() { return getToken(EasyLanguageParser.TIPO_NUMERO, 0); }
		public TerminalNode TIPO_TEXTO() { return getToken(EasyLanguageParser.TIPO_TEXTO, 0); }
		public TerminalNode TIPO_BOOLEANO() { return getToken(EasyLanguageParser.TIPO_BOOLEANO, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIPO_NUMERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(TIPO_NUMERO);
				 _tipo = EasyVariable.NUMBER;  
				}
				break;
			case TIPO_TEXTO:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(TIPO_TEXTO);
				 _tipo = EasyVariable.TEXT;  
				}
				break;
			case TIPO_BOOLEANO:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				match(TIPO_BOOLEANO);
				 _tipo = EasyVariable.BOOLEANO;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>(); 
				        stack.push(curThread);  
			          
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				cmd();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073742520L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdEnquantoContext cmdEnquanto() {
			return getRuleContext(CmdEnquantoContext.class,0);
		}
		public CmdLaçoContext cmdLaço() {
			return getRuleContext(CmdLaçoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				cmdleitura();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				cmdattrib();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				cmdselecao();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				cmdEnquanto();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				cmdLaço();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__2);
			setState(81);
			match(AP);
			setState(82);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(84);
			match(FP);
			setState(85);
			match(SC);

			              	EasyVariable var = (EasyVariable)symbolTable.get(_readID);
			              	CommandLeitura cmd = new CommandLeitura(_readID, var);
			              	stack.peek().add(cmd);
			              
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__3);
			setState(89);
			match(AP);
			setState(90);
			expr();

			          _writeID = _exprContent; 
			          _exprContent = "";     
			      
			setState(92);
			match(FP);
			setState(93);
			match(SC);

			          CommandEscrita cmd = new CommandEscrita(_writeID);
			          stack.peek().add(cmd);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdattribContext extends ParserRuleContext {
		public Id_ou_arrayContext id_ou_array() {
			return getRuleContext(Id_ou_arrayContext.class,0);
		}
		public TerminalNode ATTR() { return getToken(EasyLanguageParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			id_ou_array();

			             _exprID = _exprContent; 

			        
			setState(98);
			match(ATTR);
			setState(99);
			expr();
			setState(100);
			match(SC);

			           CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			           stack.peek().add(cmd);
				 _exprContent = ""; 
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(EasyLanguageParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(EasyLanguageParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(EasyLanguageParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(EasyLanguageParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(EasyLanguageParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__4);
			setState(104);
			match(AP);
			setState(105);
			match(ID);
			 _exprDecision = _input.LT(-1).getText(); 
			setState(107);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(109);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprDecision += _input.LT(-1).getText(); 
			setState(111);
			match(FP);
			setState(112);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                        stack.push(curThread);
			                    
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				cmd();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073742520L) != 0) );
			setState(119);
			match(FCH);

			                       listaTrue = stack.pop();	
			                    
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(121);
				match(T__5);
				setState(122);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	
				{
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(124);
					cmd();
					}
					}
					setState(127); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073742520L) != 0) );
				}
				setState(129);
				match(FCH);

				                   		listaFalse = stack.pop();
				                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				                   		stack.peek().add(cmd);
				                   	
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEnquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(EasyLanguageParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(EasyLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(EasyLanguageParser.NUMBER, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdEnquanto(this);
		}
	}

	public final CmdEnquantoContext cmdEnquanto() throws RecognitionException {
		CmdEnquantoContext _localctx = new CmdEnquantoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__6);
			setState(135);
			match(AP);
			setState(136);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(137);
			match(OPREL);
			setState(138);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(139);
			match(FP);
			setState(140);
			match(T__7);
			setState(141);
			match(ACH);

			                    // 1. Cria uma nova lista (thread) de comandos para este bloco 'enquanto'
			                    curThread = new ArrayList<AbstractCommand>();
			                    // 2. Coloca a nova lista na pilha (stack) para que os comandos internos sejam adicionados a ela
			                    stack.push(curThread); 
			                
			setState(144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				cmd();
				}
				}
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073742520L) != 0) );
			setState(148);
			match(FCH);

			                    // 3. Pega a lista de comandos que acabou de ser preenchida (corpo do loop)
					    ArrayList<AbstractCommand> listaComandosDoWhile = new ArrayList<AbstractCommand>();
			                    listaComandosDoWhile = stack.pop();
			                    
			                    // 4. Cria a instância do CommandEnquanto com a condição e a lista de comandos
			                    CommandEnquanto cmd = new CommandEnquanto(_exprDecision, listaComandosDoWhile);
			                    
			                    // 5. Adiciona o CommandEnquanto à lista de comandos do contexto pai (o bloco anterior na pilha)
			                    stack.peek().add(cmd);
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLaçoContext extends ParserRuleContext {
		public Token ID;
		public Token v_inicial_id;
		public Token v_inicial_num;
		public Token v_final_id;
		public Token v_final_num;
		public Token v_passo_id;
		public Token v_passo_num;
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode DP() { return getToken(EasyLanguageParser.DP, 0); }
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(EasyLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(EasyLanguageParser.NUMBER, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdLaçoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLaço; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmdLaço(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmdLaço(this);
		}
	}

	public final CmdLaçoContext cmdLaço() throws RecognitionException {
		CmdLaçoContext _localctx = new CmdLaçoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdLaço);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__8);
			setState(152);
			((CmdLaçoContext)_localctx).ID = match(ID);
			 _varControle = (((CmdLaçoContext)_localctx).ID!=null?((CmdLaçoContext)_localctx).ID.getText():null); 
			setState(154);
			match(T__9);
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(155);
				((CmdLaçoContext)_localctx).v_inicial_id = match(ID);
				}
				break;
			case NUMBER:
				{
				setState(156);
				((CmdLaçoContext)_localctx).v_inicial_num = match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _valorInicial = (((CmdLaçoContext)_localctx).v_inicial_id!=null?((CmdLaçoContext)_localctx).v_inicial_id.getText():null) != null ? (((CmdLaçoContext)_localctx).v_inicial_id!=null?((CmdLaçoContext)_localctx).v_inicial_id.getText():null) : (((CmdLaçoContext)_localctx).v_inicial_num!=null?((CmdLaçoContext)_localctx).v_inicial_num.getText():null); 
			setState(160);
			match(T__10);
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(161);
				((CmdLaçoContext)_localctx).v_final_id = match(ID);
				}
				break;
			case NUMBER:
				{
				setState(162);
				((CmdLaçoContext)_localctx).v_final_num = match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _valorFinal = (((CmdLaçoContext)_localctx).v_final_id!=null?((CmdLaçoContext)_localctx).v_final_id.getText():null) != null ? (((CmdLaçoContext)_localctx).v_final_id!=null?((CmdLaçoContext)_localctx).v_final_id.getText():null) : (((CmdLaçoContext)_localctx).v_final_num!=null?((CmdLaçoContext)_localctx).v_final_num.getText():null); 
			setState(166);
			match(T__11);
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(167);
				((CmdLaçoContext)_localctx).v_passo_id = match(ID);
				}
				break;
			case NUMBER:
				{
				setState(168);
				((CmdLaçoContext)_localctx).v_passo_num = match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _passo = (((CmdLaçoContext)_localctx).v_passo_id!=null?((CmdLaçoContext)_localctx).v_passo_id.getText():null) != null ? (((CmdLaçoContext)_localctx).v_passo_id!=null?((CmdLaçoContext)_localctx).v_passo_id.getText():null) : (((CmdLaçoContext)_localctx).v_passo_num!=null?((CmdLaçoContext)_localctx).v_passo_num.getText():null); 
			setState(172);
			match(DP);
			setState(173);
			match(ACH);

			                // Início da lógica da Pilha (stack)
			                curThread = new ArrayList<AbstractCommand>();
			                stack.push(curThread); 
			            
			setState(176); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(175);
				cmd();
				}
				}
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073742520L) != 0) );
			setState(180);
			match(FCH);

			                // Finalização e criação do CommandLaço (esta parte está correta)
			                ArrayList<AbstractCommand> listaComandosDoPara = stack.pop();
			                CommandLaço cmd = new CommandLaço(_varControle, _valorInicial, _valorFinal, _passo, listaComandosDoPara);
			                stack.peek().add(cmd);

			                _varControle = null;
			                _valorInicial = null;
			                _valorFinal = null;
			                _passo = null;
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracao_arrayContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AC() { return getToken(EasyLanguageParser.AC, 0); }
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public TerminalNode FC() { return getToken(EasyLanguageParser.FC, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public Declaracao_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterDeclaracao_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitDeclaracao_array(this);
		}
	}

	public final Declaracao_arrayContext declaracao_array() throws RecognitionException {
		Declaracao_arrayContext _localctx = new Declaracao_arrayContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaracao_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			tipo();
			setState(184);
			match(ID);
			 _varName = _input.LT(-1).getText(); 
			setState(186);
			match(AC);
			setState(187);
			match(NUMBER);

			          int tamanho = Integer.parseInt(_input.LT(-1).getText()); // 3. Captura o tamanho (ex: 3)

			          if (symbolTable.exists(_varName)){
			               throw new EasySemanticException("Symbol "+_varName+" already declared");
			          }
			          
			          symbol = new EasyVariable(_varName, _tipo, null);
			          symbolTable.add(symbol); 
			          
			          String tipoJava;
			          if (_tipo == EasyVariable.NUMBER) {
			              tipoJava = "double";
			          } else if (_tipo == EasyVariable.TEXT) {
			              tipoJava = "String";
			          } else {
			              tipoJava = "Boolean";
			          }

			          CommandVetor cmdVetor = new CommandVetor(_varName, tipoJava, tamanho);
			          stack.peek().add(cmdVetor);

			      
			setState(189);
			match(FC);
			setState(190);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(EasyLanguageParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(EasyLanguageParser.OP, i);
		}
		public List<TerminalNode> OPBOOL() { return getTokens(EasyLanguageParser.OPBOOL); }
		public TerminalNode OPBOOL(int i) {
			return getToken(EasyLanguageParser.OPBOOL, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				termo();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP) {
					{
					{
					setState(193);
					match(OP);
					 _exprContent += _input.LT(-1).getText();
					setState(195);
					termo();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				termo();
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPBOOL) {
					{
					{
					setState(202);
					match(OPBOOL);
					 _exprContent += _input.LT(-1).getText();
					setState(204);
					termo();
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Id_ou_arrayContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AC() { return getToken(EasyLanguageParser.AC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FC() { return getToken(EasyLanguageParser.FC, 0); }
		public Id_ou_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_ou_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterId_ou_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitId_ou_array(this);
		}
	}

	public final Id_ou_arrayContext id_ou_array() throws RecognitionException {
		Id_ou_arrayContext _localctx = new Id_ou_arrayContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_id_ou_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(ID);
			 verificaID(_input.LT(-1).getText()); _exprContent += _input.LT(-1).getText(); 
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AC) {
				{
				setState(214);
				match(AC);
				 _exprContent += _input.LT(-1).getText(); 
				setState(216);
				expr();
				setState(217);
				match(FC);
				 _exprContent += _input.LT(-1).getText(); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public Id_ou_arrayContext id_ou_array() {
			return getRuleContext(Id_ou_arrayContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_termo);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				id_ou_array();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(NUMBER);

				          _exprContent += _input.LT(-1).getText();
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u00e4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001*\b\u0001\u000b\u0001"+
		"\f\u0001+\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u00024\b\u0002\n\u0002\f\u00027\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003A\b\u0003\u0001\u0004\u0001\u0004\u0004\u0004"+
		"E\b\u0004\u000b\u0004\f\u0004F\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005O\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\tt\b\t\u000b\t\f\tu\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t~\b\t\u000b\t\f\t\u007f"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u0085\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u0091\b\n\u000b"+
		"\n\f\n\u0092\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u009e\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a4\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00aa\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00b1\b\u000b"+
		"\u000b\u000b\f\u000b\u00b2\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u00c5\b\r\n\r\f\r\u00c8\t\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0005\r\u00ce\b\r\n\r\f\r\u00d1\t\r\u0003\r\u00d3"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00dd\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00e2\b\u000f\u0001\u000f\u0000\u0000\u0010"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e\u0000\u0001\u0001\u0000\u001e\u001f\u00eb\u0000 \u0001\u0000"+
		"\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u0004-\u0001\u0000\u0000\u0000"+
		"\u0006@\u0001\u0000\u0000\u0000\bB\u0001\u0000\u0000\u0000\nN\u0001\u0000"+
		"\u0000\u0000\fP\u0001\u0000\u0000\u0000\u000eX\u0001\u0000\u0000\u0000"+
		"\u0010`\u0001\u0000\u0000\u0000\u0012g\u0001\u0000\u0000\u0000\u0014\u0086"+
		"\u0001\u0000\u0000\u0000\u0016\u0097\u0001\u0000\u0000\u0000\u0018\u00b7"+
		"\u0001\u0000\u0000\u0000\u001a\u00d2\u0001\u0000\u0000\u0000\u001c\u00d4"+
		"\u0001\u0000\u0000\u0000\u001e\u00e1\u0001\u0000\u0000\u0000 !\u0005\u0001"+
		"\u0000\u0000!\"\u0006\u0000\uffff\uffff\u0000\"#\u0003\u0002\u0001\u0000"+
		"#$\u0003\b\u0004\u0000$%\u0005\u0002\u0000\u0000%&\u0006\u0000\uffff\uffff"+
		"\u0000&\u0001\u0001\u0000\u0000\u0000\'*\u0003\u0004\u0002\u0000(*\u0003"+
		"\u0018\f\u0000)\'\u0001\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*+"+
		"\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000"+
		"\u0000,\u0003\u0001\u0000\u0000\u0000-.\u0003\u0006\u0003\u0000./\u0005"+
		"\u001e\u0000\u0000/5\u0006\u0002\uffff\uffff\u000001\u0005\u0017\u0000"+
		"\u000012\u0005\u001e\u0000\u000024\u0006\u0002\uffff\uffff\u000030\u0001"+
		"\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u000068\u0001\u0000\u0000\u000075\u0001\u0000\u0000"+
		"\u000089\u0005\u0014\u0000\u00009\u0005\u0001\u0000\u0000\u0000:;\u0005"+
		"\r\u0000\u0000;A\u0006\u0003\uffff\uffff\u0000<=\u0005\u000e\u0000\u0000"+
		"=A\u0006\u0003\uffff\uffff\u0000>?\u0005\u000f\u0000\u0000?A\u0006\u0003"+
		"\uffff\uffff\u0000@:\u0001\u0000\u0000\u0000@<\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000A\u0007\u0001\u0000\u0000\u0000BD\u0006\u0004"+
		"\uffff\uffff\u0000CE\u0003\n\u0005\u0000DC\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"G\t\u0001\u0000\u0000\u0000HO\u0003\f\u0006\u0000IO\u0003\u000e\u0007"+
		"\u0000JO\u0003\u0010\b\u0000KO\u0003\u0012\t\u0000LO\u0003\u0014\n\u0000"+
		"MO\u0003\u0016\u000b\u0000NH\u0001\u0000\u0000\u0000NI\u0001\u0000\u0000"+
		"\u0000NJ\u0001\u0000\u0000\u0000NK\u0001\u0000\u0000\u0000NL\u0001\u0000"+
		"\u0000\u0000NM\u0001\u0000\u0000\u0000O\u000b\u0001\u0000\u0000\u0000"+
		"PQ\u0005\u0003\u0000\u0000QR\u0005\u0010\u0000\u0000RS\u0005\u001e\u0000"+
		"\u0000ST\u0006\u0006\uffff\uffff\u0000TU\u0005\u0013\u0000\u0000UV\u0005"+
		"\u0014\u0000\u0000VW\u0006\u0006\uffff\uffff\u0000W\r\u0001\u0000\u0000"+
		"\u0000XY\u0005\u0004\u0000\u0000YZ\u0005\u0010\u0000\u0000Z[\u0003\u001a"+
		"\r\u0000[\\\u0006\u0007\uffff\uffff\u0000\\]\u0005\u0013\u0000\u0000]"+
		"^\u0005\u0014\u0000\u0000^_\u0006\u0007\uffff\uffff\u0000_\u000f\u0001"+
		"\u0000\u0000\u0000`a\u0003\u001c\u000e\u0000ab\u0006\b\uffff\uffff\u0000"+
		"bc\u0005\u0016\u0000\u0000cd\u0003\u001a\r\u0000de\u0005\u0014\u0000\u0000"+
		"ef\u0006\b\uffff\uffff\u0000f\u0011\u0001\u0000\u0000\u0000gh\u0005\u0005"+
		"\u0000\u0000hi\u0005\u0010\u0000\u0000ij\u0005\u001e\u0000\u0000jk\u0006"+
		"\t\uffff\uffff\u0000kl\u0005\u001d\u0000\u0000lm\u0006\t\uffff\uffff\u0000"+
		"mn\u0007\u0000\u0000\u0000no\u0006\t\uffff\uffff\u0000op\u0005\u0013\u0000"+
		"\u0000pq\u0005\u0018\u0000\u0000qs\u0006\t\uffff\uffff\u0000rt\u0003\n"+
		"\u0005\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wx\u0005\u0019\u0000\u0000x\u0084\u0006\t\uffff\uffff\u0000yz\u0005\u0006"+
		"\u0000\u0000z{\u0005\u0018\u0000\u0000{}\u0006\t\uffff\uffff\u0000|~\u0003"+
		"\n\u0005\u0000}|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0019\u0000\u0000\u0082"+
		"\u0083\u0006\t\uffff\uffff\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084"+
		"y\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0013"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0007\u0000\u0000\u0087\u0088"+
		"\u0005\u0010\u0000\u0000\u0088\u0089\u0007\u0000\u0000\u0000\u0089\u008a"+
		"\u0005\u001d\u0000\u0000\u008a\u008b\u0007\u0000\u0000\u0000\u008b\u008c"+
		"\u0005\u0013\u0000\u0000\u008c\u008d\u0005\b\u0000\u0000\u008d\u008e\u0005"+
		"\u0018\u0000\u0000\u008e\u0090\u0006\n\uffff\uffff\u0000\u008f\u0091\u0003"+
		"\n\u0005\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u0019"+
		"\u0000\u0000\u0095\u0096\u0006\n\uffff\uffff\u0000\u0096\u0015\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0005\t\u0000\u0000\u0098\u0099\u0005\u001e\u0000"+
		"\u0000\u0099\u009a\u0006\u000b\uffff\uffff\u0000\u009a\u009d\u0005\n\u0000"+
		"\u0000\u009b\u009e\u0005\u001e\u0000\u0000\u009c\u009e\u0005\u001f\u0000"+
		"\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009c\u0001\u0000\u0000"+
		"\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0006\u000b\uffff"+
		"\uffff\u0000\u00a0\u00a3\u0005\u000b\u0000\u0000\u00a1\u00a4\u0005\u001e"+
		"\u0000\u0000\u00a2\u00a4\u0005\u001f\u0000\u0000\u00a3\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0006\u000b\uffff\uffff\u0000\u00a6\u00a9\u0005"+
		"\f\u0000\u0000\u00a7\u00aa\u0005\u001e\u0000\u0000\u00a8\u00aa\u0005\u001f"+
		"\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0006\u000b"+
		"\uffff\uffff\u0000\u00ac\u00ad\u0005\u001a\u0000\u0000\u00ad\u00ae\u0005"+
		"\u0018\u0000\u0000\u00ae\u00b0\u0006\u000b\uffff\uffff\u0000\u00af\u00b1"+
		"\u0003\n\u0005\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005"+
		"\u0019\u0000\u0000\u00b5\u00b6\u0006\u000b\uffff\uffff\u0000\u00b6\u0017"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b8\u0003\u0006\u0003\u0000\u00b8\u00b9"+
		"\u0005\u001e\u0000\u0000\u00b9\u00ba\u0006\f\uffff\uffff\u0000\u00ba\u00bb"+
		"\u0005\u0011\u0000\u0000\u00bb\u00bc\u0005\u001f\u0000\u0000\u00bc\u00bd"+
		"\u0006\f\uffff\uffff\u0000\u00bd\u00be\u0005\u0012\u0000\u0000\u00be\u00bf"+
		"\u0005\u0014\u0000\u0000\u00bf\u0019\u0001\u0000\u0000\u0000\u00c0\u00c6"+
		"\u0003\u001e\u000f\u0000\u00c1\u00c2\u0005\u0015\u0000\u0000\u00c2\u00c3"+
		"\u0006\r\uffff\uffff\u0000\u00c3\u00c5\u0003\u001e\u000f\u0000\u00c4\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00d3"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00cf"+
		"\u0003\u001e\u000f\u0000\u00ca\u00cb\u0005\u001b\u0000\u0000\u00cb\u00cc"+
		"\u0006\r\uffff\uffff\u0000\u00cc\u00ce\u0003\u001e\u000f\u0000\u00cd\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00c0"+
		"\u0001\u0000\u0000\u0000\u00d2\u00c9\u0001\u0000\u0000\u0000\u00d3\u001b"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u001e\u0000\u0000\u00d5\u00dc"+
		"\u0006\u000e\uffff\uffff\u0000\u00d6\u00d7\u0005\u0011\u0000\u0000\u00d7"+
		"\u00d8\u0006\u000e\uffff\uffff\u0000\u00d8\u00d9\u0003\u001a\r\u0000\u00d9"+
		"\u00da\u0005\u0012\u0000\u0000\u00da\u00db\u0006\u000e\uffff\uffff\u0000"+
		"\u00db\u00dd\u0001\u0000\u0000\u0000\u00dc\u00d6\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u001d\u0001\u0000\u0000\u0000"+
		"\u00de\u00e2\u0003\u001c\u000e\u0000\u00df\u00e0\u0005\u001f\u0000\u0000"+
		"\u00e0\u00e2\u0006\u000f\uffff\uffff\u0000\u00e1\u00de\u0001\u0000\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u001f\u0001\u0000\u0000"+
		"\u0000\u0013)+5@FNu\u007f\u0084\u0092\u009d\u00a3\u00a9\u00b2\u00c6\u00cf"+
		"\u00d2\u00dc\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}