package edu.jhu.apl.patterns_class;

public class StartElementState implements BuilderState{

    private String value;

    public StartElementState(String value) {
        this.value = value;
    }

    @Override
    public DocumentState Handle(DocumentState state) {
        String	trimmed	= this.value.trim();
        state.currentElement	= state.factory.createElement(trimmed);

        if (state.elementStack.peek() == null)	// This is the root element.
            state.factory.appendChild(state.currentElement);
        else
            state.elementStack.peek().appendChild(state.currentElement);
        return state;
    }
}
