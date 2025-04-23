package edu.jhu.apl.patterns_class;

import java.util.List;

import edu.jhu.apl.patterns_class.dom.replacement.Document;

public class CommandInvoker {

    private List<Command> commands;

    public CommandInvoker(List<Command> commands) {
        this.commands = commands;
    }

    public Document RunCommand(int i, Document document) {
        if (i < commands.size()) {
            return commands.get(i).execute(document);
        } else {
            System.out.println("Invalid command.");
            return document;
        }
    }
}
