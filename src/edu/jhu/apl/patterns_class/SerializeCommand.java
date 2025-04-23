package edu.jhu.apl.patterns_class;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import edu.jhu.apl.patterns_class.dom.replacement.Document;

public class SerializeCommand implements Command {

    XMLSerializer serializer;

    public SerializeCommand(XMLSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public Document execute(Document document) {
        if (document == null) {
            System.out.println("No file has been loaded!");
            return document;
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter output file name: ");
        String filename = input.next();
        System.out.println("Minimal or pretty serialization?");
        System.out.println("1. Minimal");
        System.out.println("2. Pretty");

        int selection = input.nextInt();
        
        try {
            serializer = new XMLSerializer(new OutputStreamWriter(new FileOutputStream(filename)));
            if (selection == 1) {
                serializer.serializeMinimal(document);
            } else if (selection == 2) {
                serializer.serializePretty(document);
            } else {
                System.out.println("Invalid selection!");
            }
            serializer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 

        return document;
    }

}
