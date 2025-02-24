package edu.jhu.apl.patterns_class.dom.interfaces;

import edu.jhu.apl.patterns_class.dom.Node;

//Interface for Whitespace Strategy
public interface WhitespaceStrategy {
    public void serialize(java.io.BufferedWriter writer, Node node) throws java.io.IOException;
}
