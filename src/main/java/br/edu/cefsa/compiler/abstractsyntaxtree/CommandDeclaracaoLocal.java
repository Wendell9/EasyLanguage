package br.edu.cefsa.compiler.abstractsyntaxtree;

import br.edu.cefsa.compiler.datastructures.EasyVariable;
import br.edu.cefsa.compiler.datastructures.EasyTypeMapper; // Usando o utilitário sugerido

public class CommandDeclaracaoLocal extends AbstractCommand {

    // Armazena a referência para o símbolo que será declarado
    private EasyVariable variable; 

    public CommandDeclaracaoLocal(EasyVariable variable) {
        this.variable = variable;
    }

    @Override
    public String generateJavaCode() {
        String javaType = EasyTypeMapper.mapTipo(variable.getType()); 
        return javaType + " " + variable.getName() + ";"; 
    }

    @Override
    public String toString() {
        return "CommandDeclaracaoLocal [name=" + variable.getName() + ", type=" + variable.getType() + "]";
    }
}