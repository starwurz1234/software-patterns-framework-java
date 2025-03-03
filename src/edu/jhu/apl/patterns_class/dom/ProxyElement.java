package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Attr;
import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.NamedNodeMap;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import edu.jhu.apl.patterns_class.dom.replacement.NodeList;
import org.w3c.dom.DOMException;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

public class ProxyElement implements edu.jhu.apl.patterns_class.dom.replacement.Element{

    private Element realElement;

    public ProxyElement(String tagName, edu.jhu.apl.patterns_class.dom.Document document) {
        this.realElement = new Element(tagName, document);
    }

    @Override
    public String getAttribute(String name) {
        return realElement.getAttribute(name);
    }

    @Override
    public Attr getAttributeNode(String name) {
        return realElement.getAttributeNode(name);
    }

    @Override
    public NodeList getElementsByTagName(String tagName) {
        return realElement.getElementsByTagName(tagName);
    }

    @Override
    public String getTagName() {
        return realElement.getTagName();
    }

    @Override
    public boolean hasAttribute(String name) {
        return realElement.hasAttribute(name);
    }

    @Override
    public void removeAttribute(String name) {
        realElement.removeAttribute(name);
    }

    @Override
    public Attr removeAttributeNode(Attr oldAttr) {
        return realElement.removeAttributeNode(oldAttr);
    }

    @Override
    public void setAttribute(String name, String value) {
        realElement.setAttribute(name, value);
    }

    @Override
    public Attr setAttributeNode(Attr newAttr) {
        return realElement.setAttributeNode(newAttr);
    }

    @Override
    public Attr getAttributeNodeNS(String namespaceURI, String localName) {
        return realElement.getAttributeNodeNS(namespaceURI, localName);
    }

    @Override
    public String getAttributeNS(String namespaceURI, String localName) {
        return realElement.getAttributeNS(namespaceURI, localName);
    }

    @Override
    public NodeList getElementsByTagNameNS(String tagName) {
        return realElement.getElementsByTagNameNS(tagName);
    }

    @Override
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        return realElement.hasAttributeNS(namespaceURI, localName);
    }

    @Override
    public void removeAttributeNS(String namespaceURI, String localName) {
        realElement.removeAttributeNS(namespaceURI, localName);
    }

    @Override
    public Attr setAttributeNodeNS(Attr newAttr) {
        return realElement.setAttributeNodeNS(newAttr);
    }

    @Override
    public void setAttributeNS(String namespaceURI, String localName, String value) {
        realElement.setAttributeNS(namespaceURI, localName, value);
    }

    @Override
    public Attr setAttributeNS(Attr newAttr) {
        return realElement.setAttributeNS(newAttr);
    }

    @Override
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        return realElement.getElementsByTagNameNS(namespaceURI, localName);
    }

    @Override
    public void setIdAttributeNode(Attr idAttr, boolean isId) {
        realElement.setIdAttributeNode(idAttr, isId);
    }

    @Override
    public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) {
        realElement.setIdAttributeNS(namespaceURI, localName, isId);
    }

    @Override
    public void setIdAttribute(String name, boolean isId) {
        realElement.setIdAttribute(name, isId);
    }

    @Override
    public TypeInfo getSchemaTypeInfo() {
        return realElement.getSchemaTypeInfo();
    }

    @Override
    public NamedNodeMap getAttributes() {
        return realElement.getAttributes();
    }

    @Override
    public Object getUserData(String key) {
        return realElement.getUserData(key);
    }

    @Override
    public Object setUserData(String key, Object data, UserDataHandler handler) {
        return realElement.setUserData(key, data, handler);
    }

    @Override
    public Object getFeature(String feature, String version) {
        return realElement.getFeature(feature, version);
    }

    @Override
    public boolean isEqualNode(Node arg) {
        return realElement.isEqualNode(arg);
    }

    @Override
    public String lookupNamespaceURI(String prefix) {
        return realElement.lookupNamespaceURI(prefix);
    }

    @Override
    public boolean isDefaultNamespace(String namespaceURI) {
        return realElement.isDefaultNamespace(namespaceURI);
    }

    @Override
    public String lookupPrefix(String namespaceURI) {
        return realElement.lookupPrefix(namespaceURI);
    }

    @Override
    public boolean isSameNode(Node other) {
        return realElement.isSameNode(other);
    }

    @Override
    public void setTextContent(String textContent) {
        realElement.setTextContent(textContent);
    }

    @Override
    public String getTextContent() {
        return realElement.getTextContent();
    }

    @Override
    public short compareDocumentPosition(Node other) {
        return realElement.compareDocumentPosition(other);
    }

    @Override
    public String getBaseURI() {
        return realElement.getBaseURI();
    }

    @Override
    public String getNodeName() {
        return realElement.getNodeName();
    }

    @Override
    public String getNodeValue() throws DOMException {
        return realElement.getNodeValue();
    }

    @Override
    public void setNodeValue(String nodeValue) throws DOMException {
        realElement.setNodeValue(nodeValue);
    }

    @Override
    public short getNodeType() {
        return realElement.getNodeType();
    }

    @Override
    public Node getParentNode() {
        return realElement.getParentNode();
    }

    @Override
    public NodeList getChildNodes() {
        return realElement.getChildNodes();
    }

    @Override
    public Node getFirstChild() {
        return realElement.getFirstChild();
    }

    @Override
    public Node getLastChild() {
        return realElement.getLastChild();
    }

    @Override
    public Node getPreviousSibling() {
        return realElement.getPreviousSibling();
    }

    @Override
    public Node getNextSibling() {
        return realElement.getNextSibling();
    }

    @Override
    public Document getOwnerDocument() {
        return realElement.getOwnerDocument();
    }

    @Override
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        return realElement.insertBefore(newChild, refChild);
    }

    @Override
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        return realElement.replaceChild(newChild, oldChild);
    }

    @Override
    public Node removeChild(Node oldChild) throws DOMException {
        return realElement.removeChild(oldChild);
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        return realElement.appendChild(newChild);
    }

    @Override
    public boolean hasChildNodes() {
        return realElement.hasChildNodes();
    }

    @Override
    public String getLocalName() {
        return realElement.getLocalName();
    }

    @Override
    public void normalize() {
        realElement.normalize();
    }

    @Override
    public boolean isSupported(String feature, String version) {
        return realElement.isSupported(feature, version);
    }

    @Override
    public String getNamespaceURI() {
        return realElement.getNamespaceURI();
    }

    @Override
    public String getPrefix() {
        return realElement.getPrefix();
    }

    @Override
    public void setPrefix(String prefix) throws DOMException {
        realElement.setPrefix(prefix);
    }

    @Override
    public Node cloneNode(boolean deep) {
        return realElement.cloneNode(deep);
    }

    @Override
    public boolean hasAttributes() {
        return realElement.hasAttributes();
    }
}
