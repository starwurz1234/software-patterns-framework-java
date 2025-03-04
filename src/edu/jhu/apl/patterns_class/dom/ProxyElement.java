package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.XMLTokenizer;
import edu.jhu.apl.patterns_class.dom.replacement.Attr;
import edu.jhu.apl.patterns_class.dom.replacement.Document;
import edu.jhu.apl.patterns_class.dom.replacement.NamedNodeMap;
import edu.jhu.apl.patterns_class.dom.replacement.Node;
import edu.jhu.apl.patterns_class.dom.replacement.NodeList;
import org.w3c.dom.DOMException;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ProxyElement extends edu.jhu.apl.patterns_class.dom.Node implements edu.jhu.apl.patterns_class.dom.replacement.Element{

    private Element realElement;
    private boolean instatiated;
    private String filename;
    private String line;

    public ProxyElement(String tagName, edu.jhu.apl.patterns_class.dom.Document document) {
        super("", (short)0);
        this.realElement = new Element(tagName, document);
    }

    private void instantiate() {

        /*
        Read this element from the file when instantiate gets called.
        Only instantiate when values need to be read from this element.

        try {
            XMLTokenizer tokenizer = new XMLTokenizer(filename);

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
        }
         */
        
        instatiated = true;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String getAttribute(String name) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getAttribute(name);
    }

    @Override
    public Attr getAttributeNode(String name) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getAttributeNode(name);
    }

    @Override
    public NodeList getElementsByTagName(String tagName) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getElementsByTagName(tagName);
    }

    @Override
    public String getTagName() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getTagName();
    }

    @Override
    public boolean hasAttribute(String name) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.hasAttribute(name);
    }

    @Override
    public void removeAttribute(String name) {
        if (!instatiated) {
            instantiate();
        }
        realElement.removeAttribute(name);
    }

    @Override
    public Attr removeAttributeNode(Attr oldAttr) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.removeAttributeNode(oldAttr);
    }

    @Override
    public void setAttribute(String name, String value) {
        if (instatiated) {
            realElement.setAttribute(name, value);
        }
    }

    @Override
    public Attr setAttributeNode(Attr newAttr) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.setAttributeNode(newAttr);
    }

    @Override
    public Attr getAttributeNodeNS(String namespaceURI, String localName) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getAttributeNodeNS(namespaceURI, localName);
    }

    @Override
    public String getAttributeNS(String namespaceURI, String localName) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getAttributeNS(namespaceURI, localName);
    }

    @Override
    public NodeList getElementsByTagNameNS(String tagName) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getElementsByTagNameNS(tagName);
    }

    @Override
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.hasAttributeNS(namespaceURI, localName);
    }

    @Override
    public void removeAttributeNS(String namespaceURI, String localName) {
        if (instatiated) {
            realElement.removeAttributeNS(namespaceURI, localName);
        }
    }

    @Override
    public Attr setAttributeNodeNS(Attr newAttr) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.setAttributeNodeNS(newAttr);
    }

    @Override
    public void setAttributeNS(String namespaceURI, String localName, String value) {
        if (instatiated) {
            realElement.setAttributeNS(namespaceURI, localName, value);
        }
    }

    @Override
    public Attr setAttributeNS(Attr newAttr) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.setAttributeNS(newAttr);
    }

    @Override
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getElementsByTagNameNS(namespaceURI, localName);
    }

    @Override
    public void setIdAttributeNode(Attr idAttr, boolean isId) {
        if (instatiated) {
            realElement.setIdAttributeNode(idAttr, isId);
        }

    }

    @Override
    public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) {
        if (instatiated) {
            realElement.setIdAttributeNS(namespaceURI, localName, isId);
        }
    }

    @Override
    public void setIdAttribute(String name, boolean isId) {
        if (instatiated) {
            realElement.setIdAttribute(name, isId);
        }
    }

    @Override
    public TypeInfo getSchemaTypeInfo() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getSchemaTypeInfo();
    }

    @Override
    public NamedNodeMap getAttributes() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getAttributes();
    }

    @Override
    public Object getUserData(String key) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getUserData(key);
    }

    @Override
    public Object setUserData(String key, Object data, UserDataHandler handler) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.setUserData(key, data, handler);
    }

    @Override
    public Object getFeature(String feature, String version) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getFeature(feature, version);
    }

    @Override
    public boolean isEqualNode(Node arg) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.isEqualNode(arg);
    }

    @Override
    public String lookupNamespaceURI(String prefix) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.lookupNamespaceURI(prefix);
    }

    @Override
    public boolean isDefaultNamespace(String namespaceURI) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.isDefaultNamespace(namespaceURI);
    }

    @Override
    public String lookupPrefix(String namespaceURI) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.lookupPrefix(namespaceURI);
    }

    @Override
    public boolean isSameNode(Node other) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.isSameNode(other);
    }

    @Override
    public void setTextContent(String textContent) {
        if (instatiated) {
            realElement.setTextContent(textContent);
        }
    }

    @Override
    public String getTextContent() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getTextContent();
    }

    @Override
    public short compareDocumentPosition(Node other) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.compareDocumentPosition(other);
    }

    @Override
    public String getBaseURI() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getBaseURI();
    }

    @Override
    public int serializePretty(BufferedWriter writer, int indentationLevel) throws IOException {
        if (!instatiated) {
            instantiate();
        }
        return realElement.serializePretty(writer, indentationLevel);
    }

    @Override
    public void serializeMinimal(BufferedWriter writer) throws IOException {
        if (!instatiated) {
            instantiate();
        }
        realElement.serializeMinimal(writer);
    }

    @Override
    public String getNodeName() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getNodeName();
    }

    @Override
    public String getNodeValue() throws DOMException {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getNodeValue();
    }

    @Override
    public void setNodeValue(String nodeValue) throws DOMException {
        if (instatiated) {
            realElement.setNodeValue(nodeValue);
        }
    }

    @Override
    public short getNodeType() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getNodeType();
    }

    @Override
    public Node getParentNode() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getParentNode();
    }

    @Override
    public NodeList getChildNodes() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getChildNodes();
    }

    @Override
    public Node getFirstChild() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getFirstChild();
    }

    @Override
    public Node getLastChild() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getLastChild();
    }

    @Override
    public Node getPreviousSibling() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getPreviousSibling();
    }

    @Override
    public Node getNextSibling() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getNextSibling();
    }

    @Override
    public Document getOwnerDocument() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getOwnerDocument();
    }

    @Override
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        if (!instatiated) {
            instantiate();
        }
        return realElement.insertBefore(newChild, refChild);
    }

    @Override
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        if (!instatiated) {
            instantiate();
        }
        return realElement.replaceChild(newChild, oldChild);
    }

    @Override
    public Node removeChild(Node oldChild) throws DOMException {
        if (!instatiated) {
            instantiate();
        }
        return realElement.removeChild(oldChild);
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        if (!instatiated) {
            instantiate();
        }
        return realElement.appendChild(newChild);
    }

    @Override
    public boolean hasChildNodes() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.hasChildNodes();
    }

    @Override
    public String getLocalName() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getLocalName();
    }

    @Override
    public void normalize() {
        if (instatiated) {
            realElement.normalize();
        }
    }

    @Override
    public boolean isSupported(String feature, String version) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.isSupported(feature, version);
    }

    @Override
    public String getNamespaceURI() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getNamespaceURI();
    }

    @Override
    public String getPrefix() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.getPrefix();
    }

    @Override
    public void setPrefix(String prefix) throws DOMException {
        if (instatiated) {
            realElement.setPrefix(prefix);
        }
    }

    @Override
    public Node cloneNode(boolean deep) {
        if (!instatiated) {
            instantiate();
        }
        return realElement.cloneNode(deep);
    }

    @Override
    public boolean hasAttributes() {
        if (!instatiated) {
            instantiate();
        }
        return realElement.hasAttributes();
    }
}
