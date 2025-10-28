grammar EasyLanguage;

@header{
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
}

@members{
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
}

prog : 'programa'
       {
           curThread = new ArrayList<AbstractCommand>();
           stack.push(curThread); 
		initScope();
       }
       decl 
       rotinas
       bloco 
       'fimprog;'
       {
	program.setVarTable(globalSymbolTable);
           program.setComandos(stack.pop());
       }
     ;

rotinas : (funcao | procedimento)* ;

funcao : FUNCAO_KW tipo{
        int tipo_funcao;
        tipo_funcao = _tipo;
}
	nomeF=ID AP params=param_list FP ACH
         { 

             String nomeFuncao = $nomeF.text; // Captura o nome da função
             
             if (!symbolTable.exists(nomeFuncao)) {
                 symbolTable.add(new EasyVariable(nomeFuncao, _tipo, null)); 
             } else {
                 throw new EasySemanticException("Função " + nomeFuncao + " já declarada.");
             }
             
             enterScope(); 
             
             if ($params.listaRetorno != null) {
                 for (EasySymbol p : $params.listaRetorno) {
                    symbolTable.add(p); // Adiciona o parâmetro como variável local do escopo da função
                 }
             }

             curThread = new ArrayList<AbstractCommand>();
             stack.push(curThread);
         }
         
         bloco_funcao
         
         FCH
         
         { 
             
             ArrayList<AbstractCommand> corpoComandos = stack.pop(); 
             
             CommandFuncao cmd = new CommandFuncao(nomeFuncao, tipo_funcao, $params.listaRetorno, corpoComandos);
             
             stack.peek().add(cmd);
             
             exitScope(); 
         }
       ;

param_list returns [List<EasySymbol> listaRetorno]
@init {
    $listaRetorno = new ArrayList<EasySymbol>(); // Inicializa a lista no início da regra
}
    :
    (

        tipo ID {
            String paramName = $ID.text;
            EasyVariable paramSymbol = new EasyVariable(paramName, _tipo, null); 
            $listaRetorno.add(paramSymbol);
        }
        
        (VIR tipo ID {
            paramName = $ID.text;
            paramSymbol = new EasyVariable(paramName, _tipo, null);
            $listaRetorno.add(paramSymbol);
            // symbolTable.add(paramSymbol); 
        })*
    )?
;


procedimento : PROCEDIMENTO_KW TIPO_VOID ID AP param_list FP ACH
               { /* Ação: Entra no escopo de procedimento */ }
               bloco_funcao
               FCH
               { /* Ação: Sai do escopo, gera o CommandProcedimento */ }
             ;

bloco_funcao : 
    decl_local 
    (cmd | cmd_retorno)* ;

cmd_retorno : RETORNO_KW 

              { _exprContent = ""; } 

              expr SC 
              { 

                  CommandRetorno cmd = new CommandRetorno(_exprContent); 
                  

                  stack.peek().add(cmd);
                  

                  _exprContent = "";
                  

              }
            ;
		
decl    :  (declaravar | declaracao_array)* ;

