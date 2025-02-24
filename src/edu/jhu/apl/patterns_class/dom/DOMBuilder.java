package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.XMLTokenizer;
import edu.jhu.apl.patterns_class.dom.interfaces.Builder;

import java.util.Stack;

import static edu.jhu.apl.patterns_class.XMLTokenizer.XMLToken.*;

public class DOMBuilder implements Builder {

    edu.jhu.apl.patterns_class.dom.replacement.Document document;
    AbstractNodeFactory attrFactory;
    AbstractNodeFactory elementFactory;
    AbstractNodeFactory textFactory;
    Stack<Node> workingNodes;

    public DOMBuilder() {
        this.document = new Document();
        this.attrFactory = new AttrFactory();
        this.elementFactory = new ElementFactory();
        this.textFactory = new TextFactory();
        this.workingNodes = new Stack<>();
    }

    public edu.jhu.apl.patterns_class.dom.replacement.Document getDocument() {
        return this.document;
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
                Node workingNode = workingNodes.peek();
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
                    Element newElement = (Element) elementFactory.createNode("element", (Document)this.document);
                    workingNodes.push(newElement);
                }
                break;
            case ATTRIBUTE:
                String attrName = token.getToken().split("=")[0];
                Attr attr = (Attr)attrFactory.createNode(attrName, (Document)this.document);
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
                Text text = (Text)textFactory.createNode(token.getToken(), (Document)this.document);
                workingNodes.peek().appendChild(text);
                break;
            case TAG_END:
                break;
            default:
                break;
        }
    }
}
