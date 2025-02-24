package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.XMLTokenizer;
import edu.jhu.apl.patterns_class.dom.interfaces.Builder;

import static edu.jhu.apl.patterns_class.XMLTokenizer.XMLToken.*;

public class DOMBuilder implements Builder {

    edu.jhu.apl.patterns_class.dom.replacement.Document document;
    AbstractNodeFactory attrFactory;
    AbstractNodeFactory elementFactory;
    AbstractNodeFactory textFactory;

    public DOMBuilder() {
        this.document = new Document();
        this.attrFactory = new AttrFactory();
        this.elementFactory = new ElementFactory();
        this.textFactory = new TextFactory();
    }

    public edu.jhu.apl.patterns_class.dom.replacement.Document getDocument() {
        return document;
    }

    @Override
    public void addToken(XMLTokenizer.XMLToken token) {
        System.out.println();

        switch(token.getTokenType()) {
            case NULL:
                break;
            case PROLOG_START:
                break;
            case PROLOG_IDENTIFIER:
                break;
            case ATTRIBUTE_VALUE:
                break;
            case PROLOG_END:
                break;
            case TAG_START:
                break;
            case ELEMENT:
                break;
            case ATTRIBUTE:
                break;
            case NULL_TAG_END:
                break;
            case TAG_CLOSE_START:
                break;
            case VALUE:
                break;
            case TAG_END:
                break;
            default:
                break;
        }
    }
}