TIPO_NUMERO   : 'numero';
TIPO_TEXTO    : 'texto';
TIPO_BOOLEANO : 'booleano';
TIPO_VOID : 'vazio';
        
        
declaravar :  tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  EasyVariable novoSimbolo = new EasyVariable(_varName, _tipo, _varValue);
			  if (!symbolTable.exists(_varName)){
                     		symbolTable.add(novoSimbolo);    
                 		} else {
                     		throw new EasySemanticException("Symbol "+_varName+" already declared");
                 		}
                 		CommandDeclaracaoLocal cmd = new CommandDeclaracaoLocal(novoSimbolo);
                 		stack.peek().add(cmd);
                    } 
              (  VIR 
              	 ID {
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
              )* 
               SC
           ;

decl_local : (declaravar | declaracao_array)* ;
           
tipo       : TIPO_NUMERO { _tipo = EasyVariable.NUMBER;  }
           | TIPO_TEXTO  { _tipo = EasyVariable.TEXT;  }
	   | TIPO_BOOLEANO   { _tipo = EasyVariable.BOOLEANO;  }
	   | TIPO_VOID   { _tipo = EasyVariable.VOID;  }
           ;

bloco	:	'bloco'
		ACH
		{
		enterScope();
		curThread = new ArrayList<AbstractCommand>();
		stack.push(curThread);
		}
		decl_local
		(cmd)*
		FCH
		{
		ArrayList<AbstractCommand> corpoDoBloco = stack.pop();
		CommandBlocoMain cmdBloco = new CommandBlocoMain(corpoDoBloco);
		stack.peek().add(cmdBloco);
		exitScope();
		}
		;

cmd:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao
		|  cmdEnquanto 
		|  cmdLaço
		| cmd_chamada
		;

cmd_chamada
    : ID { 
        // Apenas para pegar o ID no início (o resto da lógica será reescrito)
        _funcaoNome = _input.LT(-1).getText(); 
        _exprContent = "";
      }
      AP
      { _argumentosLista = new ArrayList<String>(); } 
      (
          expr
          {
              // 3. Captura o código Java da primeira expressão (que está em _exprContent)
              _argumentosLista.add(_exprContent);
              _exprContent = ""; // 
          }
          (
              VIR
              expr
              {
                  _argumentosLista.add(_exprContent);
                  _exprContent = ""; // Limpa _exprContent
              }
          )*
      )? 
      FP
      SC
      {
          CommandChamada cmd = new CommandChamada(_funcaoNome, _argumentosLista);
          stack.peek().add(cmd);
          
          _funcaoNome = null;
      }
    ;
		
cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	EasyVariable var = (EasyVariable)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita
    : 'escreva'
      AP
	{ _exprContent = ""; }
      expr
      {
          _writeID = _exprContent; 
          _exprContent = "";     
      }
      FP
      SC
      {
          CommandEscrita cmd = new CommandEscrita(_writeID);
          stack.peek().add(cmd);
      }
    ;
			
cmdattrib :
    { _exprContent = ""; } 
    id_ou_array
    {
         _exprID = _exprContent; // Pega o ID (ex: "x" ou "vetor[i]")
         _exprContent = "";      // Zera para receber a expressão
    }
    ATTR
    expr
    SC
    {
        CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
        stack.peek().add(cmd);
    }
    ;
			
			
cmdselecao : 'se' AP
             { _exprContent = ""; 
	       _exprDecision = "";} 

             termo 
             
             (OPREL { 	_exprDecision = _exprContent;
			_exprDecision += _input.LT(-1).getText(); }
             
             termo { _exprDecision += _input.LT(-1).getText(); } )? // É opcional
             
             FP  
             ACH 
             { curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); }
             (cmd)+ 
             FCH
             { listaTrue = stack.pop(); } 
             
             ('senao'
                 ACH
                 { curThread = new ArrayList<AbstractCommand>(); stack.push(curThread); }
                 (cmd+) 
                 FCH
                 {
                     listaFalse = stack.pop();
                 }
             )?
	     {       CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                     stack.peek().add(cmd);
                     // Importante: resetar _exprDecision após o uso
                     _exprDecision = null; }
             ;
cmdEnquanto : 	'enquanto'
                AP (ID | NUMBER) OPREL (ID | NUMBER) FP
                'faça' 
                ACH                            // Abre Chave {
                {
                   
                    curThread = new ArrayList<AbstractCommand>();
                    
                    stack.push(curThread); 
                }
                (cmd)+                         // Bloco de Comandos (um ou mais comandos)
                FCH                            // Fecha Chave }
                {
                    
		    ArrayList<AbstractCommand> listaComandosDoWhile = new ArrayList<AbstractCommand>();
                    listaComandosDoWhile = stack.pop();
                    
                    
                    CommandEnquanto cmd = new CommandEnquanto(_exprDecision, listaComandosDoWhile);
                    
                    
                    stack.peek().add(cmd);
                }
            ;

