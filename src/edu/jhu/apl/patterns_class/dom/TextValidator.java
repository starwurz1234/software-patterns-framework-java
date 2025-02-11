package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.dom.replacement.Node;
import edu.jhu.apl.patterns_class.dom.replacement.Text;
import org.w3c.dom.DOMException;

//Concrete Validator decorator for Text objects
public class TextValidator extends Validator<edu.jhu.apl.patterns_class.dom.replacement.Text> implements edu.jhu.apl.patterns_class.dom.replacement.Text{
    public TextValidator(edu.jhu.apl.patterns_class.dom.replacement.Text node) {
        super(node, node.getNodeName(), node.getNodeType());
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        return null;
    }

    @Override
    public String getName() {
        return node.getName();
    }

    @Override
    public String getData() {
        return node.getData();
    }

    @Override
    public String getValue() {
        return node.getValue();
    }

    @Override
    public void setData(String value) {
        node.setData(value);
    }

    @Override
    public void setValue(String value) {
        node.setValue(value);
    }

    @Override
    public int getLength() {
        return node.getLength();
    }

    @Override
    public String substringData(int offset, int count) {
        return node.substringData(offset, count);
    }

    @Override
    public void appendData(String arg) {
        node.appendData(arg);
    }

    @Override
    public void insertData(int offset, String arg) {
        node.insertData(offset, arg);
    }

    @Override
    public void deleteData(int offset, int count) {
        node.deleteData(offset, count);
    }

    @Override
    public void replaceData(int offset, int count, String arg) {
        node.replaceData(offset, count, arg);
    }

    @Override
    public Text splitText(int offset) {
        return node.splitText(offset);
    }

    @Override
    public Text replaceWholeText(String content) {
        return node.replaceWholeText(content);
    }

    @Override
    public String getWholeText() {
        return node.getWholeText();
    }

    @Override
    public boolean isElementContentWhitespace() {
        return node.isElementContentWhitespace();
    }
}
