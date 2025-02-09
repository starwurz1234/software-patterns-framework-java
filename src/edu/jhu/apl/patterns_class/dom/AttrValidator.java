package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Node;
import org.w3c.dom.DOMException;

public class AttrValidator extends Validator{
    public AttrValidator(Node node) {
        super(node);
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        return null;
    }
}
