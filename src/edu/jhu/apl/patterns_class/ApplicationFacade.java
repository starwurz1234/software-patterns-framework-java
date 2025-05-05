package edu.jhu.apl.patterns_class;

public class ApplicationFacade {

    private ParseCommand parseCommand;
    private WriteCommand writeCommand;
    private PrintCommand printCommand;

    public ApplicationFacade(Invoker invoker) {
        this.parseCommand = new ParseCommand(invoker);
        this.writeCommand = new WriteCommand(invoker);
        this.printCommand = new PrintCommand(invoker);
    }

    public void Read(String path) {
        this.parseCommand.Execute(path);
    }

    public void Write(String path) {
        this.writeCommand.Execute(path);
    }

    public void Print(String path) {
        this.printCommand.Execute(path);
    }
}
