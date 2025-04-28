package edu.jhu.apl.patterns_class;

public class PrologEndState implements BuilderState{
    @Override
    public DocumentState Handle(DocumentState state) {
        return state;
    }
}
