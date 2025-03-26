package edu.jhu.apl.patterns_class.dom;

import org.w3c.dom.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class DocumentAdapter implements Document {

    edu.jhu.apl.patterns_class.dom.replacement.Document document;

    public DocumentAdapter(edu.jhu.apl.patterns_class.dom.replacement.Document doc) {
        this.document = doc;
    }

    @Override
    public DocumentType getDoctype() {
        return document.getDoctype();
    }

    @Override
    public DOMImplementation getImplementation() {
        return document.getImplementation();
    }

    @Override
    public Element getDocumentElement() {
        return new ElementAdapter(document.getDocumentElement());
    }

    @Override
    public Element createElement(String tagName) throws DOMException {
        return new ElementAdapter(document.createElement(tagName));
    }

    @Override
    public DocumentFragment createDocumentFragment() {
        return document.createDocumentFragment();
    }

    @Override
    public Text createTextNode(String data) {
        return new TextAdapter(document.createTextNode(data));
    }

    @Override
    public Comment createComment(String data) {
        return document.createComment(data);
    }

    @Override
    public CDATASection createCDATASection(String data) throws DOMException {
        return document.createCDATASection(data);
    }

    @Override
    public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException {
        return document.createProcessingInstruction(target, data);
    }

    @Override
    public Attr createAttribute(String name) throws DOMException {
        return new AttrAdapter(document.createAttribute(name));
    }

    @Override
    public EntityReference createEntityReference(String name) throws DOMException {
        return document.createEntityReference(name);
    }

    @Override
    public NodeList getElementsByTagName(String tagname) {
        return null;
    }

    @Override
    public Node importNode(Node importedNode, boolean deep) throws DOMException {
        return new NodeAdapter(document.importNode(new W3cNodeAdapter(importedNode), deep));
    }

    @Override
    public Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException {
        return new ElementAdapter(document.createElementNS(namespaceURI, qualifiedName));
    }

    @Override
    public Attr createAttributeNS(String namespaceURI, String qualifiedName) throws DOMException {
        return new AttrAdapter(document.createAttributeNS(namespaceURI, qualifiedName));
    }

    @Override
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        return new NodeListAdapter(document.getElementsByTagNameNS(namespaceURI, localName));
    }

    @Override
    public Element getElementById(String elementId) {
        return new ElementAdapter(document.getElementById(elementId));
    }

    @Override
    public String getInputEncoding() {
        return document.getInputEncoding();
    }

    @Override
    public String getXmlEncoding() {
        return document.getXmlEncoding();
    }

    @Override
    public boolean getXmlStandalone() {
        return document.getXmlStandalone();
    }

    @Override
    public void setXmlStandalone(boolean xmlStandalone) throws DOMException {
        document.setXmlStandalone(xmlStandalone);
    }

    @Override
    public String getXmlVersion() {
        return document.getXmlVersion();
    }

    @Override
    public void setXmlVersion(String xmlVersion) throws DOMException {
        document.setXmlVersion(xmlVersion);
    }

    @Override
    public boolean getStrictErrorChecking() {
        return document.getStrictErrorChecking();
    }

    @Override
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        document.setStrictErrorChecking(strictErrorChecking);
    }

    @Override
    public String getDocumentURI() {
        return document.getDocumentURI();
    }

    @Override
    public void setDocumentURI(String documentURI) {
        document.setDocumentURI(documentURI);
    }

    @Override
    public Node adoptNode(Node source) throws DOMException {
        return new NodeAdapter(document.adoptNode(new W3cNodeAdapter(source)));
    }

    @Override
    public DOMConfiguration getDomConfig() {
        return document.getDomConfig();
    }

    @Override
    public void normalizeDocument() {
        document.normalizeDocument();
    }

    @Override
    public Node renameNode(Node n, String namespaceURI, String qualifiedName) throws DOMException {
        return new NodeAdapter(document.renameNode(new W3cNodeAdapter(n), namespaceURI, qualifiedName));
    }

    @Override
    public String getNodeName() {
        return document.getNodeName();
    }

    @Override
    public String getNodeValue() throws DOMException {
        return document.getNodeValue();
    }

    @Override
    public void setNodeValue(String nodeValue) throws DOMException {
        document.setNodeValue(nodeValue);
    }

    @Override
    public short getNodeType() {
        return document.getNodeType();
    }

    @Override
    public Node getParentNode() {
        return new NodeAdapter(document.getParentNode());
    }

    @Override
    public NodeList getChildNodes() {
        return new NodeListAdapter(document.getChildNodes());
    }

    @Override
    public Node getFirstChild() {
        return new NodeAdapter(document.getFirstChild());
    }

    @Override
    public Node getLastChild() {
        return new NodeAdapter(document.getLastChild());
    }

    @Override
    public Node getPreviousSibling() {
        return new NodeAdapter(document.getPreviousSibling());
    }

    @Override
    public Node getNextSibling() {
        return new NodeAdapter(document.getNextSibling());
    }

    @Override
    public NamedNodeMap getAttributes() {
        return new NamedNodeMapAdapter(document.getAttributes());
    }

    @Override
    public Document getOwnerDocument() {
        return new DocumentAdapter(document.getOwnerDocument());
    }

    @Override
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        return new NodeAdapter(document.insertBefore(new W3cNodeAdapter(newChild), new W3cNodeAdapter(refChild)));
    }

    @Override
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        return new NodeAdapter(document.replaceChild(new W3cNodeAdapter(newChild), new W3cNodeAdapter(oldChild)));
    }

    @Override
    public Node removeChild(Node oldChild) throws DOMException {
        return new NodeAdapter(document.removeChild(new W3cNodeAdapter(oldChild)));
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        return new NodeAdapter(document.appendChild(new W3cNodeAdapter(newChild)));
    }

    @Override
    public boolean hasChildNodes() {
        return document.hasChildNodes();
    }

    @Override
    public Node cloneNode(boolean deep) {
        return new NodeAdapter(document.cloneNode(deep));
    }

    @Override
    public void normalize() {
        document.normalize();
    }

    @Override
    public boolean isSupported(String feature, String version) {
        return document.isSupported(feature, version);
    }

    @Override
    public String getNamespaceURI() {
        return document.getNamespaceURI();
    }

    @Override
    public String getPrefix() {
        return document.getPrefix();
    }

    @Override
    public void setPrefix(String prefix) throws DOMException {
        document.setPrefix(prefix);
    }

    @Override
    public String getLocalName() {
        return document.getLocalName();
    }

    @Override
    public boolean hasAttributes() {
        return document.hasAttributes();
    }

    @Override
    public String getBaseURI() {
        return document.getBaseURI();
    }

    @Override
    public short compareDocumentPosition(Node other) throws DOMException {
        return document.compareDocumentPosition(new W3cNodeAdapter(other));
    }

    @Override
    public String getTextContent() throws DOMException {
        return document.getTextContent();
    }

    @Override
    public void setTextContent(String textContent) throws DOMException {
        document.setTextContent(textContent);
    }

    @Override
    public boolean isSameNode(Node other) {
        return document.isSameNode(new W3cNodeAdapter(other));
    }

    @Override
    public String lookupPrefix(String namespaceURI) {
        return document.lookupPrefix(namespaceURI);
    }

    @Override
    public boolean isDefaultNamespace(String namespaceURI) {
        return document.isDefaultNamespace(namespaceURI);
    }

    @Override
    public String lookupNamespaceURI(String prefix) {
        return document.lookupNamespaceURI(prefix);
    }

    @Override
    public boolean isEqualNode(Node arg) {
        return document.isEqualNode(new W3cNodeAdapter(arg));
    }

    @Override
    public Object getFeature(String feature, String version) {
        return document.getFeature(feature, version);
    }

    @Override
    public Object setUserData(String key, Object data, UserDataHandler handler) {
        return document.setUserData(key, data, handler);
    }

    @Override
    public Object getUserData(String key) {
        return document.getUserData(key);
    }
}
