package edu.jhu.apl.patterns_class;

//
// ...and Client, too.
//
public class Invoker
{
	private boolean							running		= true;
	private edu.jhu.apl.patterns_class.dom.replacement.Document	document	= null;
	private ApplicationFacade facade;

	public Invoker()	{
		this.facade = new ApplicationFacade(this);
	}

	public void	run()
	{
		java.io.BufferedReader	reader	= new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

		do
		{
			prompt();
			try
			{
				invoke(reader.readLine());
			}
			catch(java.io.IOException e)
			{
				running	= false;
			}
		} while(running);
	}

	public void	setDocument(edu.jhu.apl.patterns_class.dom.replacement.Document	document)	{ this.document = document;}
	public edu.jhu.apl.patterns_class.dom.replacement.Document	getDocument()			{ return document; }

	private void prompt()
	{
		System.out.println("\nCommands:");
		System.out.println("\tread [file]");
		System.out.println("\twrite [file]");
		System.out.println("\tprint");
		System.out.print("-->  ");
	}

	private void invoke(String input)
	{
		String[]	parsedInput	= input.split(" ");

		if (parsedInput.length > 0)
		{
			if (parsedInput[0].contains("read")) {
				facade.Read(parsedInput.length > 1 ? parsedInput[1] : null);
			} else if (parsedInput[0].contains("write")) {
				facade.Write(parsedInput.length > 1 ? parsedInput[1] : null);
			} else if (parsedInput[0].contains("print")) {
				facade.Print(parsedInput.length > 1 ? parsedInput[1] : null);
			}

			else
				running	= false;
		}
		else
			running	= false;
	}

	public static void main(String[] args)
	{
		Invoker	invoker	= new Invoker();
		invoker.run();
	}
}

class ParseCommand implements Command
{
	Invoker	state	= null;

	public ParseCommand(Invoker state)	{ this.state	= state; }

	public void	Execute(String arg)
	{
		if (arg == null || arg.length() == 0)
		{
			System.out.println("No filename provided.");
			return;
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
			  new edu.jhu.apl.patterns_class.Director(arg, builder);
			state.setDocument(builder.getDocument());
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

class WriteCommand implements Command
{
	Invoker	state	= null;

	public WriteCommand(Invoker state)	{ this.state	= state; }

	public void	Execute(String arg)
	{
		if (arg == null || arg.length() == 0)
		{
			System.out.println("No filename provided.");
			return;
		}

		try
		{
			XMLSerializer	xmlSerializer	=
			  new XMLSerializer(new java.io.BufferedWriter(new java.io.OutputStreamWriter(
			  new java.io.FileOutputStream(new java.io.File(arg)))));
			xmlSerializer.serializePretty();
			state.getDocument().Accept(xmlSerializer);
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
	}
}

class PrintCommand implements Command
{
	Invoker	state	= null;

	public PrintCommand(Invoker state)	{ this.state	= state; }

	public void	Execute(String arg)
	{
		try
		{
			java.io.BufferedWriter	buffer	= new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
			XMLSerializer	xmlSerializer	= new XMLSerializer(buffer);
			xmlSerializer.serializePretty();
			state.getDocument().Accept(xmlSerializer);
			buffer.flush();
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
	}
}
