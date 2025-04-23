package edu.jhu.apl.patterns_class;

public class StdOutObserver implements Observer
{
	public void	update(edu.jhu.apl.patterns_class.dom.replacement.Node container, short targetType, String target)
	{
		switch(targetType)
		{
		case org.w3c.dom.Node.ELEMENT_NODE:
			System.out.println("Validating Element " + target + " in parent " +
			  (container != null ? container.getNodeName() : "<none>"));
			break;
		case org.w3c.dom.Node.ATTRIBUTE_NODE:
			System.out.println("Validating Attribute " + target + " in parent " +
		  (container != null ? container.getNodeName() : "<none>"));
			break;
		case org.w3c.dom.Node.TEXT_NODE:
			System.out.println("Validating Text " + target + " in parent " +
			  (container != null ? container.getNodeName() : "<none>"));
			break;
		default:
			System.out.println("Validating unknown node type " + targetType);
			break;
		}
	}
}
