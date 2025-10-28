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
	import br.edu.cefsa.compiler.datastructures.EasyArray;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandFuncao;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandRetorno;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandBlocoMain;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandDeclaracaoLocal;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandChamada;
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
		T__9=10, T__10=11, T__11=12, T__12=13, TIPO_NUMERO=14, TIPO_TEXTO=15, 
		TIPO_BOOLEANO=16, TIPO_VOID=17, FUNCAO_KW=18, PROCEDIMENTO_KW=19, RETORNO_KW=20, 
		AP=21, AC=22, FC=23, FP=24, SC=25, OP=26, ATTR=27, VIR=28, ACH=29, FCH=30, 
		DP=31, OPBOOL=32, STRING_LITERAL=33, BOOLEANO=34, OPREL=35, ID=36, NUMBER=37, 
		WS=38;
	public static final int
		RULE_prog = 0, RULE_rotinas = 1, RULE_funcao = 2, RULE_param_list = 3, 
		RULE_procedimento = 4, RULE_bloco_funcao = 5, RULE_cmd_retorno = 6, RULE_decl = 7, 
		RULE_declaravar = 8, RULE_decl_local = 9, RULE_tipo = 10, RULE_bloco = 11, 
		RULE_cmd = 12, RULE_cmd_chamada = 13, RULE_cmdleitura = 14, RULE_cmdescrita = 15, 
		RULE_cmdattrib = 16, RULE_cmdselecao = 17, RULE_cmdEnquanto = 18, RULE_cmdLaço = 19, 
		RULE_declaracao_array = 20, RULE_expr = 21, RULE_id_ou_array = 22, RULE_arg_list = 23, 
		RULE_chamada_funcao = 24, RULE_termo = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "rotinas", "funcao", "param_list", "procedimento", "bloco_funcao", 
			"cmd_retorno", "decl", "declaravar", "decl_local", "tipo", "bloco", "cmd", 
			"cmd_chamada", "cmdleitura", "cmdescrita", "cmdattrib", "cmdselecao", 
			"cmdEnquanto", "cmdLaço", "declaracao_array", "expr", "id_ou_array", 
			"arg_list", "chamada_funcao", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'bloco'", "'leia'", "'escreva'", "'se'", 
			"'senao'", "'enquanto'", "'fa\\u00E7a'", "'para'", "'de'", "'ate'", "'passo'", 
			"'numero'", "'texto'", "'booleano'", "'vazio'", "'funcao'", "'procedimento'", 
			"'retorne'", "'('", "'['", "']'", "')'", "';'", null, "'='", "','", "'{'", 
			"'}'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "TIPO_NUMERO", "TIPO_TEXTO", "TIPO_BOOLEANO", "TIPO_VOID", 
			"FUNCAO_KW", "PROCEDIMENTO_KW", "RETORNO_KW", "AP", "AC", "FC", "FP", 
			"SC", "OP", "ATTR", "VIR", "ACH", "FCH", "DP", "OPBOOL", "STRING_LITERAL", 
			"BOOLEANO", "OPREL", "ID", "NUMBER", "WS"
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
		private Stack<EasySymbolTable> scopeStack = new Stack<>(); 	
		private EasySymbolTable globalSymbolTable;
		private String _funcaoNome; 
	    	private ArrayList<String> _argumentosLista;


	    public void initScope() {
	        EasySymbolTable globalTable = new EasySymbolTable();
	        scopeStack.push(globalTable);
	        this.symbolTable = globalTable;
	        this.globalSymbolTable = globalTable; // <--- Inicialização aqui
	    }
	    
	public void verificaID(String id){
	    for (int i = scopeStack.size() - 1; i >= 0; i--) {
	        EasySymbolTable currentScope = scopeStack.get(i);
	        if (currentScope.exists(id)){ // Se achar em qualquer escopo, está declarado
	            return; 
	        }
	    }
	    

	    throw new EasySemanticException("Symbol "+id+" not declared");
	}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}



		
		public void enterScope() {
			EasySymbolTable newScope = new EasySymbolTable(); 
	    
			scopeStack.push(newScope);
	    
			this.symbolTable = newScope; 
		}
		public void exitScope() {
	    		if (!scopeStack.isEmpty()) {
	        		scopeStack.pop();
	    		}
	    
	    		if (!scopeStack.isEmpty()) {
	        		this.symbolTable = scopeStack.peek(); 
	    		} else {
	        		this.symbolTable = null; 
	    		}
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
		public RotinasContext rotinas() {
			return getRuleContext(RotinasContext.class,0);
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
			setState(52);
			match(T__0);

			           curThread = new ArrayList<AbstractCommand>();
			           stack.push(curThread); 
					initScope();
			       
			setState(54);
			decl();
			setState(55);
			rotinas();
			setState(56);
			bloco();
			setState(57);
			match(T__1);

				program.setVarTable(globalSymbolTable);
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
	public static class RotinasContext extends ParserRuleContext {
		public List<FuncaoContext> funcao() {
			return getRuleContexts(FuncaoContext.class);
		}
		public FuncaoContext funcao(int i) {
			return getRuleContext(FuncaoContext.class,i);
		}
		public List<ProcedimentoContext> procedimento() {
			return getRuleContexts(ProcedimentoContext.class);
		}
		public ProcedimentoContext procedimento(int i) {
			return getRuleContext(ProcedimentoContext.class,i);
		}
		public RotinasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotinas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterRotinas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitRotinas(this);
		}
	}

	public final RotinasContext rotinas() throws RecognitionException {
		RotinasContext _localctx = new RotinasContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rotinas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCAO_KW || _la==PROCEDIMENTO_KW) {
				{
				setState(62);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUNCAO_KW:
					{
					setState(60);
					funcao();
					}
					break;
				case PROCEDIMENTO_KW:
					{
					setState(61);
					procedimento();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class FuncaoContext extends ParserRuleContext {
		public Token nomeF;
		public Param_listContext params;
		public TerminalNode FUNCAO_KW() { return getToken(EasyLanguageParser.FUNCAO_KW, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public Bloco_funcaoContext bloco_funcao() {
			return getRuleContext(Bloco_funcaoContext.class,0);
		}
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public FuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitFuncao(this);
		}
	}

	public final FuncaoContext funcao() throws RecognitionException {
		FuncaoContext _localctx = new FuncaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(FUNCAO_KW);
			setState(68);
			tipo();

			        int tipo_funcao;
			        tipo_funcao = _tipo;

			setState(70);
			((FuncaoContext)_localctx).nomeF = match(ID);
			setState(71);
			match(AP);
			setState(72);
			((FuncaoContext)_localctx).params = param_list();
			setState(73);
			match(FP);
			setState(74);
			match(ACH);
			 

			             String nomeFuncao = (((FuncaoContext)_localctx).nomeF!=null?((FuncaoContext)_localctx).nomeF.getText():null); // Captura o nome da função
			             
			             if (!symbolTable.exists(nomeFuncao)) {
			                 symbolTable.add(new EasyVariable(nomeFuncao, _tipo, null)); 
			             } else {
			                 throw new EasySemanticException("Função " + nomeFuncao + " já declarada.");
			             }
			             
			             enterScope(); 
			             
			             if (((FuncaoContext)_localctx).params.listaRetorno != null) {
			                 for (EasySymbol p : ((FuncaoContext)_localctx).params.listaRetorno) {
			                    symbolTable.add(p); // Adiciona o parâmetro como variável local do escopo da função
			                 }
			             }

			             curThread = new ArrayList<AbstractCommand>();
			             stack.push(curThread);
			         
			setState(76);
			bloco_funcao();
			setState(77);
			match(FCH);
			 
			             
			             ArrayList<AbstractCommand> corpoComandos = stack.pop(); 
			             
			             CommandFuncao cmd = new CommandFuncao(nomeFuncao, tipo_funcao, ((FuncaoContext)_localctx).params.listaRetorno, corpoComandos);
			             
			             stack.peek().add(cmd);
			             
			             exitScope(); 
			         
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
	public static class Param_listContext extends ParserRuleContext {
		public List<EasySymbol> listaRetorno;
		public Token ID;
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterParam_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitParam_list(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param_list);

		    ((Param_listContext)_localctx).listaRetorno =  new ArrayList<EasySymbol>(); // Inicializa a lista no início da regra

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) {
				{
				setState(80);
				tipo();
				setState(81);
				((Param_listContext)_localctx).ID = match(ID);

				            String paramName = (((Param_listContext)_localctx).ID!=null?((Param_listContext)_localctx).ID.getText():null);
				            EasyVariable paramSymbol = new EasyVariable(paramName, _tipo, null); 
				            _localctx.listaRetorno.add(paramSymbol);
				        
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(83);
					match(VIR);
					setState(84);
					tipo();
					setState(85);
					((Param_listContext)_localctx).ID = match(ID);

					            paramName = (((Param_listContext)_localctx).ID!=null?((Param_listContext)_localctx).ID.getText():null);
					            paramSymbol = new EasyVariable(paramName, _tipo, null);
					            _localctx.listaRetorno.add(paramSymbol);
					            // symbolTable.add(paramSymbol); 
					        
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class ProcedimentoContext extends ParserRuleContext {
		public TerminalNode PROCEDIMENTO_KW() { return getToken(EasyLanguageParser.PROCEDIMENTO_KW, 0); }
		public TerminalNode TIPO_VOID() { return getToken(EasyLanguageParser.TIPO_VOID, 0); }
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public Bloco_funcaoContext bloco_funcao() {
			return getRuleContext(Bloco_funcaoContext.class,0);
		}
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public ProcedimentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedimento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterProcedimento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitProcedimento(this);
		}
	}

	public final ProcedimentoContext procedimento() throws RecognitionException {
		ProcedimentoContext _localctx = new ProcedimentoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_procedimento);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(PROCEDIMENTO_KW);
			setState(96);
			match(TIPO_VOID);
			setState(97);
			match(ID);
			setState(98);
			match(AP);
			setState(99);
			param_list();
			setState(100);
			match(FP);
			setState(101);
			match(ACH);
			 /* Ação: Entra no escopo de procedimento */ 
			setState(103);
			bloco_funcao();
			setState(104);
			match(FCH);
			 /* Ação: Sai do escopo, gera o CommandProcedimento */ 
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
	public static class Bloco_funcaoContext extends ParserRuleContext {
		public Decl_localContext decl_local() {
			return getRuleContext(Decl_localContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<Cmd_retornoContext> cmd_retorno() {
			return getRuleContexts(Cmd_retornoContext.class);
		}
		public Cmd_retornoContext cmd_retorno(int i) {
			return getRuleContext(Cmd_retornoContext.class,i);
		}
		public Bloco_funcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterBloco_funcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitBloco_funcao(this);
		}
	}

	public final Bloco_funcaoContext bloco_funcao() throws RecognitionException {
		Bloco_funcaoContext _localctx = new Bloco_funcaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bloco_funcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			decl_local();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68720526704L) != 0)) {
				{
				setState(110);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
				case T__4:
				case T__5:
				case T__7:
				case T__9:
				case ID:
					{
					setState(108);
					cmd();
					}
					break;
				case RETORNO_KW:
					{
					setState(109);
					cmd_retorno();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Cmd_retornoContext extends ParserRuleContext {
		public TerminalNode RETORNO_KW() { return getToken(EasyLanguageParser.RETORNO_KW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public Cmd_retornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd_retorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmd_retorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmd_retorno(this);
		}
	}

	public final Cmd_retornoContext cmd_retorno() throws RecognitionException {
		Cmd_retornoContext _localctx = new Cmd_retornoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmd_retorno);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(RETORNO_KW);
			 _exprContent = ""; 
			setState(117);
			expr();
			setState(118);
			match(SC);
			 

			                  CommandRetorno cmd = new CommandRetorno(_exprContent); 
			                  

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
		enterRule(_localctx, 14, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) {
				{
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(121);
					declaravar();
					}
					break;
				case 2:
					{
					setState(122);
					declaracao_array();
					}
					break;
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		enterRule(_localctx, 16, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			tipo();
			setState(129);
			match(ID);

				                  _varName = _input.LT(-1).getText();
				                  EasyVariable novoSimbolo = new EasyVariable(_varName, _tipo, _varValue);
						  if (!symbolTable.exists(_varName)){
			                     		symbolTable.add(novoSimbolo);    
			                 		} else {
			                     		throw new EasySemanticException("Symbol "+_varName+" already declared");
			                 		}
			                 		CommandDeclaracaoLocal cmd = new CommandDeclaracaoLocal(novoSimbolo);
			                 		stack.peek().add(cmd);
			                    
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(131);
				match(VIR);
				setState(132);
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
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
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
	public static class Decl_localContext extends ParserRuleContext {
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
		public Decl_localContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_local; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterDecl_local(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitDecl_local(this);
		}
	}

	public final Decl_localContext decl_local() throws RecognitionException {
		Decl_localContext _localctx = new Decl_localContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_decl_local);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) {
				{
				setState(143);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(141);
					declaravar();
					}
					break;
				case 2:
					{
					setState(142);
					declaracao_array();
					}
					break;
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode TIPO_NUMERO() { return getToken(EasyLanguageParser.TIPO_NUMERO, 0); }
		public TerminalNode TIPO_TEXTO() { return getToken(EasyLanguageParser.TIPO_TEXTO, 0); }
		public TerminalNode TIPO_BOOLEANO() { return getToken(EasyLanguageParser.TIPO_BOOLEANO, 0); }
		public TerminalNode TIPO_VOID() { return getToken(EasyLanguageParser.TIPO_VOID, 0); }
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
		enterRule(_localctx, 20, RULE_tipo);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIPO_NUMERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(TIPO_NUMERO);
				 _tipo = EasyVariable.NUMBER;  
				}
				break;
			case TIPO_TEXTO:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(TIPO_TEXTO);
				 _tipo = EasyVariable.TEXT;  
				}
				break;
			case TIPO_BOOLEANO:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				match(TIPO_BOOLEANO);
				 _tipo = EasyVariable.BOOLEANO;  
				}
				break;
			case TIPO_VOID:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(TIPO_VOID);
				 _tipo = EasyVariable.VOID;  
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
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public Decl_localContext decl_local() {
			return getRuleContext(Decl_localContext.class,0);
		}
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
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
		enterRule(_localctx, 22, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__2);
			setState(159);
			match(ACH);

					enterScope();
					curThread = new ArrayList<AbstractCommand>();
					stack.push(curThread);
					
			setState(161);
			decl_local();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68719478128L) != 0)) {
				{
				{
				setState(162);
				cmd();
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(168);
			match(FCH);

					ArrayList<AbstractCommand> corpoDoBloco = stack.pop();
					CommandBlocoMain cmdBloco = new CommandBlocoMain(corpoDoBloco);
					stack.peek().add(cmdBloco);
					exitScope();
					
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
		public Cmd_chamadaContext cmd_chamada() {
			return getRuleContext(Cmd_chamadaContext.class,0);
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
		enterRule(_localctx, 24, RULE_cmd);
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				cmdleitura();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				cmdescrita();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				cmdattrib();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				cmdselecao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				cmdEnquanto();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				cmdLaço();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				cmd_chamada();
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
	public static class Cmd_chamadaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public Cmd_chamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd_chamada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterCmd_chamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitCmd_chamada(this);
		}
	}

	public final Cmd_chamadaContext cmd_chamada() throws RecognitionException {
		Cmd_chamadaContext _localctx = new Cmd_chamadaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmd_chamada);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(ID);
			 
			        // Apenas para pegar o ID no início (o resto da lógica será reescrito)
			        _funcaoNome = _input.LT(-1).getText(); 
			        _exprContent = "";
			      
			setState(182);
			match(AP);
			 _argumentosLista = new ArrayList<String>(); 
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 231928233984L) != 0)) {
				{
				setState(184);
				expr();

				              // 3. Captura o código Java da primeira expressão (que está em _exprContent)
				              _argumentosLista.add(_exprContent);
				              _exprContent = ""; // 
				          
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(186);
					match(VIR);
					setState(187);
					expr();

					                  _argumentosLista.add(_exprContent);
					                  _exprContent = ""; // Limpa _exprContent
					              
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(197);
			match(FP);
			setState(198);
			match(SC);

			          CommandChamada cmd = new CommandChamada(_funcaoNome, _argumentosLista);
			          stack.peek().add(cmd);
			          
			          _funcaoNome = null;
			      
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
		enterRule(_localctx, 28, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__3);
			setState(202);
			match(AP);
			setState(203);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(205);
			match(FP);
			setState(206);
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
		enterRule(_localctx, 30, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__4);
			setState(210);
			match(AP);
			 _exprContent = ""; 
			setState(212);
			expr();

			          _writeID = _exprContent; 
			          _exprContent = "";     
			      
			setState(214);
			match(FP);
			setState(215);
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
		enterRule(_localctx, 32, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 _exprContent = ""; 
			setState(219);
			id_ou_array();

			         _exprID = _exprContent; // Pega o ID (ex: "x" ou "vetor[i]")
			         _exprContent = "";      // Zera para receber a expressão
			    
			setState(221);
			match(ATTR);
			setState(222);
			expr();
			setState(223);
			match(SC);

			        CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
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
	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(EasyLanguageParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(EasyLanguageParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(EasyLanguageParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(EasyLanguageParser.FCH, i);
		}
		public TerminalNode OPREL() { return getToken(EasyLanguageParser.OPREL, 0); }
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
		enterRule(_localctx, 34, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(T__5);
			setState(227);
			match(AP);
			 _exprContent = ""; 
				       _exprDecision = "";
			setState(229);
			termo();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPREL) {
				{
				setState(230);
				match(OPREL);
				 	_exprDecision = _exprContent;
							_exprDecision += _input.LT(-1).getText(); 
				setState(232);
				termo();
				 _exprDecision += _input.LT(-1).getText(); 
				}
			}

			setState(237);
			match(FP);
			setState(238);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); 
			setState(241); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(240);
				cmd();
				}
				}
				setState(243); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68719478128L) != 0) );
			setState(245);
			match(FCH);
			 listaTrue = stack.pop(); 
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(247);
				match(T__6);
				setState(248);
				match(ACH);
				 curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); 
				{
				setState(251); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(250);
					cmd();
					}
					}
					setState(253); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68719478128L) != 0) );
				}
				setState(255);
				match(FCH);

				                     listaFalse = stack.pop();
				                 
				}
			}

			       CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
			                     stack.peek().add(cmd);
			                     // Importante: resetar _exprDecision após o uso
			                     _exprDecision = null; 
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
		enterRule(_localctx, 36, RULE_cmdEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__7);
			setState(263);
			match(AP);
			setState(264);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(265);
			match(OPREL);
			setState(266);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(267);
			match(FP);
			setState(268);
			match(T__8);
			setState(269);
			match(ACH);

			                   
			                    curThread = new ArrayList<AbstractCommand>();
			                    
			                    stack.push(curThread); 
			                
			setState(272); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(271);
				cmd();
				}
				}
				setState(274); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68719478128L) != 0) );
			setState(276);
			match(FCH);

			                    
					    ArrayList<AbstractCommand> listaComandosDoWhile = new ArrayList<AbstractCommand>();
			                    listaComandosDoWhile = stack.pop();
			                    
			                    
			                    CommandEnquanto cmd = new CommandEnquanto(_exprDecision, listaComandosDoWhile);
			                    
			                    
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
		enterRule(_localctx, 38, RULE_cmdLaço);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__9);
			setState(280);
			((CmdLaçoContext)_localctx).ID = match(ID);
			 String _varControle = (((CmdLaçoContext)_localctx).ID!=null?((CmdLaçoContext)_localctx).ID.getText():null); 
			setState(282);
			match(T__10);
			setState(285);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(283);
				((CmdLaçoContext)_localctx).v_inicial_id = match(ID);
				}
				break;
			case NUMBER:
				{
				setState(284);
				((CmdLaçoContext)_localctx).v_inicial_num = match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 String _valorInicial = (((CmdLaçoContext)_localctx).v_inicial_id!=null?((CmdLaçoContext)_localctx).v_inicial_id.getText():null) != null ? (((CmdLaçoContext)_localctx).v_inicial_id!=null?((CmdLaçoContext)_localctx).v_inicial_id.getText():null) : (((CmdLaçoContext)_localctx).v_inicial_num!=null?((CmdLaçoContext)_localctx).v_inicial_num.getText():null); 
			setState(288);
			match(T__11);
			setState(291);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(289);
				((CmdLaçoContext)_localctx).v_final_id = match(ID);
				}
				break;
			case NUMBER:
				{
				setState(290);
				((CmdLaçoContext)_localctx).v_final_num = match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			  String _valorFinal = (((CmdLaçoContext)_localctx).v_final_id!=null?((CmdLaçoContext)_localctx).v_final_id.getText():null) != null ? (((CmdLaçoContext)_localctx).v_final_id!=null?((CmdLaçoContext)_localctx).v_final_id.getText():null) : (((CmdLaçoContext)_localctx).v_final_num!=null?((CmdLaçoContext)_localctx).v_final_num.getText():null); 
			setState(294);
			match(T__12);
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(295);
				((CmdLaçoContext)_localctx).v_passo_id = match(ID);
				}
				break;
			case NUMBER:
				{
				setState(296);
				((CmdLaçoContext)_localctx).v_passo_num = match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			String _passo = (((CmdLaçoContext)_localctx).v_passo_id!=null?((CmdLaçoContext)_localctx).v_passo_id.getText():null) != null ? (((CmdLaçoContext)_localctx).v_passo_id!=null?((CmdLaçoContext)_localctx).v_passo_id.getText():null) : (((CmdLaçoContext)_localctx).v_passo_num!=null?((CmdLaçoContext)_localctx).v_passo_num.getText():null); 
			setState(300);
			match(DP);
			setState(301);
			match(ACH);

			                // Início da lógica da Pilha (stack)
			                curThread = new ArrayList<AbstractCommand>();
			                stack.push(curThread); 
			            
			setState(304); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(303);
				cmd();
				}
				}
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68719478128L) != 0) );
			setState(308);
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
		enterRule(_localctx, 40, RULE_declaracao_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			tipo();
			setState(312);
			match(ID);
			 _varName = _input.LT(-1).getText(); 
			setState(314);
			match(AC);
			setState(315);
			match(NUMBER);

			          int tamanho = Integer.parseInt(_input.LT(-1).getText()); 

			          if (symbolTable.exists(_varName)){
			               throw new EasySemanticException("Symbol "+_varName+" already declared");
			          }
			          
			          // MUDANÇA AQUI: Usa EasyArray
			          symbol = new EasyArray(_varName, _tipo, null, tamanho); // Usa a nova classe
			          symbolTable.add(symbol); 
			          
			          
			          // 1. Mapeia o tipo interno (int) para a String de tipo Java
			          String tipoJava;
			          if (_tipo == EasyVariable.NUMBER) {
			             tipoJava = "double";
			          } else if (_tipo == EasyVariable.TEXT) {
			             tipoJava = "String";
			          } else {
			             tipoJava = "Boolean";
			          }
			          
			          // 2. Cria e adiciona o comando CommandVetor
			          CommandVetor cmdVetor = new CommandVetor(_varName, tipoJava, tamanho);
			          stack.peek().add(cmdVetor); // <--- AGORA DENTRO DO BLOCO DE AÇÃO!

			      
			setState(317);
			match(FC);
			setState(318);
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
		public List<TerminalNode> OPREL() { return getTokens(EasyLanguageParser.OPREL); }
		public TerminalNode OPREL(int i) {
			return getToken(EasyLanguageParser.OPREL, i);
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
		enterRule(_localctx, 42, RULE_expr);
		int _la;
		try {
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				termo();
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP) {
					{
					{
					setState(321);
					match(OP);
					 _exprContent += _input.LT(-1).getText();
					setState(323);
					termo();
					}
					}
					setState(328);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				termo();
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPBOOL) {
					{
					{
					setState(330);
					match(OPBOOL);
					 _exprContent += _input.LT(-1).getText();
					setState(332);
					termo();
					}
					}
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
				termo();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPREL) {
					{
					{
					setState(339);
					match(OPREL);
					 _exprContent += _input.LT(-1).getText();
					setState(341);
					termo();
					}
					}
					setState(346);
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
		enterRule(_localctx, 44, RULE_id_ou_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(ID);

			    // 1. Pega o símbolo da tabela
			    EasySymbol s = symbolTable.get(_input.LT(-1).getText());
			    if (s == null) {
			        throw new EasySemanticException("Symbol " + _input.LT(-1).getText() + " not declared");
			    }
			    
			    // ARMAZENA O NOME DO ID PARA USO POSTERIOR:
			    String _currentID = _input.LT(-1).getText();
			    
			    _exprContent += _input.LT(-1).getText(); 

			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AC) {
				{
				setState(351);
				match(AC);
				 
				        _exprContent += _input.LT(-1).getText();
				        
				        // USA A VARIÁVEL ARMAZENADA:
				        s = symbolTable.get(_currentID); 
				        if (!(s instanceof EasyArray)) {
				            throw new EasySemanticException("Symbol " + _currentID + " is not an array and cannot be indexed.");
				        }
				    
				setState(353);
				expr();
				setState(354);
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
	public static class Arg_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterArg_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitArg_list(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			expr();
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(360);
				match(VIR);
				setState(361);
				expr();
				}
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Chamada_funcaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public Chamada_funcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamada_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).enterChamada_funcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyLanguageListener ) ((EasyLanguageListener)listener).exitChamada_funcao(this);
		}
	}

	public final Chamada_funcaoContext chamada_funcao() throws RecognitionException {
		Chamada_funcaoContext _localctx = new Chamada_funcaoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_chamada_funcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(ID);
			 verificaID(_input.LT(-1).getText()); _funcaoNome = _input.LT(-1).getText(); 
			setState(369);
			match(AP);
			 
			          String _exprContentSAVE = _exprContent; 
			          _exprContent = ""; // LIMPAR para a CHAMADA DE FUNÇÃO
			          
			          _argumentosLista = new ArrayList<String>(); 
			      
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 231928233984L) != 0)) {
				{
				setState(371);
				expr();

				              _argumentosLista.add(_exprContent);
				              _exprContent = ""; // Limpa para o próximo argumento
				          
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(373);
					match(VIR);
					setState(374);
					expr();

					                  _argumentosLista.add(_exprContent);
					                  _exprContent = "";
					              
					}
					}
					setState(381);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(384);
			match(FP);

			          StringBuilder sb = new StringBuilder(_funcaoNome).append("(");
			          for (int i = 0; i < _argumentosLista.size(); i++) {
			              sb.append(_argumentosLista.get(i));
			              if (i < _argumentosLista.size() - 1) {
			                  sb.append(", ");
			              }
			          }
			          sb.append(")");

			          _exprContent = _exprContentSAVE + sb.toString(); 
			          
			          _funcaoNome = null;
			      
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
		public TerminalNode STRING_LITERAL() { return getToken(EasyLanguageParser.STRING_LITERAL, 0); }
		public TerminalNode BOOLEANO() { return getToken(EasyLanguageParser.BOOLEANO, 0); }
		public Chamada_funcaoContext chamada_funcao() {
			return getRuleContext(Chamada_funcaoContext.class,0);
		}
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
		enterRule(_localctx, 50, RULE_termo);
		try {
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				id_ou_array();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				match(NUMBER);

				          _exprContent += _input.LT(-1).getText();
				      
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(390);
				match(STRING_LITERAL);

				          _exprContent += _input.LT(-1).getText();
				      
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(392);
				match(BOOLEANO);

				          _exprContent += _input.LT(-1).getText();
				      
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(394);
				chamada_funcao();
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

	public static final String _serializedATN =
		"\u0004\u0001&\u018e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0005\u0001?\b\u0001\n\u0001\f\u0001B\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003Y\b\u0003\n\u0003\f\u0003\\\t\u0003\u0003\u0003"+
		"^\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005o\b\u0005"+
		"\n\u0005\f\u0005r\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0005\u0007|\b\u0007"+
		"\n\u0007\f\u0007\u007f\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0005\b\u0087\b\b\n\b\f\b\u008a\t\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0005\t\u0090\b\t\n\t\f\t\u0093\t\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u009d\b\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a4\b\u000b\n\u000b"+
		"\f\u000b\u00a7\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00b3\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00bf\b\r\n\r\f\r\u00c2\t\r\u0003\r\u00c4\b\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u00ec\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011"+
		"\u00f2\b\u0011\u000b\u0011\f\u0011\u00f3\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u00fc\b\u0011\u000b"+
		"\u0011\f\u0011\u00fd\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0103"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0004\u0012\u0111\b\u0012\u000b\u0012\f\u0012\u0112\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u011e\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u0124\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u012a\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u0131\b\u0013\u000b\u0013"+
		"\f\u0013\u0132\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u0145\b\u0015\n\u0015\f\u0015\u0148\t\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0005\u0015\u014e\b\u0015\n\u0015\f\u0015\u0151\t\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0157\b\u0015"+
		"\n\u0015\f\u0015\u015a\t\u0015\u0003\u0015\u015c\b\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u0166\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u016b\b\u0017\n\u0017\f\u0017\u016e\t\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u017a\b\u0018\n\u0018\f\u0018\u017d"+
		"\t\u0018\u0003\u0018\u017f\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u018c\b\u0019\u0001\u0019\u0000\u0000"+
		"\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02\u0000\u0001\u0001\u0000$%\u01a0\u00004\u0001"+
		"\u0000\u0000\u0000\u0002@\u0001\u0000\u0000\u0000\u0004C\u0001\u0000\u0000"+
		"\u0000\u0006]\u0001\u0000\u0000\u0000\b_\u0001\u0000\u0000\u0000\nk\u0001"+
		"\u0000\u0000\u0000\fs\u0001\u0000\u0000\u0000\u000e}\u0001\u0000\u0000"+
		"\u0000\u0010\u0080\u0001\u0000\u0000\u0000\u0012\u0091\u0001\u0000\u0000"+
		"\u0000\u0014\u009c\u0001\u0000\u0000\u0000\u0016\u009e\u0001\u0000\u0000"+
		"\u0000\u0018\u00b2\u0001\u0000\u0000\u0000\u001a\u00b4\u0001\u0000\u0000"+
		"\u0000\u001c\u00c9\u0001\u0000\u0000\u0000\u001e\u00d1\u0001\u0000\u0000"+
		"\u0000 \u00da\u0001\u0000\u0000\u0000\"\u00e2\u0001\u0000\u0000\u0000"+
		"$\u0106\u0001\u0000\u0000\u0000&\u0117\u0001\u0000\u0000\u0000(\u0137"+
		"\u0001\u0000\u0000\u0000*\u015b\u0001\u0000\u0000\u0000,\u015d\u0001\u0000"+
		"\u0000\u0000.\u0167\u0001\u0000\u0000\u00000\u016f\u0001\u0000\u0000\u0000"+
		"2\u018b\u0001\u0000\u0000\u000045\u0005\u0001\u0000\u000056\u0006\u0000"+
		"\uffff\uffff\u000067\u0003\u000e\u0007\u000078\u0003\u0002\u0001\u0000"+
		"89\u0003\u0016\u000b\u00009:\u0005\u0002\u0000\u0000:;\u0006\u0000\uffff"+
		"\uffff\u0000;\u0001\u0001\u0000\u0000\u0000<?\u0003\u0004\u0002\u0000"+
		"=?\u0003\b\u0004\u0000><\u0001\u0000\u0000\u0000>=\u0001\u0000\u0000\u0000"+
		"?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"+
		"\u0000A\u0003\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0005"+
		"\u0012\u0000\u0000DE\u0003\u0014\n\u0000EF\u0006\u0002\uffff\uffff\u0000"+
		"FG\u0005$\u0000\u0000GH\u0005\u0015\u0000\u0000HI\u0003\u0006\u0003\u0000"+
		"IJ\u0005\u0018\u0000\u0000JK\u0005\u001d\u0000\u0000KL\u0006\u0002\uffff"+
		"\uffff\u0000LM\u0003\n\u0005\u0000MN\u0005\u001e\u0000\u0000NO\u0006\u0002"+
		"\uffff\uffff\u0000O\u0005\u0001\u0000\u0000\u0000PQ\u0003\u0014\n\u0000"+
		"QR\u0005$\u0000\u0000RZ\u0006\u0003\uffff\uffff\u0000ST\u0005\u001c\u0000"+
		"\u0000TU\u0003\u0014\n\u0000UV\u0005$\u0000\u0000VW\u0006\u0003\uffff"+
		"\uffff\u0000WY\u0001\u0000\u0000\u0000XS\u0001\u0000\u0000\u0000Y\\\u0001"+
		"\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000"+
		"[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]P\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^\u0007\u0001\u0000\u0000\u0000_`\u0005"+
		"\u0013\u0000\u0000`a\u0005\u0011\u0000\u0000ab\u0005$\u0000\u0000bc\u0005"+
		"\u0015\u0000\u0000cd\u0003\u0006\u0003\u0000de\u0005\u0018\u0000\u0000"+
		"ef\u0005\u001d\u0000\u0000fg\u0006\u0004\uffff\uffff\u0000gh\u0003\n\u0005"+
		"\u0000hi\u0005\u001e\u0000\u0000ij\u0006\u0004\uffff\uffff\u0000j\t\u0001"+
		"\u0000\u0000\u0000kp\u0003\u0012\t\u0000lo\u0003\u0018\f\u0000mo\u0003"+
		"\f\u0006\u0000nl\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000or\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"q\u000b\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000st\u0005\u0014"+
		"\u0000\u0000tu\u0006\u0006\uffff\uffff\u0000uv\u0003*\u0015\u0000vw\u0005"+
		"\u0019\u0000\u0000wx\u0006\u0006\uffff\uffff\u0000x\r\u0001\u0000\u0000"+
		"\u0000y|\u0003\u0010\b\u0000z|\u0003(\u0014\u0000{y\u0001\u0000\u0000"+
		"\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u000f\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0003\u0014\n\u0000"+
		"\u0081\u0082\u0005$\u0000\u0000\u0082\u0088\u0006\b\uffff\uffff\u0000"+
		"\u0083\u0084\u0005\u001c\u0000\u0000\u0084\u0085\u0005$\u0000\u0000\u0085"+
		"\u0087\u0006\b\uffff\uffff\u0000\u0086\u0083\u0001\u0000\u0000\u0000\u0087"+
		"\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0001\u0000\u0000\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a"+
		"\u0088\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u0019\u0000\u0000\u008c"+
		"\u0011\u0001\u0000\u0000\u0000\u008d\u0090\u0003\u0010\b\u0000\u008e\u0090"+
		"\u0003(\u0014\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u008e\u0001"+
		"\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0013\u0001"+
		"\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\u000e\u0000\u0000\u0095\u009d\u0006\n\uffff\uffff\u0000\u0096\u0097\u0005"+
		"\u000f\u0000\u0000\u0097\u009d\u0006\n\uffff\uffff\u0000\u0098\u0099\u0005"+
		"\u0010\u0000\u0000\u0099\u009d\u0006\n\uffff\uffff\u0000\u009a\u009b\u0005"+
		"\u0011\u0000\u0000\u009b\u009d\u0006\n\uffff\uffff\u0000\u009c\u0094\u0001"+
		"\u0000\u0000\u0000\u009c\u0096\u0001\u0000\u0000\u0000\u009c\u0098\u0001"+
		"\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u0015\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0005\u0003\u0000\u0000\u009f\u00a0\u0005"+
		"\u001d\u0000\u0000\u00a0\u00a1\u0006\u000b\uffff\uffff\u0000\u00a1\u00a5"+
		"\u0003\u0012\t\u0000\u00a2\u00a4\u0003\u0018\f\u0000\u00a3\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005"+
		"\u001e\u0000\u0000\u00a9\u00aa\u0006\u000b\uffff\uffff\u0000\u00aa\u0017"+
		"\u0001\u0000\u0000\u0000\u00ab\u00b3\u0003\u001c\u000e\u0000\u00ac\u00b3"+
		"\u0003\u001e\u000f\u0000\u00ad\u00b3\u0003 \u0010\u0000\u00ae\u00b3\u0003"+
		"\"\u0011\u0000\u00af\u00b3\u0003$\u0012\u0000\u00b0\u00b3\u0003&\u0013"+
		"\u0000\u00b1\u00b3\u0003\u001a\r\u0000\u00b2\u00ab\u0001\u0000\u0000\u0000"+
		"\u00b2\u00ac\u0001\u0000\u0000\u0000\u00b2\u00ad\u0001\u0000\u0000\u0000"+
		"\u00b2\u00ae\u0001\u0000\u0000\u0000\u00b2\u00af\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b3\u0019\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005$\u0000\u0000\u00b5"+
		"\u00b6\u0006\r\uffff\uffff\u0000\u00b6\u00b7\u0005\u0015\u0000\u0000\u00b7"+
		"\u00c3\u0006\r\uffff\uffff\u0000\u00b8\u00b9\u0003*\u0015\u0000\u00b9"+
		"\u00c0\u0006\r\uffff\uffff\u0000\u00ba\u00bb\u0005\u001c\u0000\u0000\u00bb"+
		"\u00bc\u0003*\u0015\u0000\u00bc\u00bd\u0006\r\uffff\uffff\u0000\u00bd"+
		"\u00bf\u0001\u0000\u0000\u0000\u00be\u00ba\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c3\u00b8\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0018\u0000\u0000\u00c6\u00c7\u0005\u0019\u0000\u0000\u00c7"+
		"\u00c8\u0006\r\uffff\uffff\u0000\u00c8\u001b\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0005\u0004\u0000\u0000\u00ca\u00cb\u0005\u0015\u0000\u0000\u00cb"+
		"\u00cc\u0005$\u0000\u0000\u00cc\u00cd\u0006\u000e\uffff\uffff\u0000\u00cd"+
		"\u00ce\u0005\u0018\u0000\u0000\u00ce\u00cf\u0005\u0019\u0000\u0000\u00cf"+
		"\u00d0\u0006\u000e\uffff\uffff\u0000\u00d0\u001d\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0005\u0005\u0000\u0000\u00d2\u00d3\u0005\u0015\u0000\u0000"+
		"\u00d3\u00d4\u0006\u000f\uffff\uffff\u0000\u00d4\u00d5\u0003*\u0015\u0000"+
		"\u00d5\u00d6\u0006\u000f\uffff\uffff\u0000\u00d6\u00d7\u0005\u0018\u0000"+
		"\u0000\u00d7\u00d8\u0005\u0019\u0000\u0000\u00d8\u00d9\u0006\u000f\uffff"+
		"\uffff\u0000\u00d9\u001f\u0001\u0000\u0000\u0000\u00da\u00db\u0006\u0010"+
		"\uffff\uffff\u0000\u00db\u00dc\u0003,\u0016\u0000\u00dc\u00dd\u0006\u0010"+
		"\uffff\uffff\u0000\u00dd\u00de\u0005\u001b\u0000\u0000\u00de\u00df\u0003"+
		"*\u0015\u0000\u00df\u00e0\u0005\u0019\u0000\u0000\u00e0\u00e1\u0006\u0010"+
		"\uffff\uffff\u0000\u00e1!\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0006"+
		"\u0000\u0000\u00e3\u00e4\u0005\u0015\u0000\u0000\u00e4\u00e5\u0006\u0011"+
		"\uffff\uffff\u0000\u00e5\u00eb\u00032\u0019\u0000\u00e6\u00e7\u0005#\u0000"+
		"\u0000\u00e7\u00e8\u0006\u0011\uffff\uffff\u0000\u00e8\u00e9\u00032\u0019"+
		"\u0000\u00e9\u00ea\u0006\u0011\uffff\uffff\u0000\u00ea\u00ec\u0001\u0000"+
		"\u0000\u0000\u00eb\u00e6\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u0018"+
		"\u0000\u0000\u00ee\u00ef\u0005\u001d\u0000\u0000\u00ef\u00f1\u0006\u0011"+
		"\uffff\uffff\u0000\u00f0\u00f2\u0003\u0018\f\u0000\u00f1\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0005\u001e\u0000\u0000\u00f6\u0102\u0006\u0011"+
		"\uffff\uffff\u0000\u00f7\u00f8\u0005\u0007\u0000\u0000\u00f8\u00f9\u0005"+
		"\u001d\u0000\u0000\u00f9\u00fb\u0006\u0011\uffff\uffff\u0000\u00fa\u00fc"+
		"\u0003\u0018\f\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100\u0005"+
		"\u001e\u0000\u0000\u0100\u0101\u0006\u0011\uffff\uffff\u0000\u0101\u0103"+
		"\u0001\u0000\u0000\u0000\u0102\u00f7\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0006\u0011\uffff\uffff\u0000\u0105#\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0005\b\u0000\u0000\u0107\u0108\u0005\u0015\u0000\u0000\u0108\u0109\u0007"+
		"\u0000\u0000\u0000\u0109\u010a\u0005#\u0000\u0000\u010a\u010b\u0007\u0000"+
		"\u0000\u0000\u010b\u010c\u0005\u0018\u0000\u0000\u010c\u010d\u0005\t\u0000"+
		"\u0000\u010d\u010e\u0005\u001d\u0000\u0000\u010e\u0110\u0006\u0012\uffff"+
		"\uffff\u0000\u010f\u0111\u0003\u0018\f\u0000\u0110\u010f\u0001\u0000\u0000"+
		"\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000"+
		"\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000"+
		"\u0000\u0114\u0115\u0005\u001e\u0000\u0000\u0115\u0116\u0006\u0012\uffff"+
		"\uffff\u0000\u0116%\u0001\u0000\u0000\u0000\u0117\u0118\u0005\n\u0000"+
		"\u0000\u0118\u0119\u0005$\u0000\u0000\u0119\u011a\u0006\u0013\uffff\uffff"+
		"\u0000\u011a\u011d\u0005\u000b\u0000\u0000\u011b\u011e\u0005$\u0000\u0000"+
		"\u011c\u011e\u0005%\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011d"+
		"\u011c\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f"+
		"\u0120\u0006\u0013\uffff\uffff\u0000\u0120\u0123\u0005\f\u0000\u0000\u0121"+
		"\u0124\u0005$\u0000\u0000\u0122\u0124\u0005%\u0000\u0000\u0123\u0121\u0001"+
		"\u0000\u0000\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0006\u0013\uffff\uffff\u0000\u0126\u0129"+
		"\u0005\r\u0000\u0000\u0127\u012a\u0005$\u0000\u0000\u0128\u012a\u0005"+
		"%\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129\u0128\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u012c\u0006\u0013"+
		"\uffff\uffff\u0000\u012c\u012d\u0005\u001f\u0000\u0000\u012d\u012e\u0005"+
		"\u001d\u0000\u0000\u012e\u0130\u0006\u0013\uffff\uffff\u0000\u012f\u0131"+
		"\u0003\u0018\f\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0131\u0132\u0001"+
		"\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001"+
		"\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0135\u0005"+
		"\u001e\u0000\u0000\u0135\u0136\u0006\u0013\uffff\uffff\u0000\u0136\'\u0001"+
		"\u0000\u0000\u0000\u0137\u0138\u0003\u0014\n\u0000\u0138\u0139\u0005$"+
		"\u0000\u0000\u0139\u013a\u0006\u0014\uffff\uffff\u0000\u013a\u013b\u0005"+
		"\u0016\u0000\u0000\u013b\u013c\u0005%\u0000\u0000\u013c\u013d\u0006\u0014"+
		"\uffff\uffff\u0000\u013d\u013e\u0005\u0017\u0000\u0000\u013e\u013f\u0005"+
		"\u0019\u0000\u0000\u013f)\u0001\u0000\u0000\u0000\u0140\u0146\u00032\u0019"+
		"\u0000\u0141\u0142\u0005\u001a\u0000\u0000\u0142\u0143\u0006\u0015\uffff"+
		"\uffff\u0000\u0143\u0145\u00032\u0019\u0000\u0144\u0141\u0001\u0000\u0000"+
		"\u0000\u0145\u0148\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u015c\u0001\u0000\u0000"+
		"\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0149\u014f\u00032\u0019\u0000"+
		"\u014a\u014b\u0005 \u0000\u0000\u014b\u014c\u0006\u0015\uffff\uffff\u0000"+
		"\u014c\u014e\u00032\u0019\u0000\u014d\u014a\u0001\u0000\u0000\u0000\u014e"+
		"\u0151\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f"+
		"\u0150\u0001\u0000\u0000\u0000\u0150\u015c\u0001\u0000\u0000\u0000\u0151"+
		"\u014f\u0001\u0000\u0000\u0000\u0152\u0158\u00032\u0019\u0000\u0153\u0154"+
		"\u0005#\u0000\u0000\u0154\u0155\u0006\u0015\uffff\uffff\u0000\u0155\u0157"+
		"\u00032\u0019\u0000\u0156\u0153\u0001\u0000\u0000\u0000\u0157\u015a\u0001"+
		"\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001"+
		"\u0000\u0000\u0000\u0159\u015c\u0001\u0000\u0000\u0000\u015a\u0158\u0001"+
		"\u0000\u0000\u0000\u015b\u0140\u0001\u0000\u0000\u0000\u015b\u0149\u0001"+
		"\u0000\u0000\u0000\u015b\u0152\u0001\u0000\u0000\u0000\u015c+\u0001\u0000"+
		"\u0000\u0000\u015d\u015e\u0005$\u0000\u0000\u015e\u0165\u0006\u0016\uffff"+
		"\uffff\u0000\u015f\u0160\u0005\u0016\u0000\u0000\u0160\u0161\u0006\u0016"+
		"\uffff\uffff\u0000\u0161\u0162\u0003*\u0015\u0000\u0162\u0163\u0005\u0017"+
		"\u0000\u0000\u0163\u0164\u0006\u0016\uffff\uffff\u0000\u0164\u0166\u0001"+
		"\u0000\u0000\u0000\u0165\u015f\u0001\u0000\u0000\u0000\u0165\u0166\u0001"+
		"\u0000\u0000\u0000\u0166-\u0001\u0000\u0000\u0000\u0167\u016c\u0003*\u0015"+
		"\u0000\u0168\u0169\u0005\u001c\u0000\u0000\u0169\u016b\u0003*\u0015\u0000"+
		"\u016a\u0168\u0001\u0000\u0000\u0000\u016b\u016e\u0001\u0000\u0000\u0000"+
		"\u016c\u016a\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000"+
		"\u016d/\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016f"+
		"\u0170\u0005$\u0000\u0000\u0170\u0171\u0006\u0018\uffff\uffff\u0000\u0171"+
		"\u0172\u0005\u0015\u0000\u0000\u0172\u017e\u0006\u0018\uffff\uffff\u0000"+
		"\u0173\u0174\u0003*\u0015\u0000\u0174\u017b\u0006\u0018\uffff\uffff\u0000"+
		"\u0175\u0176\u0005\u001c\u0000\u0000\u0176\u0177\u0003*\u0015\u0000\u0177"+
		"\u0178\u0006\u0018\uffff\uffff\u0000\u0178\u017a\u0001\u0000\u0000\u0000"+
		"\u0179\u0175\u0001\u0000\u0000\u0000\u017a\u017d\u0001\u0000\u0000\u0000"+
		"\u017b\u0179\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000"+
		"\u017c\u017f\u0001\u0000\u0000\u0000\u017d\u017b\u0001\u0000\u0000\u0000"+
		"\u017e\u0173\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000"+
		"\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0181\u0005\u0018\u0000\u0000"+
		"\u0181\u0182\u0006\u0018\uffff\uffff\u0000\u01821\u0001\u0000\u0000\u0000"+
		"\u0183\u018c\u0003,\u0016\u0000\u0184\u0185\u0005%\u0000\u0000\u0185\u018c"+
		"\u0006\u0019\uffff\uffff\u0000\u0186\u0187\u0005!\u0000\u0000\u0187\u018c"+
		"\u0006\u0019\uffff\uffff\u0000\u0188\u0189\u0005\"\u0000\u0000\u0189\u018c"+
		"\u0006\u0019\uffff\uffff\u0000\u018a\u018c\u00030\u0018\u0000\u018b\u0183"+
		"\u0001\u0000\u0000\u0000\u018b\u0184\u0001\u0000\u0000\u0000\u018b\u0186"+
		"\u0001\u0000\u0000\u0000\u018b\u0188\u0001\u0000\u0000\u0000\u018b\u018a"+
		"\u0001\u0000\u0000\u0000\u018c3\u0001\u0000\u0000\u0000\">@Z]np{}\u0088"+
		"\u008f\u0091\u009c\u00a5\u00b2\u00c0\u00c3\u00eb\u00f3\u00fd\u0102\u0112"+
		"\u011d\u0123\u0129\u0132\u0146\u014f\u0158\u015b\u0165\u016c\u017b\u017e"+
		"\u018b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}