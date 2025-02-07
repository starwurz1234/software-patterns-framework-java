package edu.jhu.apl.patterns_class.dom;

public class AttrFactory implements edu.jhu.apl.patterns_class.dom.interfaces.NodeFactory {
    @Override
    public Node createNode(String data, Document document) {
        return new Attr(data, document);
    }
}
