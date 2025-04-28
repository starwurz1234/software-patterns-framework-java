package edu.jhu.apl.patterns_class;

public class PrologStartState implements BuilderState{
    @Override
    public DocumentState Handle(DocumentState state) {
        return state;
    }
}
