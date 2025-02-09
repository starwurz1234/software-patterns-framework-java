package edu.jhu.apl.patterns_class.dom;



public abstract class ElementValidation extends edu.jhu.apl.patterns_class.dom.Element {

    protected edu.jhu.apl.patterns_class.dom.replacement.Element element;

    public ElementValidation(edu.jhu.apl.patterns_class.dom.replacement.Element e, String tagName, edu.jhu.apl.patterns_class.dom.replacement.Document document) {
        super(tagName, (Document)document);
        this.element = e;
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Node appendChild(edu.jhu.apl.patterns_class.dom.replacement.Node n) {
        return element.appendChild(n);
    }
}
