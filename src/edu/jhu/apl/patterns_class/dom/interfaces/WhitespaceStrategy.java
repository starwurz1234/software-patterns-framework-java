package edu.jhu.apl.patterns_class.dom.interfaces;

//Interface for Whitespace Strategy
public interface WhitespaceStrategy {
    public void serialize(java.io.BufferedWriter writer, Serialization node) throws java.io.IOException;
}
