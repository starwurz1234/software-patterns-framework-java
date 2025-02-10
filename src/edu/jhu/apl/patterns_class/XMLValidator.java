package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.dom.*;

import edu.jhu.apl.patterns_class.dom.replacement.Document;

public class XMLValidator
{
	//
	// Optional for schema implementation:
	//
	// public static boolean canValue(edu.jhu.apl.patterns_class.dom.replacement.Attribute attribute, String value)
	// {
	// }

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

		edu.jhu.apl.patterns_class.dom.replacement.Document	document	=
		  new DocumentValidator (new edu.jhu.apl.patterns_class.dom.Document());
		edu.jhu.apl.patterns_class.dom.replacement.Element	root		= null;
		edu.jhu.apl.patterns_class.dom.replacement.Element	child		= null;
		edu.jhu.apl.patterns_class.dom.replacement.Attr		attr		= null;

		root	= new ElementValidator(document.createElement("document"));

		if (document.appendChild(root) == null) {
			System.out.println("Attempted invalid schema operation.");
			System.exit(0);
		}

		child	= new ElementValidator(document.createElement("element"));

		attr	= new AttrValidator(document.createAttribute("attribute"));
		attr.setValue("attribute value");
		child.setAttributeNode(attr);

		if (root.appendChild(child) == null) {
			System.out.println("Attempted invalid schema operation.");
			System.exit(0);
		}

		child	= new ElementValidator(document.createElement("element"));

		if (root.appendChild(child) == null) {
			System.out.println("Attempted invalid schema operation.");
			System.exit(0);
		}

		child	= new ElementValidator(document.createElement("element"));
		child.setAttribute("attribute", "attribute value");
		child.setAttribute("attribute2", "attribute2 value");

		edu.jhu.apl.patterns_class.dom.replacement.Text text = new TextValidator(document.createTextNode("Element Value"));

		if(child.appendChild(text) == null) {
			System.out.println("Attempted invalid schema operation.");
			System.exit(0);
		}

		if (root.appendChild(child) == null) {
			System.out.println("Attempted invalid schema operation.");
			System.exit(0);
		}

		child	= new ElementValidator(document.createElement("element"));

		if (root.appendChild(child) == null) {
			System.out.println("Attempted invalid schema operation.");
			System.exit(0);
		}

		//
		// Serialize
		//
		try
		{
			XMLSerializer	xmlSerializer	= new XMLSerializer(args[0]);
			xmlSerializer.serialize(new WhitespacePrettyStrategy(), document);
			xmlSerializer.close();
		}
		catch (java.io.IOException e)
		{
			System.out.println("Error writing file.");
			e.printStackTrace();
		}
	}
}
