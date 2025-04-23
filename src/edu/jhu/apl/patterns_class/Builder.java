package edu.jhu.apl.patterns_class;

public class Builder extends Subject
{
	private edu.jhu.apl.patterns_class.dom.replacement.Document				factory		= null;
	private java.util.ArrayDeque<edu.jhu.apl.patterns_class.dom.replacement.Element>	elementStack	=
	  new java.util.ArrayDeque<edu.jhu.apl.patterns_class.dom.replacement.Element>();
	private edu.jhu.apl.patterns_class.dom.replacement.Element				currentElement	= null;
	private edu.jhu.apl.patterns_class.dom.replacement.Attr					currentAttr	= null;

	public Builder(edu.jhu.apl.patterns_class.dom.replacement.Document factory)
	{
		this.factory	= factory;
		attach(new StdOutObserver());
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Document getDocument()	// aka getResult
	{
		return factory;
	}

	public void addValue(String text) throws org.w3c.dom.DOMException
	{
		String	trimmed	= text.trim();
		elementStack.peek().appendChild(factory.createTextNode(trimmed));
		notify(elementStack.peek(), org.w3c.dom.Node.TEXT_NODE, trimmed);
	}

	public void confirmElement(String tag) throws org.w3c.dom.DOMException
	{
		// Throw an exception if tag.trim() != currentElement.getTagName()
	}

	public void createAttribute(String attribute) throws org.w3c.dom.DOMException
	{
		String	trimmed	= attribute.trim();
		trimmed	= trimmed.substring(0, trimmed.length() - 1);
		currentAttr	= factory.createAttribute(trimmed);
		notify(currentElement, org.w3c.dom.Node.ATTRIBUTE_NODE, trimmed);
	}

	public void createElement(String tag) throws org.w3c.dom.DOMException
	{
		String	trimmed	= tag.trim();
		currentElement	= factory.createElement(trimmed);
		notify(elementStack.peek(), org.w3c.dom.Node.ELEMENT_NODE, trimmed);

		if (elementStack.peek() == null)	// This is the root element.
			factory.appendChild(currentElement);
		else
			elementStack.peek().appendChild(currentElement);
	}

	public void createProlog() throws org.w3c.dom.DOMException
	{
		// null method in this implementation
	}

	public void endProlog() throws org.w3c.dom.DOMException
	{
		// null method in this implementation
	}

	public void identifyProlog(String id) throws org.w3c.dom.DOMException
	{
		// null method in this implementation
	}

	public boolean popElement() throws org.w3c.dom.DOMException
	{
		currentElement	= elementStack.pop();
		return elementStack.size() > 0;
	}

	public void pushElement() throws org.w3c.dom.DOMException
	{
		elementStack.push(currentElement);
		currentElement	= null;
	}

	public void valueAttribute(String value) throws org.w3c.dom.DOMException
	{
		String	trimmed	= value.trim();
		trimmed	= trimmed.substring(1, trimmed.length() - 1);
		currentAttr.setValue(trimmed);
		notify(currentAttr, org.w3c.dom.Node.ATTRIBUTE_NODE, trimmed);

		if (currentElement != null)	// Discard prolog attributes.  This implementation currently doesn't have
						// anything to do with them.
			currentElement.setAttributeNode(currentAttr);
	}
}
