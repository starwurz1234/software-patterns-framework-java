package edu.jhu.apl.patterns_class.dom.interfaces;

public interface Serialization {
    public int serializePretty(java.io.BufferedWriter writer, int indentationLevel) throws java.io.IOException;
    public void serializeMinimal(java.io.BufferedWriter writer) throws java.io.IOException;
}
