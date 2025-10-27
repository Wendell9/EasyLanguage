/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.util.List;

/**
 *
 * @author guind
 */
// Esta classe serve para agrupar todos os comandos do bloco principal (main)
public class CommandBlocoMain extends AbstractCommand {

    private List<AbstractCommand> comandos;

    public CommandBlocoMain(List<AbstractCommand> comandos) {
        this.comandos = comandos;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();

        for (AbstractCommand cmd : comandos) {

            sb.append("\t\t").append(cmd.generateJavaCode()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "CommandBlocoMain [comandos=" + comandos + "]\n";
    }
}
