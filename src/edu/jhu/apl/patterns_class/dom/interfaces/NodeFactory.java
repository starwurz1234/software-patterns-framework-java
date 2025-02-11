package edu.jhu.apl.patterns_class.dom.interfaces;

import edu.jhu.apl.patterns_class.dom.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

//Interface defining the Creator for Factory Method
public interface NodeFactory {
    public edu.jhu.apl.patterns_class.dom.replacement.Node createNode(String data, edu.jhu.apl.patterns_class.dom.Document document);
}
