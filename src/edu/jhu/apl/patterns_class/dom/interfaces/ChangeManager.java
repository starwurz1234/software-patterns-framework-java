package edu.jhu.apl.patterns_class.dom.interfaces;

import edu.jhu.apl.patterns_class.dom.DOMBuilder;

public interface ChangeManager {
    public void register(DOMBuilder builder, Observer observer);
    public void unregister(DOMBuilder builder, Observer observer);
    public void notifyObservers();
}
