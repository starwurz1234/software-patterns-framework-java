package edu.jhu.apl.patterns_class.dom;

public class AttrValidation extends Attr{

    edu.jhu.apl.patterns_class.dom.replacement.Attr attr;

    public AttrValidation(edu.jhu.apl.patterns_class.dom.replacement.Attr attr, String tagName, edu.jhu.apl.patterns_class.dom.replacement.Document document) {
        super(tagName, (Document)document);
        this.attr = attr;
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Node appendChild(edu.jhu.apl.patterns_class.dom.replacement.Node n) {
        return attr.appendChild(n);
    }
}
