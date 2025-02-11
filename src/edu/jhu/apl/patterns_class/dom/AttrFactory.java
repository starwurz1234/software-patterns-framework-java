package edu.jhu.apl.patterns_class.dom;

//Concrete creator for Attr objects
public class AttrFactory implements edu.jhu.apl.patterns_class.dom.interfaces.NodeFactory {
    @Override
    public Node createNode(String data, Document document) {
        return new Attr(data, document);
    }
}
