package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.SerializationVisitor;

import java.io.IOException;

public class Element extends Node implements edu.jhu.apl.patterns_class.dom.replacement.Element
{
	private NamedNodeMap		attributes	= null;

	Element(String tagName, Document document)
	{
		super(tagName, org.w3c.dom.Node.ELEMENT_NODE);
		this.document	= document;
		attributes	= new NamedNodeMap(document);
	}

	//
	// Chain of Responsibility
	//
	public void HandleRequest(String event)
	{
		String	eventTemplate	= getAttribute("message");

		if (eventTemplate != null && eventTemplate.compareTo(event) == 0)
			System.out.println("Handling event " + event + ".");
		else if (getParentNode() != null && getParentNode() instanceof edu.jhu.apl.patterns_class.dom.replacement.Element)
			((edu.jhu.apl.patterns_class.dom.replacement.Element )getParentNode()).HandleRequest(event);
		else
			System.out.println("Reached root of DOM tree without handling event '" + event + "'.");
	}

	@Override
	public void accept(SerializationVisitor visitor) throws IOException {
		visitor.serializeElement(this);
	}

	//
	// Serialization Data Extraction Strategy
	//
	public void serialize(java.io.Writer writer, edu.jhu.apl.patterns_class.XMLSerializer.WhitespaceStrategy whitespace)
	  throws java.io.IOException
	{
		whitespace.prettyIndentation(writer);
		writer.write("<" + getTagName());

		int	attrCount	= 0;

		for (java.util.ListIterator i =
		  ((edu.jhu.apl.patterns_class.dom.NodeList )getAttributes()).listIterator(0);
		  i.hasNext();)
		{
			edu.jhu.apl.patterns_class.dom.replacement.Node	attr =
			  (edu.jhu.apl.patterns_class.dom.replacement.Node )i.next();

			attr.serialize(writer, whitespace);
			attrCount++;
		}

		if (attrCount > 0)
			writer.write(" ");

		if (!((edu.jhu.apl.patterns_class.dom.NodeList )getChildNodes()).listIterator(0).hasNext())
		{
			writer.write("/>");
			whitespace.newLine(writer);
		}
		else
		{
			writer.write(">");
			whitespace.newLine(writer);
			whitespace.incrementIndentation();

			for (java.util.ListIterator i =
			  ((edu.jhu.apl.patterns_class.dom.NodeList )getChildNodes()).listIterator(0);
			  i.hasNext();)
			{
				edu.jhu.apl.patterns_class.dom.replacement.Node	child =
				  (edu.jhu.apl.patterns_class.dom.replacement.Node )i.next();

				if (child instanceof edu.jhu.apl.patterns_class.dom.replacement.Element ||
				  child instanceof edu.jhu.apl.patterns_class.dom.replacement.Text)
					child.serialize(writer, whitespace);
			}

			whitespace.decrementIndentation();
			whitespace.prettyIndentation(writer);
			writer.write("</" + getTagName() + ">");
			whitespace.newLine(writer);
		}
	}

