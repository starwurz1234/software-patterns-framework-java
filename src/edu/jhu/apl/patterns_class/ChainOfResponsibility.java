package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.dom.Event;

public class ChainOfResponsibility {


    public static void main(String[] args) {
        edu.jhu.apl.patterns_class.dom.replacement.Document	document	=
                new edu.jhu.apl.patterns_class.dom.Document();
        edu.jhu.apl.patterns_class.dom.replacement.Element	root		= document.createElement("document");
        document.appendChild(root);

        edu.jhu.apl.patterns_class.dom.replacement.Element	child		= document.createElement("element");
        edu.jhu.apl.patterns_class.dom.replacement.Attr		attr		= document.createAttribute("attribute");
        attr.setValue("attribute value");
        child.setAttributeNode(attr);
        root.appendChild(child);

        child	= document.createElement("element");
        root.appendChild(child);

        child	= document.createElement("element");
        child.setAttribute("attribute", "attribute value");
        child.setAttribute("attribute2", "attribute2 value");
        edu.jhu.apl.patterns_class.dom.replacement.Text		text		= document.createTextNode("Element Value");
        child.appendChild(text);
        root.appendChild(child);

        child	= document.createElement("element");
        root.appendChild(child);

        edu.jhu.apl.patterns_class.dom.EventHandler type1Handler = document.createEventHandler("handler1", "type1");
        root.appendChild(type1Handler);
        edu.jhu.apl.patterns_class.dom.EventHandler type2Handler = document.createEventHandler("handler2", "type2");
        root.appendChild(type2Handler);

        Event type1Event = new Event("type1", "This is a type 1 event");
        Event type2Event = new Event("type2", "This is a type 2 event");

        child.handleEvent(type1Event);
        child.handleEvent(type2Event);

    }


}
