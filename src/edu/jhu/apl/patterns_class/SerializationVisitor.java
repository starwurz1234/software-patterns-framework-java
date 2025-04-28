package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.dom.replacement.Attr;
import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Element;
import edu.jhu.apl.patterns_class.dom.replacement.Text;

import java.io.IOException;

public interface SerializationVisitor {
    public void serializeAttr(Attr attr) throws IOException;
    public void serializeDocument(Document doc) throws IOException;
    public void serializeElement(Element element) throws IOException;
    public void serializeText(Text text) throws IOException;
}
