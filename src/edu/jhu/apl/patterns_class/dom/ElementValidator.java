package edu.jhu.apl.patterns_class.dom;

public class ElementValidator extends Node implements edu.jhu.apl.patterns_class.dom.ElementDecorator
{
	private edu.jhu.apl.patterns_class.dom.replacement.Element	parent		= null;
	private edu.jhu.apl.patterns_class.ValidChildren		schemaElement	= null;

	public ElementValidator(edu.jhu.apl.patterns_class.dom.replacement.Element parent,
	  edu.jhu.apl.patterns_class.XMLValidator xmlValidator)
	{
		super(parent.getTagName(), org.w3c.dom.Node.ELEMENT_NODE);
		this.parent	= parent;
		schemaElement	= xmlValidator.findSchemaElement(parent.getTagName());
	}

	private ElementValidator(edu.jhu.apl.patterns_class.dom.replacement.Element parent,
	  edu.jhu.apl.patterns_class.ValidChildren schemaElement)
	{
		super(parent.getTagName(), org.w3c.dom.Node.ELEMENT_NODE);
		this.parent		= parent;
		this.schemaElement	= schemaElement;
	}

	//
	// Prototype Clone
	//
	public edu.jhu.apl.patterns_class.dom.replacement.Node cloneNode(boolean deep)
	{
		return
		  new ElementValidator((edu.jhu.apl.patterns_class.dom.replacement.Element )parent.cloneNode(deep), schemaElement);
	}

	//
	// Chain of Responsibility
	//
	public void HandleRequest(String event)
	{
		parent.HandleRequest(event);
	}

	public void Accept(edu.jhu.apl.patterns_class.Visitor visitor) throws java.io.IOException
	{
		parent.Accept(visitor);
	}

