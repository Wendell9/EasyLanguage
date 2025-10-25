package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import br.edu.cefsa.compiler.datastructures.EasySymbol;
import br.edu.cefsa.compiler.datastructures.EasySymbolTable;
import br.edu.cefsa.compiler.datastructures.EasyVariable;

public class EasyProgram {

    private EasySymbolTable varTable;
    private ArrayList<AbstractCommand> comandos;
    private String programName;

    public void generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("public class MainClass{ \n");
        for (AbstractCommand cmd : this.getComandos()) {
            if (cmd instanceof CommandFuncao) {
                str.append(cmd.generateJavaCode());
            }
        }

        str.append("\tpublic static void main(String args[]) {\n");



        for (AbstractCommand cmd : this.getComandos()) {
            if (!(cmd instanceof CommandFuncao)) {
                // O \t\t garante a indentação correta dentro do main
                str.append("\t\t").append(cmd.generateJavaCode()).append("\n");
            }
        }
        str.append("\t}\n");
        str.append("}\n");

        try {
            FileWriter fr = new FileWriter(new File("./resources/MainClass.java"));
            fr.write(str.toString());
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public EasySymbolTable getVarTable() {
        return varTable;
    }

    public void setVarTable(EasySymbolTable varTable) {
        this.varTable = varTable;
    }

    public ArrayList<AbstractCommand> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<AbstractCommand> comandos) {
        this.comandos = comandos;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

}
