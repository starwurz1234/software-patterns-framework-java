package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.interfaces.SerializationStrategy;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

import java.io.BufferedWriter;
import java.io.IOException;

public class SerializeMinimalStrategy implements SerializationStrategy {
    @Override
    public void serialize(BufferedWriter writer, Node node) throws IOException {
        node.serializeMinimal(writer);
    }
}
