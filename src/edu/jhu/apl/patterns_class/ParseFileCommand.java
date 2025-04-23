package edu.jhu.apl.patterns_class;

import java.io.IOException;
import java.util.Scanner;

import org.w3c.dom.DOMException;

import edu.jhu.apl.patterns_class.dom.replacement.Document;

public class ParseFileCommand implements Command {

    Builder builder;

    public ParseFileCommand(Builder builder) {
        this.builder = builder;
    }

    @Override
    public Document execute(Document doc) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter filename: ");

        String filename = input.next();
        Document document = new edu.jhu.apl.patterns_class.dom.Document();
        this.builder = new Builder(document);
        try {
            Director director = new Director(filename, builder);
            doc = builder.getDocument();
            return doc;
        } catch (DOMException | IOException e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        } 

        return null;
    }

}
