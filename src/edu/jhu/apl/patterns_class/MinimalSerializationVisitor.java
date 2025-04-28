package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.dom.replacement.Attr;
import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Element;
import edu.jhu.apl.patterns_class.dom.replacement.Text;

import java.io.IOException;

public class MinimalSerializationVisitor implements SerializationVisitor{

    private java.io.Writer writer;

    public MinimalSerializationVisitor(java.io.Writer writer) {
        this.writer = writer;
    }

    @Override
    public void serializeAttr(Attr attr) throws IOException {
        writer.write(" " + attr.getName() + "=\"" + attr.getValue() + "\"");
    }

    @Override
    public void serializeDocument(Document doc) throws IOException {
        writer.write("<? xml version=\"1.0\" encoding=\"UTF-8\"?>");
        doc.getDocumentElement().accept(this);
    }

    @Override
    public void serializeElement(Element element) throws IOException {
        writer.write("<" + element.getTagName());

        int attrCount = 0;

        for (java.util.ListIterator i =
             ((edu.jhu.apl.patterns_class.dom.NodeList) element.getAttributes()).listIterator(0);
             i.hasNext(); ) {
            edu.jhu.apl.patterns_class.dom.replacement.Node attr =
                    (edu.jhu.apl.patterns_class.dom.replacement.Node) i.next();

            attr.accept(this);
            attrCount++;
        }

        if (attrCount > 0)
            writer.write(" ");

        if (!((edu.jhu.apl.patterns_class.dom.NodeList) element.getChildNodes()).listIterator(0).hasNext()) {
            writer.write("/>");
        } else {
            writer.write(">");

            for (java.util.ListIterator i =
                 ((edu.jhu.apl.patterns_class.dom.NodeList) element.getChildNodes()).listIterator(0);
                 i.hasNext(); ) {
                edu.jhu.apl.patterns_class.dom.replacement.Node child =
                        (edu.jhu.apl.patterns_class.dom.replacement.Node) i.next();

                if (child instanceof edu.jhu.apl.patterns_class.dom.replacement.Element ||
                        child instanceof edu.jhu.apl.patterns_class.dom.replacement.Text)
                    child.accept(this);
            }

            writer.write("</" + element.getTagName() + ">");
        }
    }

    @Override
    public void serializeText(Text text) throws IOException {
        writer.write(text.getData());
    }
}
