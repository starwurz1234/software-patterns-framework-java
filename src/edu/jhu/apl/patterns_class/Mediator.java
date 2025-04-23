package edu.jhu.apl.patterns_class;

public class Mediator // and also Monostate
{
	private static java.util.Map<Subject, java.util.Vector<Observer> >	observers =
	  new java.util.HashMap<Subject, java.util.Vector<Observer> >();

	public void	_register(Subject subject, Observer observer)
	{
		if (observers.containsKey(subject))
		{
			java.util.Vector<Observer>	temp = observers.get(subject);

			if (!temp.contains(observer))
				temp.add(observer);
		}
		else
		{
			java.util.Vector<Observer>	temp = new java.util.Vector<Observer>();
			temp.add(observer);
			observers.put(subject, temp);
		}
	}

	public void	unregister(Subject subject, Observer observer)
	{
		if (observers.containsKey(subject))
			observers.get(subject).remove(observer);
	}

	public void
	  notify(Subject subject, edu.jhu.apl.patterns_class.dom.replacement.Node container, short targetType, String target)
	{
		java.util.Vector<Observer>	temp		= observers.get(subject);

		if (temp != null)
		{
			java.util.Iterator	iterator	= temp.iterator();

			while (iterator.hasNext())
				((Observer )iterator.next()).update(container, targetType, target);
		}
	}
};
