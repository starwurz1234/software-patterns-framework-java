package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

//Concrete creator for Text objects
public class TextFactory extends AbstractNodeFactory {
    @Override
    public Node createNode(String data, Document document) {
        return new Text(data, document);
    }
}
