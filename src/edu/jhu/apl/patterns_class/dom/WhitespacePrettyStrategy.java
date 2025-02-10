package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.interfaces.WhitespaceStrategy;

import java.io.BufferedWriter;
import java.io.IOException;

public class WhitespacePrettyStrategy implements WhitespaceStrategy {
    @Override
    public void serialize(BufferedWriter writer, edu.jhu.apl.patterns_class.dom.replacement.Node node) throws IOException {
        node.serializePretty(writer, 0);
    }
}
