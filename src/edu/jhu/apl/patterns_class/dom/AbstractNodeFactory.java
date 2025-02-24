package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Node;

public abstract class AbstractNodeFactory {
    public abstract Node createNode(String data, edu.jhu.apl.patterns_class.dom.Document document);
}
