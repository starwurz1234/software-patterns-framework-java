package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.NamedNodeMap;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import edu.jhu.apl.patterns_class.dom.replacement.NodeList;
import org.w3c.dom.DOMException;
import org.w3c.dom.UserDataHandler;

public class W3cNodeAdapter implements Node {

    org.w3c.dom.Node node;

    public W3cNodeAdapter(org.w3c.dom.Node n) {
        this.node = n;
    }

    @Override
    public String getNodeName() {
        return "";
    }

    @Override
    public String getNodeValue() throws DOMException {
        return "";
    }

    @Override
    public void setNodeValue(String nodeValue) throws DOMException {

    }

    @Override
    public short getNodeType() {
        return 0;
    }

    @Override
    public Node getParentNode() {
        return null;
    }

    @Override
    public NodeList getChildNodes() {
        return null;
    }

    @Override
    public Node getFirstChild() {
        return null;
    }

    @Override
    public Node getLastChild() {
        return null;
    }

    @Override
    public Node getPreviousSibling() {
        return null;
    }

    @Override
    public Node getNextSibling() {
        return null;
    }

    @Override
    public Document getOwnerDocument() {
        return null;
    }

    @Override
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        return null;
    }

    @Override
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        return null;
    }

    @Override
    public Node removeChild(Node oldChild) throws DOMException {
        return null;
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        return null;
    }

    @Override
    public boolean hasChildNodes() {
        return false;
    }

    @Override
    public String getLocalName() {
        return "";
    }

    @Override
    public void normalize() {

    }

    @Override
    public boolean isSupported(String feature, String version) {
        return false;
    }

    @Override
    public String getNamespaceURI() {
        return "";
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public void setPrefix(String prefix) throws DOMException {

    }

    @Override
    public Node cloneNode(boolean deep) {
        return null;
    }

    @Override
    public boolean hasAttributes() {
        return false;
    }

    @Override
    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override
    public Object getUserData(String key) {
        return null;
    }

    @Override
    public Object setUserData(String key, Object data, UserDataHandler handler) {
        return null;
    }

    @Override
    public Object getFeature(String feature, String version) {
        return null;
    }

    @Override
    public boolean isEqualNode(Node arg) {
        return false;
    }

    @Override
    public String lookupNamespaceURI(String prefix) {
        return "";
    }

    @Override
    public boolean isDefaultNamespace(String namespaceURI) {
        return false;
    }

    @Override
    public String lookupPrefix(String namespaceURI) {
        return "";
    }

    @Override
    public boolean isSameNode(Node other) {
        return false;
    }

    @Override
    public void setTextContent(String textContent) {

    }

    @Override
    public String getTextContent() {
        return "";
    }

    @Override
    public short compareDocumentPosition(Node other) {
        return 0;
    }

    @Override
    public String getBaseURI() {
        return "";
    }
}
