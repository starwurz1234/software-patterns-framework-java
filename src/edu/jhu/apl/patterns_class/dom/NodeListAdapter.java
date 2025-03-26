package edu.jhu.apl.patterns_class.dom;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListAdapter implements NodeList {

    edu.jhu.apl.patterns_class.dom.replacement.NodeList nodeList;

    public NodeListAdapter(edu.jhu.apl.patterns_class.dom.replacement.NodeList list) {
        this.nodeList = list;
    }

    @Override
    public Node item(int index) {
        return new NodeAdapter(nodeList.item(index));
    }

    @Override
    public int getLength() {
        return nodeList.getLength();
    }
}
