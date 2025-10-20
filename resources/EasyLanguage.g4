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
}

prog	: 'programa' decl bloco 'fimprog;'
           {  program.setVarTable(symbolTable);
              program.setComandos(stack.pop());
           	 
           } 
	;
		
decl    :  (declaravar)+
        ;
        
        
declaravar :  tipo ID  {
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
           
tipo       : 'numero' { _tipo = EasyVariable.NUMBER;  }
           | 'texto'  { _tipo = EasyVariable.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao
		|  cmdEnquanto 
		|  cmdLaço
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
			
cmdescrita	: 'escreva' 
                 AP 
                 ID { verificaID(_input.LT(-1).getText());
	                  _writeID = _input.LT(-1).getText();
                     } 
                 FP 
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                   } 
               ATTR { _exprContent = ""; } 
               expr 
               SC
               {
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               	 stack.peek().add(cmd);
               }
			;
			
			
cmdselecao  :  'se' AP
                    ID    { _exprDecision = _input.LT(-1).getText(); }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER) {_exprDecision += _input.LT(-1).getText(); }
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                        stack.push(curThread);
                    }
                    (cmd)+ 
                    FCH
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	ACH
                   	{
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	} 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;

cmdEnquanto : 'enquanto'
                AP                             // Abre Parêntese (
                ID                             { _exprDecision = _input.LT(-1).getText(); }
                OPREL                          { _exprDecision += _input.LT(-1).getText(); }
                (ID | NUMBER)                  { _exprDecision += _input.LT(-1).getText(); }
                FP                             // Fecha Parêntese )
		'faça'
                ACH                            // Abre Chave {
                {
                    // 1. Cria uma nova lista (thread) de comandos para este bloco 'enquanto'
                    curThread = new ArrayList<AbstractCommand>();
                    // 2. Coloca a nova lista na pilha (stack) para que os comandos internos sejam adicionados a ela
                    stack.push(curThread); 
                }
                (cmd)+                         // Bloco de Comandos (um ou mais comandos)
                FCH                            // Fecha Chave }
                {
                    // 3. Pega a lista de comandos que acabou de ser preenchida (corpo do loop)
		    ArrayList<AbstractCommand> listaComandosDoWhile = new ArrayList<AbstractCommand>();
                    listaComandosDoWhile = stack.pop();
                    
                    // 4. Cria a instância do CommandEnquanto com a condição e a lista de comandos
                    CommandEnquanto cmd = new CommandEnquanto(_exprDecision, listaComandosDoWhile);
                    
                    // 5. Adiciona o CommandEnquanto à lista de comandos do contexto pai (o bloco anterior na pilha)
                    stack.peek().add(cmd);
                }
            ;

cmdLaço : 'para'
            ID                             { _varControle = $ID.text; } // Ok: ID é o único token aqui
            'de'
            (v_inicial_id=ID | v_inicial_num=NUMBER)                  
            { _valorInicial = $v_inicial_id.text != null ? $v_inicial_id.text : $v_inicial_num.text; } // Usa rótulos
            'ate'
            (v_final_id=ID | v_final_num=NUMBER)                      
            { _valorFinal = $v_final_id.text != null ? $v_final_id.text : $v_final_num.text; } // Usa rótulos
            'passo'                       
            (v_passo_id=ID | v_passo_num=NUMBER)                      
            { _passo = $v_passo_id.text != null ? $v_passo_id.text : $v_passo_num.text; } // Usa rótulos
            
            DP?                            
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

			
expr        :  termo ( 
                        OP  { _exprContent += _input.LT(-1).getText();}
                        termo
	             )*
            ;
			
termo	    : ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 } 
            | 
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              }
			;
			
	
AP	: '('
	;
	
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
	 
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
	;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;