	//
	// Implemented Element members.
	//
	public String getAttribute(String name)
	{
		return parent.getAttribute(name);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr getAttributeNode(String name)
	{
		return parent.getAttributeNode(name);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.NodeList getElementsByTagName(String tagName)
	{
		return parent.getElementsByTagName(tagName);
	}
	public String getTagName()
	{
		return parent.getTagName();
	}
	public boolean hasAttribute(String name)
	{
		return parent.hasAttribute(name);
	}
	public void removeAttribute(String name)
	{
		parent.removeAttribute(name);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr
	  removeAttributeNode(edu.jhu.apl.patterns_class.dom.replacement.Attr oldAttr)
	{
		return parent.removeAttributeNode(oldAttr);
	}

	//
	// Decorated Methods
	//
	public void setAttribute(String name, String value)
	{
		if (schemaElement == null || schemaElement.childIsValid(name, true))
			parent.setAttribute(name, value);
		else
			throw new org.w3c.dom.DOMException(org.w3c.dom.DOMException.VALIDATION_ERR,
			  "Invalid attribute " + name + ".");
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr
	  setAttributeNode(edu.jhu.apl.patterns_class.dom.replacement.Attr newAttr)
	{
		if (schemaElement == null || schemaElement.childIsValid(newAttr.getName(), true))
			return parent.setAttributeNode(newAttr);
		else
			throw new org.w3c.dom.DOMException(org.w3c.dom.DOMException.VALIDATION_ERR,
			  "Invalid attribute " + newAttr.getName() + ".");
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Node
	  insertBefore(edu.jhu.apl.patterns_class.dom.replacement.Node newChild,
	  edu.jhu.apl.patterns_class.dom.replacement.Node refChild) throws org.w3c.dom.DOMException
	{
		if (schemaElement == null || newChild instanceof edu.jhu.apl.patterns_class.dom.replacement.Text ||
		  schemaElement.childIsValid(newChild.getNodeName(), false))
			return parent.insertBefore(newChild, refChild);
		else
			throw new org.w3c.dom.DOMException(org.w3c.dom.DOMException.VALIDATION_ERR,
			  "Invalid child node " + newChild.getNodeName() + ".");
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Node
	  replaceChild(edu.jhu.apl.patterns_class.dom.replacement.Node newChild,
	  edu.jhu.apl.patterns_class.dom.replacement.Node oldChild) throws org.w3c.dom.DOMException
	{
		if (schemaElement == null || newChild instanceof edu.jhu.apl.patterns_class.dom.replacement.Text ||
		  schemaElement.childIsValid(newChild.getNodeName(), false))
			return parent.replaceChild(newChild, oldChild);
		else
			throw new org.w3c.dom.DOMException(org.w3c.dom.DOMException.VALIDATION_ERR,
			  "Invalid child node " + newChild.getNodeName() + ".");
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Node appendChild(edu.jhu.apl.patterns_class.dom.replacement.Node newChild)
	  throws org.w3c.dom.DOMException
	{
		if (schemaElement == null || newChild instanceof edu.jhu.apl.patterns_class.dom.replacement.Text ||
		  schemaElement.childIsValid(newChild.getNodeName(), false))
			return parent.appendChild(newChild);
		else
			throw new org.w3c.dom.DOMException(org.w3c.dom.DOMException.VALIDATION_ERR,
			  "Invalid child node " + newChild.getNodeName() + ".");
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
	public String getNodeName()							{ return parent.getNodeName(); }
	public String getNodeValue() throws org.w3c.dom.DOMException			{ return parent.getNodeValue(); }
	public void setNodeValue(String nodeValue) throws org.w3c.dom.DOMException	{ parent.setNodeValue(nodeValue); }
	public short getNodeType()							{ return parent.getNodeType(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Node getParentNode()		{ return parent.getParentNode(); }
	public edu.jhu.apl.patterns_class.dom.replacement.NodeList getChildNodes()	{ return parent.getChildNodes(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Node getFirstChild()		{ return parent.getFirstChild(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Node getLastChild()		{ return parent.getLastChild(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Node getPreviousSibling()	{ return parent.getPreviousSibling(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Node getNextSibling()		{ return parent.getNextSibling(); }
	public edu.jhu.apl.patterns_class.dom.replacement.Document getOwnerDocument()	{ return parent.getOwnerDocument(); }
	public edu.jhu.apl.patterns_class.dom.replacement.NamedNodeMap getAttributes()	{ return parent.getAttributes(); }
	public boolean hasAttributes()							{ return parent.hasAttributes(); }
	public boolean hasChildNodes()							{ return parent.hasChildNodes(); }
	public String getLocalName()							{ return parent.getLocalName(); }

	public static void main(String args[])
	{
		if (args.length < 1)
		{
			System.out.println("No output filenames provided.");
			System.exit(0);
		}

		//
		// Create tree of this document:
		// <? xml version="1.0" encoding="UTF-8"?>
		// <document>
		//   <element attribute="attribute value"/>
		//   <element/>
		//   <element attribute="attribute value" attribute2="attribute2 value">
		//     Element Value
		//   </element>
		//   <element>
		//   </element>
		// </document>
		//
		// Schema for this document:
		// document contains:  element
		// element contains:  element
		// element contains attributes:  attribute, attribute2
		//
		edu.jhu.apl.patterns_class.XMLValidator	xmlValidator	= new edu.jhu.apl.patterns_class.XMLValidator();
		edu.jhu.apl.patterns_class.ValidChildren	schemaElement	= xmlValidator.addSchemaElement(null);
		schemaElement.addValidChild("document", false);
		schemaElement	= xmlValidator.addSchemaElement("document");
		schemaElement.addValidChild("element", false);
		schemaElement	= xmlValidator.addSchemaElement("element");
		schemaElement.addValidChild("element", false);
		schemaElement.addValidChild("attribute", true);
		schemaElement.addValidChild("attribute2", true);
		schemaElement.setCanHaveText(true);

		edu.jhu.apl.patterns_class.dom.replacement.Document	document	=
		  new edu.jhu.apl.patterns_class.dom.DocumentValidator(new edu.jhu.apl.patterns_class.dom.Document(), xmlValidator);
		edu.jhu.apl.patterns_class.dom.replacement.Element	root		= null;
		edu.jhu.apl.patterns_class.dom.replacement.Element	child		= null;
		edu.jhu.apl.patterns_class.dom.replacement.Attr		attr		= null;

		root	= new edu.jhu.apl.patterns_class.dom.ElementValidator(document.createElement("document"), xmlValidator);
		document.appendChild(root);
		child	= new edu.jhu.apl.patterns_class.dom.ElementValidator(document.createElement("element"), xmlValidator);
		attr	= document.createAttribute("attribute");
		attr.setValue("attribute value");
		child.setAttributeNode(attr);
		root.appendChild(child);
		child	= new edu.jhu.apl.patterns_class.dom.ElementValidator(document.createElement("element"), xmlValidator);
		root.appendChild(child);
		child	= new edu.jhu.apl.patterns_class.dom.ElementValidator(document.createElement("element"), xmlValidator);
		child.setAttribute("attribute", "attribute value");
		child.setAttribute("attribute2", "attribute2 value");
		edu.jhu.apl.patterns_class.dom.replacement.Text text = document.createTextNode("Element Value");
		child.appendChild(text);
		root.appendChild(child);
		child	= new edu.jhu.apl.patterns_class.dom.ElementValidator(document.createElement("element"), xmlValidator);
		root.appendChild(child);

		//
		// Serialize
		//
		try
		{
			edu.jhu.apl.patterns_class.XMLSerializer	xmlSerializer	=
			  new edu.jhu.apl.patterns_class.XMLSerializer(new java.io.BufferedWriter(new java.io.OutputStreamWriter(
			  new java.io.FileOutputStream(new java.io.File(args[0])))));
			xmlSerializer.serializePretty();
			document.getDocumentElement().cloneNode(true).Accept(xmlSerializer);
			xmlSerializer.close();
		}
		catch (java.io.IOException e)
		{
			System.out.println("Error writing file.");
			e.printStackTrace();
		}
	}
}
