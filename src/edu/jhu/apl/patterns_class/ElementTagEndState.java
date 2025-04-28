package edu.jhu.apl.patterns_class;

public class ElementTagEndState implements BuilderState{
    @Override
    public DocumentState Handle(DocumentState state) {
        state.elementStack.push(state.currentElement);
        state.currentElement	= null;
        return state;
    }
}
