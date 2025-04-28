package edu.jhu.apl.patterns_class;

public class AddValueState implements BuilderState{

    private String value;

    public AddValueState(String value) {
        this.value = value;
    }

    @Override
    public DocumentState Handle(DocumentState state) {
        String	trimmed	= this.value.trim();
        state.elementStack.peek().appendChild(state.factory.createTextNode(trimmed));
        return state;
    }
}
