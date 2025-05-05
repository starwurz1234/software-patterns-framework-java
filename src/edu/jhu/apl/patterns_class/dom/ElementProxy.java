package edu.jhu.apl.patterns_class.dom;

public class ElementProxy implements edu.jhu.apl.patterns_class.dom.replacement.Element
{
	private edu.jhu.apl.patterns_class.dom.replacement.Element	realSubject	= null;
	private boolean							realized	= false;
	private edu.jhu.apl.patterns_class.Director			director	= null;

	//
	// Prototype Clone
	//
	public edu.jhu.apl.patterns_class.dom.replacement.Node cloneNode(boolean deep)
	{
		ElementProxy	temp	=
		  new ElementProxy((edu.jhu.apl.patterns_class.dom.replacement.Element )realSubject.cloneNode(deep), director);
		temp.realize();
		return temp;
	}

	//
	// Chain of Responsibility
	//
	public void HandleRequest(String event)
	{
		realSubject.HandleRequest(event);
	}

	public ElementProxy(edu.jhu.apl.patterns_class.dom.replacement.Element realSubject,
	  edu.jhu.apl.patterns_class.Director director)
	{
		this.realSubject	= realSubject;
		this.director		= director;
	}

	public edu.jhu.apl.patterns_class.dom.replacement.NodeList getChildNodes()
	{
		if (!realized)
			realize();

		return realSubject.getChildNodes();
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node getFirstChild()
	{
		if (!realized)
			realize();

		return realSubject.getFirstChild();
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node getLastChild()
	{
		if (!realized)
			realize();

		return realSubject.getLastChild();
	}

	public boolean hasChildNodes()
	{
		if (!realized)
			realize();

		return realSubject.hasChildNodes();
	}

	public void realize()
	{
		// Realize by parsing child nodes.
		realized	= true;
	}

	//
	// Passthrough Element members.
	//
	public void Accept(edu.jhu.apl.patterns_class.Visitor visitor) throws java.io.IOException
	{
		realSubject.Accept(visitor);
	}
	public String getAttribute(String name)
	{
		return realSubject.getAttribute(name);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr getAttributeNode(String name)
	{
		return realSubject.getAttributeNode(name);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.NodeList getElementsByTagName(String tagName)
	{
		return realSubject.getElementsByTagName(tagName);
	}
	public String getTagName()
	{
		return realSubject.getTagName();
	}
	public boolean hasAttribute(String name)
	{
		return realSubject.hasAttribute(name);
	}
	public void removeAttribute(String name)
	{
		realSubject.removeAttribute(name);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr
	  removeAttributeNode(edu.jhu.apl.patterns_class.dom.replacement.Attr oldAttr)
	{
		return realSubject.removeAttributeNode(oldAttr);
	}
	public void setAttribute(String name, String value)
	{
		realSubject.setAttribute(name, value);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr
	  setAttributeNode(edu.jhu.apl.patterns_class.dom.replacement.Attr newAttr)
	{
		return realSubject.setAttributeNode(newAttr);
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node
	  insertBefore(edu.jhu.apl.patterns_class.dom.replacement.Node newChild,
	  edu.jhu.apl.patterns_class.dom.replacement.Node refChild) throws org.w3c.dom.DOMException
	{
		return realSubject.insertBefore(newChild, refChild);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Node
	  replaceChild(edu.jhu.apl.patterns_class.dom.replacement.Node newChild,
	  edu.jhu.apl.patterns_class.dom.replacement.Node oldChild) throws org.w3c.dom.DOMException
	{
		return realSubject.replaceChild(newChild, oldChild);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Node appendChild(edu.jhu.apl.patterns_class.dom.replacement.Node newChild)
	  throws org.w3c.dom.DOMException
	{
		return realSubject.appendChild(newChild);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Node removeChild(edu.jhu.apl.patterns_class.dom.replacement.Node oldChild)
	  throws org.w3c.dom.DOMException
	{
		return realSubject.removeChild(oldChild);
	}

	//
	// Unimplemented Element members.
	//
	public edu.jhu.apl.patterns_class.dom.replacement.Attr getAttributeNodeNS(String namespaceURI, String localName)
	  { return null; }
	public String getAttributeNS(String namespaceURI, String localName) { return null; }
	public edu.jhu.apl.patterns_class.dom.replacement.NodeList getElementsByTagNameNS(String tagName) { return null; }
	public boolean hasAttributeNS(String namespaceURI, String localName) { return false; }
	public void removeAttributeNS(String namespaceURI, String localName) {}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr
	  setAttributeNodeNS(edu.jhu.apl.patterns_class.dom.replacement.Attr newAttr) { return null; }
	public void setAttributeNS(String namespaceURI, String localName, String value) {}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr
	  setAttributeNS(edu.jhu.apl.patterns_class.dom.replacement.Attr newAttr) { return null; }
	public edu.jhu.apl.patterns_class.dom.replacement.NodeList
	  getElementsByTagNameNS(String namespaceURI, String localName) { return null; }
	public void setIdAttributeNode(edu.jhu.apl.patterns_class.dom.replacement.Attr idAttr, boolean isId) {}
	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) {}
	public void setIdAttribute(String name, boolean isId) {}
	public org.w3c.dom.TypeInfo getSchemaTypeInfo() { return null; }



	//
	// Reimplemented Node members.
	//
	public String getNodeName()							{ return realSubject.getNodeName(); }
	public String getNodeValue() throws org.w3c.dom.DOMException			{ return realSubject.getNodeValue(); }
	public void setNodeValue(String nodeValue) throws org.w3c.dom.DOMException	{ realSubject.setNodeValue(nodeValue); }
	public short getNodeType()							{ return realSubject.getNodeType(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Node getParentNode()		{ return realSubject.getParentNode(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Node getPreviousSibling()	{ return realSubject.getPreviousSibling(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Node getNextSibling()		{ return realSubject.getNextSibling(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Document getOwnerDocument()	{ return realSubject.getOwnerDocument(); }
	public edu.jhu.apl.patterns_class.dom.replacement.NamedNodeMap getAttributes()	{ return realSubject.getAttributes(); }
	public boolean hasAttributes()							{ return realSubject.hasAttributes(); }
	public String getLocalName()							{ return realSubject.getLocalName(); }

	public void normalize() {}
	public boolean isSupported(String feature, String version)					{ return false; }
	public String getNamespaceURI()									{ return null; }
	public String getPrefix()									{ return null; }
	public void setPrefix(String prefix) throws org.w3c.dom.DOMException				{}
	public Object getUserData(String key)								{ return null; }
	public Object setUserData(String key, Object data, org.w3c.dom.UserDataHandler handler)		{ return null; }
	public Object getFeature(String feature, String version)					{ return null; }
	public boolean isEqualNode(edu.jhu.apl.patterns_class.dom.replacement.Node arg)			{ return false; }
	public String lookupNamespaceURI(String prefix)							{ return null; }
	public boolean isDefaultNamespace(String namespaceURI)						{ return false; }
	public String lookupPrefix(String namespaceURI)							{ return null; }
	public boolean isSameNode(edu.jhu.apl.patterns_class.dom.replacement.Node other)		{ return false; }
	public void setTextContent(String textContent)							{}
	public String getTextContent()									{ return null; }
	public short compareDocumentPosition(edu.jhu.apl.patterns_class.dom.replacement.Node other)	{ return (short )0; }
	public String getBaseURI()									{ return null; }
}
