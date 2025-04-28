package edu.jhu.apl.patterns_class;

public class AttributeValueState implements BuilderState{

    private String value;

    public AttributeValueState(String value) {
        this.value = value;
    }

    @Override
    public DocumentState Handle(DocumentState state) {
        String	trimmed	= this.value.trim();
        trimmed	= trimmed.substring(1, trimmed.length() - 1);
        state.currentAttr.setValue(trimmed);

        if (state.currentElement != null)	// Discard prolog attributes.  This implementation currently doesn't have
            // anything to do with them.
            state.currentElement.setAttributeNode(state.currentAttr);
        return state;
    }
}
