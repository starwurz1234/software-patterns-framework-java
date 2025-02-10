package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import org.w3c.dom.DOMException;

public class ElementValidator extends Validator{
    public ElementValidator(Node node) {
        super(node, node.getNodeName(), node.getNodeType());
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        if (newChild instanceof Document) {
            return null;
        }
        return node.appendChild(newChild);
    }
}
