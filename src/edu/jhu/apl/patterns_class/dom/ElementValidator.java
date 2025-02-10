package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Attr;
import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import edu.jhu.apl.patterns_class.dom.replacement.NodeList;
import org.w3c.dom.DOMException;
import org.w3c.dom.TypeInfo;

public class ElementValidator extends Validator<edu.jhu.apl.patterns_class.dom.replacement.Element> implements edu.jhu.apl.patterns_class.dom.replacement.Element {
    public ElementValidator(edu.jhu.apl.patterns_class.dom.replacement.Element node) {
        super(node, node.getNodeName(), node.getNodeType());
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        if (newChild instanceof edu.jhu.apl.patterns_class.dom.replacement.Document) {
            return null;
        }
        return node.appendChild(newChild);
    }

    @Override
    public String getAttribute(String name) {
        return node.getAttribute(name);
    }

    @Override
    public Attr getAttributeNode(String name) {
        return node.getAttributeNode(name);
    }

    @Override
    public NodeList getElementsByTagName(String tagName) {
        return node.getElementsByTagName(tagName);
    }

    @Override
    public String getTagName() {
        return node.getTagName();
    }

    @Override
    public boolean hasAttribute(String name) {
        return node.hasAttribute(name);
    }

    @Override
    public void removeAttribute(String name) {
        node.removeAttribute(name);
    }

    @Override
    public Attr removeAttributeNode(Attr oldAttr) {
        return node.removeAttributeNode(oldAttr);
    }

    @Override
    public void setAttribute(String name, String value) {
        node.setAttribute(name, value);
    }

    @Override
    public Attr setAttributeNode(Attr newAttr) {
        return node.setAttributeNode(newAttr);
    }

    @Override
    public Attr getAttributeNodeNS(String namespaceURI, String localName) {
        return node.getAttributeNodeNS(namespaceURI, localName);
    }

    @Override
    public String getAttributeNS(String namespaceURI, String localName) {
        return node.getAttributeNS(namespaceURI, localName);
    }

    @Override
    public NodeList getElementsByTagNameNS(String tagName) {
        return node.getElementsByTagNameNS(tagName);
    }

    @Override
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        return node.hasAttributeNS(namespaceURI, localName);
    }

    @Override
    public void removeAttributeNS(String namespaceURI, String localName) {
        node.removeAttributeNS(namespaceURI, localName);
    }

    @Override
    public Attr setAttributeNodeNS(Attr newAttr) {
        return node.setAttributeNodeNS(newAttr);
    }

    @Override
    public void setAttributeNS(String namespaceURI, String localName, String value) {
        node.setAttributeNS(namespaceURI, localName, value);
    }

    @Override
    public Attr setAttributeNS(Attr newAttr) {
        return node.setAttributeNS(newAttr);
    }

    @Override
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        return node.getElementsByTagNameNS(namespaceURI, localName);
    }

    @Override
    public void setIdAttributeNode(Attr idAttr, boolean isId) {
        node.setIdAttributeNode(idAttr, isId);
    }

    @Override
    public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) {
        node.setIdAttributeNS(namespaceURI, localName, isId);
    }

    @Override
    public void setIdAttribute(String name, boolean isId) {
        node.setIdAttribute(name, isId);
    }

    @Override
    public TypeInfo getSchemaTypeInfo() {
        return node.getSchemaTypeInfo();
    }
}
