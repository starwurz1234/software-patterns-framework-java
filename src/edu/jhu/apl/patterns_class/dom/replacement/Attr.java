package edu.jhu.apl.patterns_class.dom.replacement;

public interface Attr extends Node
{
	public void Accept(edu.jhu.apl.patterns_class.Visitor visitor) throws java.io.IOException;

	public Node cloneNode(boolean deep);	// Prototype Clone

	//
	// Implemented Attr members.
	//
	public String getName();
	public String getValue();
	public void setValue(String value);
	public Element getOwnerElement();

	//
	// Unimplemented Attr members.
	//
	public boolean getSpecified();
	public boolean isId();
	public org.w3c.dom.TypeInfo getSchemaTypeInfo();
}
