package edu.jhu.apl.patterns_class.dom;

import edu.jhu.apl.patterns_class.XMLTokenizer;
import edu.jhu.apl.patterns_class.dom.interfaces.Builder;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Director {

    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(String filename) throws IOException {
        XMLTokenizer tokenizer;
        tokenizer	= new XMLTokenizer(filename);

        XMLTokenizer.XMLToken	token		= null;

        do
        {
            token	= tokenizer.getNextToken();

            this.builder.addToken(token);

        } while (token.getTokenType() != XMLTokenizer.XMLToken.NULL);

    }
}
