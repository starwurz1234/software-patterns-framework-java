package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

//Concrete creator for Attr objects
public class AttrFactory extends AbstractNodeFactory {
    @Override
    public Node createNode(String data, Document document) {
        return new Attr(data, document);
    }
}
