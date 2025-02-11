package edu.jhu.apl.patterns_class.dom;

//Concrete creator for Text objects
public class TextFactory implements edu.jhu.apl.patterns_class.dom.interfaces.NodeFactory {
    @Override
    public Node createNode(String data, Document document) {
        return new Text(data, document);
    }
}
