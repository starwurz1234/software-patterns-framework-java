package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Attr;

public class ConcreteAttrValidator extends AttrValidation{
    public ConcreteAttrValidator(Attr attr, String tagName, Document document) {
        super(attr, tagName, document);
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Node appendChild(edu.jhu.apl.patterns_class.dom.replacement.Node n) {
        return null;
    }
}
