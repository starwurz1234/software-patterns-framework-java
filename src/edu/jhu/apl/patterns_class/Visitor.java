package edu.jhu.apl.patterns_class;

public interface Visitor
{
	public void VisitDocument(edu.jhu.apl.patterns_class.dom.replacement.Document document) throws java.io.IOException;
	public void VisitElement(edu.jhu.apl.patterns_class.dom.replacement.Element element) throws java.io.IOException;
	public void VisitAttribute(edu.jhu.apl.patterns_class.dom.replacement.Attr attr) throws java.io.IOException;
	public void VisitText(edu.jhu.apl.patterns_class.dom.replacement.Text text) throws java.io.IOException;
}
