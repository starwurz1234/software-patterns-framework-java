package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.XMLTokenizer.XMLToken;

public class Director
{
	interface State
	{
		public State processToken(XMLToken token, int lastToken, int currentToken, Builder builder);
	}

	class BeforeProlog implements State
	{
		public State processToken(XMLToken token, int lastToken, int currentToken, Builder builder)
		{
			State documentLocation	= this;

			switch(lastToken)
			{
			case XMLToken.NULL:
				switch(currentToken)
				{
				case XMLToken.PROLOG_START:
					builder.createProlog();
					documentLocation	= new AfterProlog();
					break;
				default:
				}
			default:
				// Shouldn't be able to get here.
			}

			return documentLocation;
		}
	}

	class AfterProlog implements State
	{
		public State processToken(XMLToken token, int lastToken, int currentToken, Builder builder)
		{
			State documentLocation	= this;

			switch(lastToken)
			{
			case XMLToken.PROLOG_START:
				switch(currentToken)
				{
				case XMLToken.PROLOG_IDENTIFIER:
					builder.identifyProlog(token.getToken());
					break;
				default:
				}
				break;
			case XMLToken.PROLOG_IDENTIFIER:
				switch(currentToken)
				{
				case XMLToken.ATTRIBUTE:
					builder.createAttribute(token.getToken());
					break;
				case XMLToken.PROLOG_END:
					builder.endProlog();
					documentLocation	= new ParsingElement();
					break;
				default:
				}
				break;
			case XMLToken.ATTRIBUTE:
				switch(currentToken)
				{
				case XMLToken.ATTRIBUTE_VALUE:
					builder.valueAttribute(token.getToken());
					break;
				default:
				}
				break;
			case XMLToken.ATTRIBUTE_VALUE:
				switch(currentToken)
				{
				case XMLToken.ATTRIBUTE:
					builder.createAttribute(token.getToken());
					break;
				case XMLToken.PROLOG_END:
					builder.endProlog();
					documentLocation	= new ParsingElement();
					break;
				default:
				}
				break;
			default:
			}

			return documentLocation;
		}
	}

	class ParsingElement implements State
	{
		public State processToken(XMLToken token, int lastToken, int currentToken, Builder builder)
		{
			State documentLocation	= this;

			switch(lastToken)
			{
			case XMLToken.TAG_START:
				switch(currentToken)
				{
				case XMLToken.ELEMENT:
					builder.createElement(token.getToken());
					break;
				default:
				}
				break;
			case XMLToken.ELEMENT:
				switch(currentToken)
				{
				case XMLToken.ATTRIBUTE:
					builder.createAttribute(token.getToken());
					break;
				case XMLToken.TAG_END:
					documentLocation	= new InNonnullElement();
					builder.pushElement();
					break;
				case XMLToken.NULL_TAG_END:
					break;
				default:
				}
				break;
			case XMLToken.ATTRIBUTE:
				switch(currentToken)
				{
				case XMLToken.ATTRIBUTE_VALUE:
					builder.valueAttribute(token.getToken());
					break;
				default:
				}
				break;
			case XMLToken.ATTRIBUTE_VALUE:
				switch(currentToken)
				{
				case XMLToken.ATTRIBUTE:
					builder.createAttribute(token.getToken());
					break;
				case XMLToken.TAG_END:
					documentLocation	= new InNonnullElement();
					builder.pushElement();
					break;
				case XMLToken.NULL_TAG_END:
					break;
				default:
				}
				break;
			case XMLToken.PROLOG_END:
				switch(currentToken)
				{
				case XMLToken.TAG_START:
					// Actually create element when we read tag name.
					break;
				default:
				}
				break;
			case XMLToken.NULL_TAG_END:
				switch(currentToken)
				{
				case XMLToken.TAG_START:
					// Actually create element when we read tag name.
					break;
				case XMLToken.TAG_CLOSE_START:
					documentLocation	= new InNonnullElement();
					break;
				default:
				}
				break;
			default:
			}

			return documentLocation;
		}
	}

