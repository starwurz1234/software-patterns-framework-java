package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Attr;
import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import edu.jhu.apl.patterns_class.dom.replacement.NodeList;
import edu.jhu.apl.patterns_class.dom.replacement.Text;
import org.w3c.dom.*;

//Concrete Validator decorator for Document objects
public class DocumentValidator extends Validator<edu.jhu.apl.patterns_class.dom.replacement.Document> implements Document {
    public DocumentValidator(Document node) {
        super(node, node.getNodeName(), node.getNodeType());
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        if (newChild instanceof edu.jhu.apl.patterns_class.dom.replacement.Element) {
            return node.appendChild(newChild);
        }
        return null;
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Element createElement(String tagName) throws DOMException {
        return node.createElement(tagName);
    }

    @Override
    public Text createTextNode(String data) {
        return node.createTextNode(data);
    }

    @Override
    public Attr createAttribute(String name) throws DOMException {
        return node.createAttribute(name);
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Element getDocumentElement() {
        return node.getDocumentElement();
    }

    @Override
    public DOMImplementation getImplementation() {
        return node.getImplementation();
    }

    @Override
    public DocumentType getDoctype() {
        return node.getDoctype();
    }

    @Override
    public DocumentFragment createDocumentFragment() {
        return node.createDocumentFragment();
    }

    @Override
    public Comment createComment(String data) {
        return node.createComment(data);
    }

    @Override
    public CDATASection createCDATASection(String data) throws DOMException {
        return node.createCDATASection(data);
    }

    @Override
    public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException {
        return node.createProcessingInstruction(target, data);
    }

    @Override
    public EntityReference createEntityReference(String name) throws DOMException {
        return node.createEntityReference(name);
    }

    @Override
    public Node importNode(Node importedNode, boolean deep) throws DOMException {
        return node.importNode(importedNode, deep);
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException {
        return node.createElementNS(namespaceURI, qualifiedName);
    }

    @Override
    public Attr createAttributeNS(String namespaceURI, String qualifiedName) throws DOMException {
        return node.createAttributeNS(namespaceURI, qualifiedName);
    }

    @Override
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        return node.getElementsByTagNameNS(namespaceURI, localName);
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Element getElementById(String elementId) {
        return node.getElementById(elementId);
    }

    @Override
    public Node renameNode(Node n, String namespaceURI, String qualifiedName) {
        return node.renameNode(n, namespaceURI, qualifiedName);
    }

    @Override
    public void normalizeDocument() {
        node.normalizeDocument();
    }

    @Override
    public DOMConfiguration getDomConfig() {
        return node.getDomConfig();
    }

    @Override
    public Node adoptNode(Node source) {
        return node.adoptNode(source);
    }

    @Override
    public void setDocumentURI(String documentURI) {
        node.setDocumentURI(documentURI);
    }

    @Override
    public String getDocumentURI() {
        return node.getDocumentURI();
    }

    @Override
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        node.setStrictErrorChecking(strictErrorChecking);
    }

    @Override
    public boolean getStrictErrorChecking() {
        return node.getStrictErrorChecking();
    }

    @Override
    public void setXmlVersion(String xmlVersion) {
        node.setXmlVersion(xmlVersion);
    }

    @Override
    public String getXmlVersion() {
        return node.getXmlVersion();
    }

    @Override
    public void setXmlStandalone(boolean xmlStandalone) {
        node.setXmlStandalone(xmlStandalone);
    }

    @Override
    public boolean getXmlStandalone() {
        return node.getXmlStandalone();
    }

    @Override
    public String getXmlEncoding() {
        return node.getXmlEncoding();
    }

    @Override
    public String getInputEncoding() {
        return node.getInputEncoding();
    }
}
