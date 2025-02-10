package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.interfaces.SerializationStrategy;

import java.io.BufferedWriter;
import java.io.IOException;

public class SerializePrettyStrategy implements SerializationStrategy {
    @Override
    public void serialize(BufferedWriter writer, edu.jhu.apl.patterns_class.dom.replacement.Node node) throws IOException {
        node.serializePretty(writer, 0);
    }
}
