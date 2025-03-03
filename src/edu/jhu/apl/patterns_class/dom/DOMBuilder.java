package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.XMLTokenizer;
import edu.jhu.apl.patterns_class.dom.interfaces.Builder;
import edu.jhu.apl.patterns_class.dom.replacement.Node;

import java.util.Stack;

import static edu.jhu.apl.patterns_class.XMLTokenizer.XMLToken.*;

public class DOMBuilder implements Builder {

    edu.jhu.apl.patterns_class.dom.replacement.Document document;
    Stack<edu.jhu.apl.patterns_class.dom.replacement.Node> workingNodes;
    private static DOMBuilder instance;

    private DOMBuilder() {
        this.document = new ProxyElementFactory();
        this.workingNodes = new Stack<>();
    }

    public static DOMBuilder getInstance() {
        if (instance == null) {
            instance = new DOMBuilder();
        }

        return instance;
    }

    public edu.jhu.apl.patterns_class.dom.replacement.Document getDocument() {
        return this.document;
    }

    public void setWorkingNodes(Stack<Node> nodes) {
        this.workingNodes = nodes;
    }

    public void setDocument(edu.jhu.apl.patterns_class.dom.replacement.Document document) {
        this.document = document;
    }

    @Override
    public void addToken(XMLTokenizer.XMLToken token) {

        switch(token.getTokenType()) {
            case NULL:
                return;
            case PROLOG_START:
                break;
            case PROLOG_IDENTIFIER:
                break;
            case ATTRIBUTE_VALUE:
                if (workingNodes.empty())
                    return;
                Attr workingAttr = (Attr)workingNodes.pop();
                workingAttr.setValue(token.getToken());
                if (workingNodes.empty())
                    return;
                edu.jhu.apl.patterns_class.dom.replacement.Node workingNode = workingNodes.peek();
                if (workingNode instanceof Element) {
                    ((Element)workingNode).setAttributeNode(workingAttr);
                }
                break;
            case PROLOG_END:
                break;
            case TAG_START:
                break;
            case ELEMENT:
                if (token.getToken().equals("element")) {
                    edu.jhu.apl.patterns_class.dom.replacement.Element newElement = document.createElement("element");
                    workingNodes.push(newElement);
                }
                break;
            case ATTRIBUTE:
                String attrName = token.getToken().split("=")[0];
                Attr attr = (Attr)document.createAttribute(attrName);
                workingNodes.push(attr);
                break;
            case NULL_TAG_END:
                Node node = workingNodes.pop();

                if (node != null) {
                    this.document.appendChild(node);
                }
                break;
            case TAG_CLOSE_START:
                break;
            case VALUE:
                Text text = (Text)document.createTextNode(token.getToken());
                workingNodes.peek().appendChild(text);
                break;
            case TAG_END:
                break;
            default:
                break;
        }
    }
}
