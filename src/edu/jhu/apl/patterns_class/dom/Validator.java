package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.NamedNodeMap;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import edu.jhu.apl.patterns_class.dom.replacement.NodeList;
import org.w3c.dom.DOMException;
import org.w3c.dom.UserDataHandler;

import java.io.BufferedWriter;
import java.io.IOException;

public class Validator<T extends edu.jhu.apl.patterns_class.dom.replacement.Node> extends edu.jhu.apl.patterns_class.dom.Node{

    T node;

    public Validator(T node, String name, short type) {
        super(name, type);
        this.node = node;
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
        this.node.setNodeValue(nodeValue);
    }

    @Override
    public short getNodeType() {
        return node.getNodeType();
    }

    @Override
    public Node getParentNode() {
        return node.getParentNode();
    }

    @Override
    public NodeList getChildNodes() {
        return node.getChildNodes();
    }

    @Override
    public Node getFirstChild() {
        return node.getFirstChild();
    }

    @Override
    public Node getLastChild() {
        return node.getLastChild();
    }

    @Override
    public Node getPreviousSibling() {
        return node.getPreviousSibling();
    }

    @Override
    public Node getNextSibling() {
        return node.getNextSibling();
    }

    @Override
    public Document getOwnerDocument() {
        return node.getOwnerDocument();
    }

    @Override
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        return node.insertBefore(newChild, refChild);
    }

    @Override
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        return node.replaceChild(newChild, oldChild);
    }

    @Override
    public Node removeChild(Node oldChild) throws DOMException {
        return node.removeChild(oldChild);
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        return node.appendChild(newChild);
    }

    @Override
    public boolean hasChildNodes() {
        return node.hasChildNodes();
    }

    @Override
    public String getLocalName() {
        return node.getLocalName();
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
    public Node cloneNode(boolean deep) {
        return node.cloneNode(deep);
    }

    @Override
    public boolean hasAttributes() {
        return node.hasAttributes();
    }

    @Override
    public NamedNodeMap getAttributes() {
        return node.getAttributes();
    }

    @Override
    public Object getUserData(String key) {
        return node.getUserData(key);
    }

    @Override
    public Object setUserData(String key, Object data, UserDataHandler handler) {
        return node.setUserData(key, data, handler);
    }

    @Override
    public Object getFeature(String feature, String version) {
        return node.getFeature(feature, version);
    }

    @Override
    public boolean isEqualNode(Node arg) {
        return node.isEqualNode(arg);
    }

    @Override
    public String lookupNamespaceURI(String prefix) {
        return node.lookupNamespaceURI(prefix);
    }

    @Override
    public boolean isDefaultNamespace(String namespaceURI) {
        return node.isDefaultNamespace(namespaceURI);
    }

    @Override
    public String lookupPrefix(String namespaceURI) {
        return node.lookupPrefix(namespaceURI);
    }

    @Override
    public boolean isSameNode(Node other) {
        return node.isSameNode(other);
    }

    @Override
    public void setTextContent(String textContent) {
        node.setTextContent(textContent);
    }

    @Override
    public String getTextContent() {
        return node.getTextContent();
    }

    @Override
    public short compareDocumentPosition(Node other) {
        return node.compareDocumentPosition(other);
    }

    @Override
    public String getBaseURI() {
        return node.getBaseURI();
    }

    @Override
    public int serializePretty(BufferedWriter writer, int indentationLevel) throws IOException {
        return node.serializePretty(writer, indentationLevel);
    }

    @Override
    public void serializeMinimal(BufferedWriter writer) throws IOException {
        node.serializeMinimal(writer);
    }
}
