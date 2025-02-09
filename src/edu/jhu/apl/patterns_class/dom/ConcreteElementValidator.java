package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Attr;
import edu.jhu.apl.patterns_class.dom.replacement.Element;

public class ConcreteElementValidator extends ElementValidation{
    public ConcreteElementValidator(Element e, String tagName, edu.jhu.apl.patterns_class.dom.replacement.Document document) {
        super(e, tagName, document);
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Node appendChild(edu.jhu.apl.patterns_class.dom.replacement.Node n) {
        if (n instanceof Element || n instanceof Attr || n instanceof Text) {
            return this.element.appendChild(n);
        }
        return null;
    }
}
