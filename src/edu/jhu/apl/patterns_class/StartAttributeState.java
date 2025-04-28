package edu.jhu.apl.patterns_class;

public class StartAttributeState implements BuilderState{

    private String value;

    public StartAttributeState(String value) {
        this.value = value;
    }

    @Override
    public DocumentState Handle(DocumentState state) {
        String	trimmed	= value.trim();
        trimmed	= trimmed.substring(0, trimmed.length() - 1);
        state.currentAttr	= state.factory.createAttribute(trimmed);
        return state;
    }
}