	//
	// Implemented Element members.
	//
	public String getAttribute(String name)
	{
		for (java.util.ListIterator i = attributes.listIterator(0); i.hasNext();)
		{
			Attr	attribute	= (Attr )i.next();

			if (attribute.getName().compareTo(name) == 0)
				return attribute.getValue();
		}

		return null;
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr getAttributeNode(String name)
	{
		for (java.util.ListIterator i = attributes.listIterator(0); i.hasNext();)
		{
			Attr	attribute	= (Attr )i.next();

			if (attribute.getName().compareTo(name) == 0)
				return attribute;
		}

		return null;
	}
	public edu.jhu.apl.patterns_class.dom.replacement.NodeList getElementsByTagName(String tagName)
	{
		// TODO:  Do a preorder traversal of the entire tree.
		NodeList	nodeList	= new NodeList();

		for (java.util.ListIterator i = ((NodeList )getChildNodes()).listIterator(0); i.hasNext();)
		{
			edu.jhu.apl.patterns_class.dom.replacement.Node	element =
			  (edu.jhu.apl.patterns_class.dom.replacement.Node )i.next();

			if (element instanceof Element && ((Element )element).getTagName().compareTo(tagName) == 0)
				nodeList.addLast(element);
		}

		return nodeList;
	}
	public String getTagName()
	{
		return getNodeName();
	}
	public boolean hasAttribute(String name)
	{
		for (java.util.ListIterator i = attributes.listIterator(0); i.hasNext();)
		{
			Attr	attribute	= (Attr )i.next();

			if (attribute.getName().compareTo(name) == 0)
				return true;
		}

		return false;
	}
	public void removeAttribute(String name)
	{
		// TODO:  Check for readonly status.  NO_MODIFICATION_ALLOWED_ERR

		for (java.util.ListIterator i = attributes.listIterator(0); i.hasNext();)
		{
			Attr	attribute	= (Attr )i.next();

			if (attribute.getName().compareTo(name) == 0)
			{
				attributes.remove(attribute);
				return;
			}
		}
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr
	  removeAttributeNode(edu.jhu.apl.patterns_class.dom.replacement.Attr oldAttr)
	{
		// TODO:  Check for readonly status.  NO_MODIFICATION_ALLOWED_ERR

		for (java.util.ListIterator i = attributes.listIterator(0); i.hasNext();)
		{
			Attr	attribute	= (Attr )i.next();

			if (attribute == oldAttr)
			{
				attributes.remove(attribute);
				return attribute;
			}
		}

		throw new org.w3c.dom.DOMException(org.w3c.dom.DOMException.NOT_FOUND_ERR, "Attribute not found.");
	}
	public void setAttribute(String name, String value)
	{
		// TODO:  Check for readonly status.  NO_MODIFICATION_ALLOWED_ERR
		// TODO:  Check for illegal characters in name.  INVALID_CHARACTER_ERR

		for (java.util.ListIterator i = attributes.listIterator(0); i.hasNext();)
		{
			Attr	attribute	= (Attr )i.next();

			if (attribute.getName().compareTo(name) == 0)
			{
				attribute.setValue(value);
				return;
			}
		}

		Attr	attribute;
		attributes.addLast(attribute = new Attr(name, value, (Document )getOwnerDocument()));
		attribute.setParent(this);
	}
	public edu.jhu.apl.patterns_class.dom.replacement.Attr
	  setAttributeNode(edu.jhu.apl.patterns_class.dom.replacement.Attr newAttr)
	{
		if (newAttr.getOwnerDocument() != getOwnerDocument())
			throw new org.w3c.dom.DOMException(org.w3c.dom.DOMException.WRONG_DOCUMENT_ERR,
			  "Attribute not created by this document.");

		if (newAttr.getParentNode() != null)
			throw new org.w3c.dom.DOMException(org.w3c.dom.DOMException.INUSE_ATTRIBUTE_ERR,
			  "Attribute in use by other element.");

		Attr	oldAttribute	= null;

		for (java.util.ListIterator i = attributes.listIterator(0); i.hasNext();)
		{
			Attr	attribute	= (Attr )i.next();

			if (attribute.getName().compareTo(newAttr.getName()) == 0)
			{
				attributes.remove(attribute);
				oldAttribute	= attribute;
				break;
			}
		}

		((Node )newAttr).setParent(this);
		attributes.addLast(newAttr);
		return oldAttribute;
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
	public edu.jhu.apl.patterns_class.dom.replacement.NamedNodeMap getAttributes()	{ return attributes; }
	public boolean hasAttributes()			{ return attributes.getLength() > 0; }

	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("No input filename provided.");
			System.exit(0);
		}

		edu.jhu.apl.patterns_class.dom.replacement.Document	document = new edu.jhu.apl.patterns_class.dom.Document();
		edu.jhu.apl.patterns_class.Builder			builder	 = new edu.jhu.apl.patterns_class.Builder(document);
	
		//
		// Schema for this document:
		// handlers contains:  handler
		// handler contains:  handler
		// handler contains attributes:  message
		//
		edu.jhu.apl.patterns_class.XMLValidator	xmlValidator	= new edu.jhu.apl.patterns_class.XMLValidator();
		edu.jhu.apl.patterns_class.ValidChildren	schemaElement	= xmlValidator.addSchemaElement(null);
		schemaElement.addValidChild("handlers", false);
		schemaElement	= xmlValidator.addSchemaElement("handlers");
		schemaElement.addValidChild("handler", false);
		schemaElement	= xmlValidator.addSchemaElement("handler");
		schemaElement.addValidChild("handler", false);
		schemaElement.addValidChild("message", true);
		schemaElement.setCanHaveText(false);

		try
		{
			edu.jhu.apl.patterns_class.Director		director =
			  new edu.jhu.apl.patterns_class.Director(args[0], builder);
			int	typeCounter	= 1;
			for (java.util.Iterator<edu.jhu.apl.patterns_class.dom.replacement.Node>
			  iterator = document.createIterator(null);
			  iterator.hasNext();)
			{
				edu.jhu.apl.patterns_class.dom.replacement.Node	node	= iterator.next();

				if (node != null && node instanceof edu.jhu.apl.patterns_class.dom.replacement.Element &&
				  !node.hasChildNodes())
				{
					System.out.println("Sending event type" + typeCounter + " to Element node.");
					((edu.jhu.apl.patterns_class.dom.replacement.Element )node).HandleRequest("type" +
					  typeCounter);
					typeCounter++;
				}
			}
		}
		catch (java.io.FileNotFoundException e)
		{
			System.out.println("Exception:  " + e);
			e.printStackTrace();
		}
		catch (java.io.IOException e)
		{
			System.out.println("Exception:  " + e);
			e.printStackTrace();
		}
		catch (org.w3c.dom.DOMException e)
		{
			System.out.println("Exception:  " + e);
			e.printStackTrace();
		}
	}
}