	class InNonnullElement implements State
	{
		public State processToken(XMLToken token, int lastToken, int currentToken, Builder builder)
		{
			State documentLocation	= this;

			switch(lastToken)
			{
			case XMLToken.ELEMENT:
				switch(currentToken)
				{
				case XMLToken.TAG_END:
					if (!builder.popElement())
						documentLocation	= new End();
					break;
				default:
				}
				break;
			case XMLToken.TAG_END:
				switch(currentToken)
				{
				case XMLToken.TAG_START:
					documentLocation	= new ParsingElement();
					// Actually create element when we read tag name.
					break;
				case XMLToken.VALUE:
					builder.addValue(token.getToken());
					break;
				case XMLToken.TAG_CLOSE_START:
					break;
				default:
				}
				break;
			case XMLToken.VALUE:
				switch(currentToken)
				{
				case XMLToken.TAG_CLOSE_START:
					break;
				default:
				}
				break;
			case XMLToken.TAG_CLOSE_START:
				switch(currentToken)
				{
				case XMLToken.ELEMENT:
					builder.confirmElement(token.getToken());
					break;
				default:
				}
				break;
			default:
			}

			return documentLocation;
		}
	}

	class End implements State
	{
		public State processToken(XMLToken token, int lastToken, int currentToken, Builder builder)
		{
			State documentLocation	= this;

			switch(currentToken)
			{
			case XMLToken.NULL:
				break;
			default:
			}

			return documentLocation;
		}
	}

	public Director(String filename, Builder builder)
	  throws java.io.FileNotFoundException, org.w3c.dom.DOMException, java.io.IOException
	{
		edu.jhu.apl.patterns_class.XMLTokenizer	tokenizer		= new XMLTokenizer(filename);
		State					documentLocation	= new BeforeProlog();
		int					lastToken		= XMLToken.NULL;
		int					currentToken		= XMLToken.NULL;
		XMLToken				token			= null;

		do
		{
			token		= tokenizer.getNextToken();
			currentToken	= token.getTokenType();

			documentLocation= documentLocation.processToken(token, lastToken, currentToken, builder);

			lastToken	= currentToken;
		} while (currentToken != XMLToken.NULL);
	}

	public static void main(String[] args)
	{
		if (args.length < 2)
		{
			System.out.println("No output filenames provided.");
			System.exit(0);
		}

		edu.jhu.apl.patterns_class.dom.replacement.Document	document = new edu.jhu.apl.patterns_class.dom.Document();
		edu.jhu.apl.patterns_class.Builder			builder	 = new edu.jhu.apl.patterns_class.Builder(document);
	
		//
		// Schema for this document:
		// document contains:  element
		// element contains:  element
		// element contains attributes:  attribute, attribute2
		//
		XMLValidator	xmlValidator	= new XMLValidator();
		ValidChildren	schemaElement	= xmlValidator.addSchemaElement(null);
		schemaElement.addValidChild("document", false);
		schemaElement	= xmlValidator.addSchemaElement("document");
		schemaElement.addValidChild("element", false);
		schemaElement	= xmlValidator.addSchemaElement("element");
		schemaElement.addValidChild("element", false);
		schemaElement.addValidChild("attribute", true);
		schemaElement.addValidChild("attribute2", true);
		schemaElement.setCanHaveText(true);

		try
		{
			edu.jhu.apl.patterns_class.Director		director =
			  new edu.jhu.apl.patterns_class.Director(args[0], builder);
			XMLSerializer	xmlSerializer	=
			  new XMLSerializer(new java.io.BufferedWriter(new java.io.OutputStreamWriter(
			  new java.io.FileOutputStream(new java.io.File(args[1])))));
			xmlSerializer.serializePretty();
			document.Accept(xmlSerializer);
			xmlSerializer.close();
		}
		catch (java.io.FileNotFoundException e)
		{
			System.out.println("Exception:  " + e);
			e.printStackTrace();
		}
		catch (java.io.IOException e)
		{
			System.out.println("Exception:  " + e);
			e.printStackTrace();
		}
		catch (org.w3c.dom.DOMException e)
		{
			System.out.println("Exception:  " + e);
			e.printStackTrace();
		}
	}
}
