package edu.jhu.apl.patterns_class.dom.interfaces;

public interface SerializationStrategy {
    public void serialize(java.io.BufferedWriter writer, edu.jhu.apl.patterns_class.dom.replacement.Node node) throws java.io.IOException;
}
