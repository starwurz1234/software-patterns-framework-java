package edu.jhu.apl.patterns_class;

public class Builder extends Subject
{
	private edu.jhu.apl.patterns_class.dom.replacement.Document				factory		= null;

	private DocumentState documentState;
	private BuilderState state;

	public Builder(edu.jhu.apl.patterns_class.dom.replacement.Document factory)
	{
		this.factory	= factory;
		attach(new StdOutObserver());
	}

	public void executeState() {
		if (this.state == null) return;
		if (this.documentState == null) {
			this.documentState = new DocumentState(this.factory, new java.util.ArrayDeque<edu.jhu.apl.patterns_class.dom.replacement.Element>(), null, null);
		}
		this.documentState = this.state.Handle(this.documentState);
		this.factory = documentState.factory;
	}

	public void setState(BuilderState state) {
		this.state = state;
	}

	public edu.jhu.apl.patterns_class.dom.replacement.Document getDocument()	// aka getResult
	{
		return factory;
	}

	public void confirmElement(String tag) throws org.w3c.dom.DOMException
	{
		// Throw an exception if tag.trim() != currentElement.getTagName()
	}

	public boolean popElement() throws org.w3c.dom.DOMException
	{
		this.documentState.currentElement	= this.documentState.elementStack.pop();
		return this.documentState.elementStack.size() > 0;
	}
}