cmdLaço : 'para'
            ID                             { String _varControle = $ID.text; } // Ok: ID é o único token aqui
            'de'
            (v_inicial_id=ID | v_inicial_num=NUMBER)                  
            { String _valorInicial = $v_inicial_id.text != null ? $v_inicial_id.text : $v_inicial_num.text; } // Usa rótulos
            'ate'
            (v_final_id=ID | v_final_num=NUMBER)                      
            {  String _valorFinal = $v_final_id.text != null ? $v_final_id.text : $v_final_num.text; } // Usa rótulos
            'passo'                       
            (v_passo_id=ID | v_passo_num=NUMBER)                      
            {String _passo = $v_passo_id.text != null ? $v_passo_id.text : $v_passo_num.text; } // Usa rótulos
            DP                            
            ACH                            
            {
                // Início da lógica da Pilha (stack)
                curThread = new ArrayList<AbstractCommand>();
                stack.push(curThread); 
            }
            (cmd)+                         
            FCH                            
            {
                // Finalização e criação do CommandLaço (esta parte está correta)
                ArrayList<AbstractCommand> listaComandosDoPara = stack.pop();
                CommandLaço cmd = new CommandLaço(_varControle, _valorInicial, _valorFinal, _passo, listaComandosDoPara);
                stack.peek().add(cmd);

                _varControle = null;
                _valorInicial = null;
                _valorFinal = null;
                _passo = null;
            }
        ;

declaracao_array
    : tipo ID
      { _varName = _input.LT(-1).getText(); } 

      AC
      NUMBER
      {
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

      } // FECHA O BLOCO DE AÇÃO DEPOIS DE TUDO SER PROCESSADO!
      FC
      SC
    ;

			
expr        :  termo ( 
                        OP  { _exprContent += _input.LT(-1).getText();}
                        termo
	             )*
		|
			termo  (
				OPBOOL  { _exprContent += _input.LT(-1).getText();}
                        termo
	             )*
		|
		termo(
			OPREL { _exprContent += _input.LT(-1).getText();}
                        termo
	             )*
            ;

id_ou_array : ID {
    // 1. Pega o símbolo da tabela
    EasySymbol s = symbolTable.get(_input.LT(-1).getText());
    if (s == null) {
        throw new EasySemanticException("Symbol " + _input.LT(-1).getText() + " not declared");
    }
    
    // ARMAZENA O NOME DO ID PARA USO POSTERIOR:
    String _currentID = _input.LT(-1).getText();
    
    _exprContent += _input.LT(-1).getText(); 
}
(
    AC { 
        _exprContent += _input.LT(-1).getText();
        
        // USA A VARIÁVEL ARMAZENADA:
        s = symbolTable.get(_currentID); 
        if (!(s instanceof EasyArray)) {
            throw new EasySemanticException("Symbol " + _currentID + " is not an array and cannot be indexed.");
        }
    } 
    expr
    FC { _exprContent += _input.LT(-1).getText(); } 
)?
;

arg_list 
    : expr (VIR expr)* // Requires at least one argument
    ;
    
chamada_funcao
    : ID { verificaID(_input.LT(-1).getText()); _funcaoNome = _input.LT(-1).getText(); }
      AP
      { 
          String _exprContentSAVE = _exprContent; 
          _exprContent = ""; // LIMPAR para a CHAMADA DE FUNÇÃO
          
          _argumentosLista = new ArrayList<String>(); 
      }
      (
          // Inicia o argumento
          expr 
          {
              _argumentosLista.add(_exprContent);
              _exprContent = ""; // Limpa para o próximo argumento
          }
          (
              VIR
              expr
              {
                  _argumentosLista.add(_exprContent);
                  _exprContent = "";
              }
          )*
      )?
      FP
      {
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
    ;
			
termo : id_ou_array 
      | NUMBER
      {
          _exprContent += _input.LT(-1).getText();
      }
      | STRING_LITERAL 
      {
          _exprContent += _input.LT(-1).getText();
      }
	| BOOLEANO 
      {
          _exprContent += _input.LT(-1).getText();
      }
	| chamada_funcao
    ; 




FUNCAO_KW : 'funcao'; 

PROCEDIMENTO_KW : 'procedimento';

RETORNO_KW : 'retorne';
			
	
AP	: '('
	;

AC : '[' ; 

FC : ']' ; 
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
     ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
DP   : ':'
     ;

OPBOOL : 'e' | 'ou' | 'nao';

STRING_LITERAL : '"' (~'"')* '"' ;

BOOLEANO : 'verdadeiro' | 'falso';
	 
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
	;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;
