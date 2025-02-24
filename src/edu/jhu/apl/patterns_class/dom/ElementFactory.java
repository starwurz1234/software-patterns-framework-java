package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

//Concrete creator for Element objects
public class ElementFactory extends AbstractNodeFactory {
    @Override
    public Node createNode(String data, Document document) {
        return new Element(data, document);
    }
}
