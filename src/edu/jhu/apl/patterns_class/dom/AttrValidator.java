package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Element;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import org.w3c.dom.DOMException;
import org.w3c.dom.TypeInfo;

public class AttrValidator extends Validator<edu.jhu.apl.patterns_class.dom.replacement.Attr> implements edu.jhu.apl.patterns_class.dom.replacement.Attr{
    public AttrValidator(edu.jhu.apl.patterns_class.dom.replacement.Attr node) {
        super(node, node.getNodeName(), node.getNodeType());
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        return null;
    }

    @Override
    public String getName() {
        return node.getName();
    }

    @Override
    public String getValue() {
        return node.getValue();
    }

    @Override
    public void setValue(String value) {
        node.setValue(value);
    }

    @Override
    public Element getOwnerElement() {
        return node.getOwnerElement();
    }

    @Override
    public boolean getSpecified() {
        return node.getSpecified();
    }

    @Override
    public boolean isId() {
        return node.isId();
    }

    @Override
    public TypeInfo getSchemaTypeInfo() {
        return node.getSchemaTypeInfo();
    }
}
