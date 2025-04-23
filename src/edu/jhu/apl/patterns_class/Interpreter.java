package edu.jhu.apl.patterns_class;

import java.util.Scanner;

public class Interpreter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Select an operation below by entering the number corresponding to the selection:");
            System.out.println("1. Parse a file");
            System.out.println("2. Serialize a tree");
            System.out.println("3. Modify attribute");
            System.out.println("4. Exit application");

            int selection = input.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Parse file");
                    break;
                case 2:
                    System.out.println("Serialize tree");
                    break;
                case 3:
                    System.out.println("Modify attribute");
                    break;
            }

            if (selection == 4) {
                break;
            }
        }

        input.close();
    }
}
