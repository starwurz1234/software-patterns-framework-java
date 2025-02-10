package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.interfaces.Serialization;
import edu.jhu.apl.patterns_class.dom.interfaces.WhitespaceStrategy;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

import java.io.BufferedWriter;
import java.io.IOException;

public class WhitespaceMinimalStrategy implements WhitespaceStrategy {
    @Override
    public void serialize(BufferedWriter writer, Serialization node) throws IOException {
        node.serializeMinimal(writer);
    }
}
