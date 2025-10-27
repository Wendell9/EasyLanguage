/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.compiler.abstractsyntaxtree;

import br.edu.cefsa.compiler.datastructures.EasySymbol;
import br.edu.cefsa.compiler.datastructures.EasyTypeMapper;
import br.edu.cefsa.compiler.datastructures.EasyVariable;
import java.util.List;

/**
 *
 * @author guind
 */
public class CommandFuncao extends AbstractCommand {

    private String nome;
    private int tipoRetorno;
    private List<EasySymbol> parametros; // Usando EasySymbol para os parâmetros
    private List<AbstractCommand> corpo;

    public CommandFuncao(String nome, int tipoRetorno, List<EasySymbol> parametros, List<AbstractCommand> corpo) {
        this.nome = nome;
        this.tipoRetorno = tipoRetorno;
        this.parametros = parametros;
        this.corpo = corpo;
    }

    @Override
    public String toString() {
        return "CommandFuncao [nome=" + nome + "]";
    }

    @Override
    public String generateJavaCode() {
        // 1. Gera a assinatura do método Java
        StringBuilder sb = new StringBuilder();
        String javaReturnType = EasyTypeMapper.mapTipo(this.tipoRetorno);

        sb.append("public static ");
        sb.append(javaReturnType).append(" "); // Mapeia "numero" para "double", "texto" para "String", etc.
        sb.append(nome);

        sb.append("(");
        for (int i = 0; i < parametros.size(); i++) {
            EasySymbol param = parametros.get(i);
            
            String javaParamType = EasyTypeMapper.mapTipo(((EasyVariable) param).getType());

            sb.append(javaParamType).append(" ").append(param.getName());

            if (i < parametros.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(") {\n");

        // 3. Itera sobre o corpo da função
        for (AbstractCommand cmd : corpo) {
            sb.append("\t").append(cmd.generateJavaCode()).append("\n");
        }

        sb.append("}\n\n");
        return sb.toString();
    }
}
