package edu.jhu.apl.patterns_class.dom;

public abstract class DocumentValidation extends edu.jhu.apl.patterns_class.dom.Document {

    protected edu.jhu.apl.patterns_class.dom.replacement.Document document;

    public DocumentValidation(edu.jhu.apl.patterns_class.dom.replacement.Document d) {
        this.document = d;
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Node appendChild(edu.jhu.apl.patterns_class.dom.replacement.Node n) {
        return document.appendChild(n);
    }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Element createElement(String tagName) throws org.w3c.dom.DOMException
    {return document.createElement(tagName);}

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Text createTextNode(String data)
    { return document.createTextNode(data); }

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Attr createAttribute(String name) throws org.w3c.dom.DOMException
    { return document.createAttribute(name); }
}
