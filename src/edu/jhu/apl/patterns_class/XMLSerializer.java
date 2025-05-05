package edu.jhu.apl.patterns_class;

//
// XMLSerializer is Serialization Strategy Context
// Node is Serialization Strategy and output stream Strategy Context
// Document, Element, Attr, Text are Serialization Concrete Strategies
// java.io.Writer is output stream Strategy
// java.io.BufferedWriter is output stream Concrete Strategy
//
public class XMLSerializer implements Visitor
{
	java.io.Writer		writer		= null;
	WhitespaceStrategy	whitespace	= new PrettyWhitespaceStrategy();

	public XMLSerializer(java.io.Writer writer) throws java.io.FileNotFoundException
	{
		this.writer	= writer;
	}

	public void close() throws java.io.IOException
	{
		writer.close();
	}

	//
	// Whitespace Strategy
	//
	public interface WhitespaceStrategy
	{
		public void prettyIndentation(java.io.Writer wwriter) throws java.io.IOException;
		public void incrementIndentation();
		public void decrementIndentation();
		public void newLine(java.io.Writer wwriter) throws java.io.IOException;
	}

	private class PrettyWhitespaceStrategy implements WhitespaceStrategy
	{
		private int	indentationLevel	= 0;

		public void prettyIndentation(java.io.Writer wwriter) throws java.io.IOException
		{
			for (int i = 0; i < indentationLevel; i++)
				wwriter.write("\t");
		}

		public void incrementIndentation()					{ indentationLevel++; }
		public void decrementIndentation()					{ indentationLevel--; }
		public void newLine(java.io.Writer wwriter) throws java.io.IOException	{ wwriter.write("\n"); }
	}

	private class MinimalWhitespaceStrategy implements WhitespaceStrategy
	{
		public void prettyIndentation(java.io.Writer wwriter) throws java.io.IOException	{}
		public void incrementIndentation()						{}
		public void decrementIndentation()						{}
		public void newLine(java.io.Writer wwriter) throws java.io.IOException	{}
	}

	public void VisitDocument(edu.jhu.apl.patterns_class.dom.replacement.Document document) throws java.io.IOException
	{
		writer.write("<? xml version=\"1.0\" encoding=\"UTF-8\"?>");
		whitespace.newLine(writer);
		document.getDocumentElement().Accept(this);
	}

	public void VisitElement(edu.jhu.apl.patterns_class.dom.replacement.Element element) throws java.io.IOException
	{
		whitespace.prettyIndentation(writer);
		writer.write("<" + element.getTagName());

		int	attrCount	= 0;

		for (java.util.ListIterator i =
		  ((edu.jhu.apl.patterns_class.dom.NodeList )element.getAttributes()).listIterator(0);
		  i.hasNext();)
		{
			edu.jhu.apl.patterns_class.dom.replacement.Node	attr =
			  (edu.jhu.apl.patterns_class.dom.replacement.Node )i.next();

			attr.Accept(this);
			attrCount++;
		}

		if (attrCount > 0)
			writer.write(" ");

		if (!((edu.jhu.apl.patterns_class.dom.NodeList )element.getChildNodes()).listIterator(0).hasNext())
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
			  ((edu.jhu.apl.patterns_class.dom.NodeList )element.getChildNodes()).listIterator(0);
			  i.hasNext();)
			{
				edu.jhu.apl.patterns_class.dom.replacement.Node	child =
				  (edu.jhu.apl.patterns_class.dom.replacement.Node )i.next();

				if (child instanceof edu.jhu.apl.patterns_class.dom.replacement.Element ||
				  child instanceof edu.jhu.apl.patterns_class.dom.replacement.Text)
					child.Accept(this);
			}

			whitespace.decrementIndentation();
			whitespace.prettyIndentation(writer);
			writer.write("</" + element.getTagName() + ">");
			whitespace.newLine(writer);
		}
	}

	public void VisitAttribute(edu.jhu.apl.patterns_class.dom.replacement.Attr attr) throws java.io.IOException
	{
		writer.write(" " + attr.getName() + "=\"" + attr.getValue() + "\"");
	}

	public void VisitText(edu.jhu.apl.patterns_class.dom.replacement.Text text) throws java.io.IOException
	{
		whitespace.prettyIndentation(writer);
		writer.write(text.getData());
		whitespace.newLine(writer);
	}

	//
	// Strategized serialization
	//
	public void serializePretty() throws java.io.IOException
	{
		whitespace	= new PrettyWhitespaceStrategy();
	}

	public void serializeMinimal() throws java.io.IOException
	{
		whitespace	= new MinimalWhitespaceStrategy();
	}

	public static void main(String args[])
	{
		if (args.length < 2)
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
		edu.jhu.apl.patterns_class.dom.replacement.Document	document	=
		  new edu.jhu.apl.patterns_class.dom.Document();
		edu.jhu.apl.patterns_class.dom.replacement.Element	root		= document.createElement("document");
		document.appendChild(root);

		edu.jhu.apl.patterns_class.dom.replacement.Element	child		= document.createElement("element");
		edu.jhu.apl.patterns_class.dom.replacement.Attr		attr		= document.createAttribute("attribute");
		attr.setValue("attribute value");
		child.setAttributeNode(attr);
		root.appendChild(child);

		child	= document.createElement("element");
		root.appendChild(child);

		child	= document.createElement("element");
		child.setAttribute("attribute", "attribute value");
		child.setAttribute("attribute2", "attribute2 value");
		edu.jhu.apl.patterns_class.dom.replacement.Text		text		= document.createTextNode("Element Value");
		child.appendChild(text);
		root.appendChild(child);

		child	= document.createElement("element");
		root.appendChild(child);

		//
		// Serialize
		//
		try
		{
			XMLSerializer	xmlSerializer	=
			  new XMLSerializer(new java.io.BufferedWriter(new java.io.OutputStreamWriter(
			  new java.io.FileOutputStream(new java.io.File(args[0])))));
			xmlSerializer.serializePretty();
			document.Accept(xmlSerializer);
			xmlSerializer.close();
			xmlSerializer	=
			  new XMLSerializer(new java.io.BufferedWriter(new java.io.OutputStreamWriter(
			  new java.io.FileOutputStream(new java.io.File(args[1])))));
			xmlSerializer.serializeMinimal();
			document.Accept(xmlSerializer);
			xmlSerializer.close();
		}
		catch (java.io.IOException e)
		{
			System.out.println("Error writing file.");
			e.printStackTrace();
		}
	}
}
