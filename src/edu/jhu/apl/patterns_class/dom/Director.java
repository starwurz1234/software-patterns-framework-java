package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.XMLTokenizer;
import edu.jhu.apl.patterns_class.dom.interfaces.Builder;

public class Director {

    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(String filename) {
        XMLTokenizer tokenizer;
        try
        {
            tokenizer	= new XMLTokenizer(filename);
        }
        catch (java.io.FileNotFoundException e)
        {
            System.out.println("Unable to read file '" + filename + "'");
            return;
        }

        XMLTokenizer.XMLToken	token		= null;

        do
        {
            try
            {
                token	= tokenizer.getNextToken();
            }
            catch (java.io.IOException e)
            {
                System.out.println("IO Exception parsing file '" + filename + "':  " + e);
                e.printStackTrace();
            }

            this.builder.addToken(token);

        } while (token.getTokenType() != XMLTokenizer.XMLToken.NULL);

    }
}
