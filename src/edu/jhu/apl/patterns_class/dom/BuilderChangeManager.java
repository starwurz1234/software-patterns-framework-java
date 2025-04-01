package edu.jhu.apl.patterns_class.dom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.jhu.apl.patterns_class.dom.interfaces.ChangeManager;
import edu.jhu.apl.patterns_class.dom.interfaces.Observer;

public class BuilderChangeManager implements ChangeManager {

    Map<DOMBuilder, List<Observer>> mapping = new HashMap<>();

    @Override
    public void register(DOMBuilder builder, Observer observer) {
        if (mapping.containsKey(builder)) {
            mapping.get(builder).add(observer);
        } else {
            mapping.put(builder, Arrays.asList(observer));
        }
    }

    @Override
    public void unregister(DOMBuilder builder, Observer observer) {
        if (mapping.containsKey(builder)) {
            mapping.get(builder).remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Map.Entry<DOMBuilder, List<Observer>> entry : mapping.entrySet()) {
            for (Observer observer : entry.getValue()) {
                observer.Update(entry.getKey());
            }
        }
    }
}
