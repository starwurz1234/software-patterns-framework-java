package edu.jhu.apl.patterns_class;

import java.util.Iterator;
import java.util.Scanner;

import edu.jhu.apl.patterns_class.dom.replacement.Attr;
import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

public class ModifyAttributeCommand implements Command {

    @Override
    public Document execute(Document document) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter attribute name: ");
        String attrName = input.next();
        System.out.print("Enter new value for attribute: ");
        String attrValue = input.next();
        Iterator<Node> iter = document.createIterator(document.getDocumentElement());
        while (iter.hasNext()) {
            Node n = iter.next();
            if (n.hasAttributes()) {
                Node attr = n.getAttributes().getNamedItem(attrName);
                if (attr != null) {
                    if (attr instanceof Attr) {
                        attr.setNodeValue(attrValue);
                    }
                }
            }
        }

        return document;
    }

}
