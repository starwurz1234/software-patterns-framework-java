package edu.jhu.apl.patterns_class;

public class DocumentState {
    public edu.jhu.apl.patterns_class.dom.replacement.Document				factory		= null;
    public java.util.ArrayDeque<edu.jhu.apl.patterns_class.dom.replacement.Element>	elementStack	=
            new java.util.ArrayDeque<edu.jhu.apl.patterns_class.dom.replacement.Element>();
    public edu.jhu.apl.patterns_class.dom.replacement.Element				currentElement	= null;
    public edu.jhu.apl.patterns_class.dom.replacement.Attr					currentAttr	= null;

    public DocumentState(edu.jhu.apl.patterns_class.dom.replacement.Document document,
                         java.util.ArrayDeque<edu.jhu.apl.patterns_class.dom.replacement.Element> elementStack,
                         edu.jhu.apl.patterns_class.dom.replacement.Element element,
                         edu.jhu.apl.patterns_class.dom.replacement.Attr attr) {
        this.factory = document;
        this.elementStack = elementStack;
        this.currentElement = element;
        this.currentAttr = attr;
    }
}
