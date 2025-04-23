package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.dom.replacement.Document;

public interface Command {
    public Document execute(Document document);
}
