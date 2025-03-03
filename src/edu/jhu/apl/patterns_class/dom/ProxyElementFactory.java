package edu.jhu.apl.patterns_class.dom;

public class ProxyElementFactory extends Document{

    @Override
    public edu.jhu.apl.patterns_class.dom.replacement.Element createElement(String tagName) throws org.w3c.dom.DOMException
    {return new ProxyElement(tagName,this);}
}
