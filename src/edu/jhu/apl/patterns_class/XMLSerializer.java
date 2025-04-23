package edu.jhu.apl.patterns_class;

//
// XMLSerializer is Serialization Strategy Context
// Node is Serialization Strategy and output stream Strategy Context
// Document, Element, Attr, Text are Serialization Concrete Strategies
// java.io.Writer is output stream Strategy
// java.io.BufferedWriter is output stream Concrete Strategy
//
public class XMLSerializer
{
	java.io.Writer	writer	= null;

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
	//
	// Strategized serialization
	//
	public void serializePretty(edu.jhu.apl.patterns_class.dom.replacement.Node node) throws java.io.IOException
	{
		node.serialize(writer, new PrettyWhitespaceStrategy());
	}

	public void serializeMinimal(edu.jhu.apl.patterns_class.dom.replacement.Node node) throws java.io.IOException
	{
		node.serialize(writer, new MinimalWhitespaceStrategy());
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
			xmlSerializer.serializePretty(document);
			xmlSerializer.close();
			xmlSerializer	=
			  new XMLSerializer(new java.io.BufferedWriter(new java.io.OutputStreamWriter(
			  new java.io.FileOutputStream(new java.io.File(args[1])))));
			xmlSerializer.serializeMinimal(document);
			xmlSerializer.close();
		}
		catch (java.io.IOException e)
		{
			System.out.println("Error writing file.");
			e.printStackTrace();
		}
	}
}
