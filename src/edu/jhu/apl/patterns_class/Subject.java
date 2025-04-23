package edu.jhu.apl.patterns_class;

public abstract class Subject
{
	private java.util.Vector<Observer>	observers	= new java.util.Vector<Observer>();

	public void	attach(Observer observer)
	{
		Mediator	mediator = new Mediator();
		mediator._register(this, observer);
	}

	public void	detach(Observer observer)
	{
		Mediator	mediator = new Mediator();
		mediator.unregister(this, observer);
	}

	protected void	notify(edu.jhu.apl.patterns_class.dom.replacement.Node container, short targetType, String target)
	{
		Mediator	mediator = new Mediator();
		mediator.notify(this, container, targetType, target);
	}
}
