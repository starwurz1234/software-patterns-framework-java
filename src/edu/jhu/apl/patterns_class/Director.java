package edu.jhu.apl.patterns_class;

import edu.jhu.apl.patterns_class.XMLTokenizer.XMLToken;

public class Director
{
	private static final int	BEFORE_PROLOG		= 1;
	private static final int	AFTER_PROLOG		= 2;
	private static final int	PARSING_ELEMENT		= 3;
	private static final int	IN_NONNULL_ELEMENT	= 4;
	private static final int	END			= 5;

	public Director(String filename, Builder builder)
	  throws java.io.FileNotFoundException, org.w3c.dom.DOMException, java.io.IOException
	{
		edu.jhu.apl.patterns_class.XMLTokenizer	tokenizer		= new XMLTokenizer(filename);
		int					documentLocation	= BEFORE_PROLOG;
		int					lastToken		= XMLToken.NULL;
		int					currentToken		= XMLToken.NULL;
		XMLToken				token			= null;

		do
		{
			token		= tokenizer.getNextToken();
			currentToken	= token.getTokenType();
			builder.setState(null);

			switch(documentLocation)
			{
			case BEFORE_PROLOG:
				switch(lastToken)
				{
				case XMLToken.NULL:
					switch(currentToken)
					{
					case XMLToken.PROLOG_START:
						builder.setState(new PrologStartState());
						documentLocation	= AFTER_PROLOG;
						break;
					default:
					}
				default:
					// Shouldn't be able to get here.
				}
				break;
			case AFTER_PROLOG:
				switch(lastToken)
				{
				case XMLToken.PROLOG_START:
					switch(currentToken)
					{
					case XMLToken.PROLOG_IDENTIFIER:
						builder.setState(new IdentifyPrologState(token.getToken()));
						break;
					default:
					}
					break;
				case XMLToken.PROLOG_IDENTIFIER:
					switch(currentToken)
					{
					case XMLToken.ATTRIBUTE:
						builder.setState(new StartAttributeState(token.getToken()));
						break;
					case XMLToken.PROLOG_END:
						builder.setState(new PrologEndState());
						documentLocation	= PARSING_ELEMENT;
						break;
					default:
					}
					break;
				case XMLToken.ATTRIBUTE:
					switch(currentToken)
					{
					case XMLToken.ATTRIBUTE_VALUE:
						builder.setState(new AttributeValueState(token.getToken()));
						break;
					default:
					}
					break;
				case XMLToken.ATTRIBUTE_VALUE:
					switch(currentToken)
					{
					case XMLToken.ATTRIBUTE:
						builder.setState(new StartAttributeState(token.getToken()));
						break;
					case XMLToken.PROLOG_END:
						builder.setState(new PrologEndState());
						documentLocation	= PARSING_ELEMENT;
						break;
					default:
					}
					break;
				default:
				}
			case PARSING_ELEMENT:
				switch(lastToken)
				{
				case XMLToken.TAG_START:
					switch(currentToken)
					{
					case XMLToken.ELEMENT:
						builder.setState(new StartElementState(token.getToken()));
						break;
					default:
					}
					break;
				case XMLToken.ELEMENT:
					switch(currentToken)
					{
					case XMLToken.ATTRIBUTE:
						builder.setState(new StartAttributeState(token.getToken()));
						break;
					case XMLToken.TAG_END:
						documentLocation	= IN_NONNULL_ELEMENT;
						builder.setState(new ElementTagEndState());
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
						builder.setState(new AttributeValueState(token.getToken()));
						break;
					default:
					}
					break;
				case XMLToken.ATTRIBUTE_VALUE:
					switch(currentToken)
					{
					case XMLToken.ATTRIBUTE:
						builder.setState(new StartAttributeState(token.getToken()));
						break;
					case XMLToken.TAG_END:
						documentLocation	= IN_NONNULL_ELEMENT;
						builder.setState(new ElementTagEndState());
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
						documentLocation	= IN_NONNULL_ELEMENT;
						break;
					default:
					}
					break;
				default:
				}
				break;
			case IN_NONNULL_ELEMENT:
				switch(lastToken)
				{
				case XMLToken.ELEMENT:
					switch(currentToken)
					{
					case XMLToken.TAG_END:
						if (!builder.popElement())
							documentLocation	= END;
						break;
					default:
					}
					break;
				case XMLToken.TAG_END:
					switch(currentToken)
					{
					case XMLToken.TAG_START:
						documentLocation	= PARSING_ELEMENT;
						// Actually create element when we read tag name.
						break;
					case XMLToken.VALUE:
						builder.setState(new AddValueState(token.getToken()));
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
				break;
			case END:
				switch(currentToken)
				{
				case XMLToken.NULL:
					break;
				default:
				}
				break;
			default:
				// Shouldn't be able to get here.
			}

			builder.executeState();

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

		try
		{
			edu.jhu.apl.patterns_class.Director		director =
			  new edu.jhu.apl.patterns_class.Director(args[0], builder);
			XMLSerializer	xmlSerializer	=
			  new XMLSerializer(new java.io.BufferedWriter(new java.io.OutputStreamWriter(
			  new java.io.FileOutputStream(new java.io.File(args[1])))));
			xmlSerializer.serializePretty(builder.getDocument());
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
