package edu.jhu.apl.patterns_class.dom;

public class ConcreteDocumentValidator extends DocumentValidation{
    public ConcreteDocumentValidator(edu.jhu.apl.patterns_class.dom.replacement.Document d) {
        super(d);
    }
    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Node appendChild(edu.jhu.apl.patterns_class.dom.replacement.Node n) {
        if (n instanceof edu.jhu.apl.patterns_class.dom.replacement.Element) {
            return super.appendChild(n);
        }
        return null;
    }
}
