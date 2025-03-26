package edu.jhu.apl.patterns_class.dom;

import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeAdapter implements Node {

    edu.jhu.apl.patterns_class.dom.replacement.Node node;

    public NodeAdapter(String name, short type) {
        this.node = new edu.jhu.apl.patterns_class.dom.Node(name, type);
    }

    public NodeAdapter(edu.jhu.apl.patterns_class.dom.replacement.Node other) {
        this.node = other;
    }

    @Override
    public String getNodeName() {
        return node.getNodeName();
    }

    @Override
    public String getNodeValue() throws DOMException {
        return node.getNodeValue();
    }

    @Override
    public void setNodeValue(String nodeValue) throws DOMException {
        node.setNodeValue(nodeValue);
    }

    @Override
    public short getNodeType() {
        return node.getNodeType();
    }

    @Override
    public Node getParentNode() {
        return new NodeAdapter(node.getParentNode());
    }

    @Override
    public NodeList getChildNodes() {
        return new NodeListAdapter(node.getChildNodes());
    }

    @Override
    public Node getFirstChild() {
        return new NodeAdapter(node.getFirstChild());
    }

    @Override
    public Node getLastChild() {
        return new NodeAdapter(node.getLastChild());
    }

    @Override
    public Node getPreviousSibling() {
        return new NodeAdapter(node.getPreviousSibling());
    }

    @Override
    public Node getNextSibling() {
        return new NodeAdapter(node.getNextSibling());
    }

    @Override
    public NamedNodeMap getAttributes() {
        return new NamedNodeMapAdapter(node.getAttributes());
    }

    @Override
    public Document getOwnerDocument() {
        return new DocumentAdapter(node.getOwnerDocument());
    }

    @Override
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        return new NodeAdapter(node.insertBefore(new W3cNodeAdapter(newChild), new W3cNodeAdapter(refChild)));
    }

    @Override
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        return new NodeAdapter(node.replaceChild(new W3cNodeAdapter(newChild), new W3cNodeAdapter(oldChild)));
    }

    @Override
    public Node removeChild(Node oldChild) throws DOMException {
        return new NodeAdapter((node.removeChild(new W3cNodeAdapter(oldChild))));
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        return new NodeAdapter(node.appendChild(new W3cNodeAdapter(newChild)));
    }

    @Override
    public boolean hasChildNodes() {
        return node.hasChildNodes();
    }

    @Override
    public Node cloneNode(boolean deep) {
        return null;
    }

    @Override
    public void normalize() {
        node.normalize();
    }

    @Override
    public boolean isSupported(String feature, String version) {
        return node.isSupported(feature, version);
    }

    @Override
    public String getNamespaceURI() {
        return node.getNamespaceURI();
    }

    @Override
    public String getPrefix() {
        return node.getPrefix();
    }

    @Override
    public void setPrefix(String prefix) throws DOMException {
        node.setPrefix(prefix);
    }

    @Override
    public String getLocalName() {
        return node.getLocalName();
    }

    @Override
    public boolean hasAttributes() {
        return node.hasAttributes();
    }

    @Override
    public String getBaseURI() {
        return node.getBaseURI();
    }

    @Override
    public short compareDocumentPosition(Node other) throws DOMException {
        return node.compareDocumentPosition(new W3cNodeAdapter(other));
    }

    @Override
    public String getTextContent() throws DOMException {
        return node.getTextContent();
    }

    @Override
    public void setTextContent(String textContent) throws DOMException {
        node.setTextContent(textContent);
    }

    @Override
    public boolean isSameNode(Node other) {
        return node.isSameNode(new W3cNodeAdapter(other));
    }

    @Override
    public String lookupPrefix(String namespaceURI) {
        return node.lookupPrefix(namespaceURI);
    }

    @Override
    public boolean isDefaultNamespace(String namespaceURI) {
        return node.isDefaultNamespace(namespaceURI);
    }

    @Override
    public String lookupNamespaceURI(String prefix) {
        return node.lookupNamespaceURI(prefix);
    }

    @Override
    public boolean isEqualNode(Node arg) {
        return node.isEqualNode(new W3cNodeAdapter(arg));
    }

    @Override
    public Object getFeature(String feature, String version) {
        return node.getFeature(feature, version);
    }

    @Override
    public Object setUserData(String key, Object data, UserDataHandler handler) {
        return node.setUserData(key, data, handler);
    }

    @Override
    public Object getUserData(String key) {
        return node.getUserData(key);
    }
}
