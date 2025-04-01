package edu.jhu.apl.patterns_class.dom.interfaces;

import edu.jhu.apl.patterns_class.XMLTokenizer;

public interface Builder {
    public void addToken(XMLTokenizer.XMLToken token);
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyObservers();
}
