package edu.jhu.apl.patterns_class.dom.interfaces;

public abstract class ValidationDecorator {
    private edu.jhu.apl.patterns_class.dom.replacement.Node node;

    public ValidationDecorator(edu.jhu.apl.patterns_class.dom.replacement.Node n) {
        this.node = n;
    }
}
