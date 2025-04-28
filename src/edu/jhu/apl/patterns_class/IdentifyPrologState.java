package edu.jhu.apl.patterns_class;

public class IdentifyPrologState implements BuilderState{

    private String value;

    public IdentifyPrologState(String value) {
        this.value = value;
    }

    @Override
    public DocumentState Handle(DocumentState state) {
        return state;
    }
}
