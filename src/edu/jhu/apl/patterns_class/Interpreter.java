package edu.jhu.apl.patterns_class;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.jhu.apl.patterns_class.dom.replacement.Document;

public class Interpreter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Document document = null;
        

        List<Command> commands = Arrays.asList(
            new ParseFileCommand(new Builder(document)),
            new SerializeCommand(null),
            new ModifyAttributeCommand());

        CommandInvoker invoker = new CommandInvoker(commands);



        while(true) {

            System.out.println("Select an operation below by entering the number corresponding to the selection:");
            System.out.println("1. Parse a file");
            System.out.println("2. Serialize a tree");
            System.out.println("3. Modify attribute");
            System.out.println("4. Exit application");
            String next = input.next();
            int selection = Integer.parseInt(next);

            
            if (selection == 4) {
                break;
            }

            document = invoker.RunCommand(selection - 1, document);

        }
        input.close();
    }
}
