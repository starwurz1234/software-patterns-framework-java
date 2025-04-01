package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.XMLTokenizer;
import edu.jhu.apl.patterns_class.dom.interfaces.Builder;
import edu.jhu.apl.patterns_class.dom.interfaces.ChangeManager;
import edu.jhu.apl.patterns_class.dom.interfaces.Observer;

import java.util.Stack;

import static edu.jhu.apl.patterns_class.XMLTokenizer.XMLToken.*;

public class DOMBuilder implements Builder {

    edu.jhu.apl.patterns_class.dom.replacement.Document document;
    Stack<Node> workingNodes;
    String state = "";
    ChangeManager changeManager;

    public DOMBuilder(ChangeManager cManager) {
        this.document = new Document();
        this.workingNodes = new Stack<>();
        this.changeManager = cManager;
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
                setState("Setting attribute value to " + token.getToken());
                if (workingNodes.empty())
                    return;
                Node workingNode = workingNodes.peek();
                if (workingNode instanceof Element) {
                    ((Element)workingNode).setAttributeNode(workingAttr);
                    setState("Setting attribute node");
                }
                break;
            case PROLOG_END:
                break;
            case TAG_START:
                break;
            case ELEMENT:
                if (token.getToken().equals("element")) {
                    Element newElement = (Element) document.createElement("element");
                    setState("Creating element from document");
                    workingNodes.push(newElement);
                }
                break;
            case ATTRIBUTE:
                String attrName = token.getToken().split("=")[0];
                Attr attr = (Attr)document.createAttribute(attrName);
                setState("Creating attribute " + attrName);
                workingNodes.push(attr);
                break;
            case NULL_TAG_END:
                Node node = workingNodes.pop();

                if (node != null) {
                    this.document.appendChild(node);
                    setState("Appending child " + node.getNodeName());
                }
                break;
            case TAG_CLOSE_START:
                break;
            case VALUE:
                Text text = (Text)document.createTextNode(token.getToken());
                setState("Creating text " + token.getToken());
                workingNodes.peek().appendChild(text);
                break;
            case TAG_END:
                break;
            default:
                break;
        }
    }

    @Override
    public void attach(Observer observer) {
        this.changeManager.register(this, observer);
    }

    @Override
    public void detach(Observer observer) {
        this.changeManager.unregister(this, observer);
    }

    @Override
    public void notifyObservers() {
        this.changeManager.notifyObservers();
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}
