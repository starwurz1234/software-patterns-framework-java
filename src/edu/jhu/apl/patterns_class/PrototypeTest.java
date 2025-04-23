package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import org.w3c.dom.DOMException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PrototypeTest {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Input and output filenames not provided");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        Document document = new edu.jhu.apl.patterns_class.dom.Document();
        Builder builder = new Builder(document);
        try {
            Director director = new Director(inputFile, builder);
            Document doc = builder.getDocument();
            Node docProto = doc.clone(null);

            XMLSerializer serializer = new XMLSerializer(new OutputStreamWriter(new FileOutputStream(outputFile)));
            serializer.serializePretty(docProto);
            serializer.close();
        } catch (DOMException | IOException e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
    }

}
