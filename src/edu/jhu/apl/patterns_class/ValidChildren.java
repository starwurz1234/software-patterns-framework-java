package edu.jhu.apl.patterns_class;

public class ValidChildren
{
	private String				thisElement		= null;	// A value of null represents Document.
	private java.util.Vector<String>	validChildren		= new java.util.Vector<String>();
	private java.util.Vector<Boolean>	childIsAttribute	= new java.util.Vector<Boolean>();
	private boolean				_canHaveText		= false;

	public ValidChildren(String thisElement)		{ this.thisElement = thisElement; }

	public ValidChildren(ValidChildren v)
	{
		thisElement	= v.thisElement;
		validChildren	= new java.util.Vector<String>(v.validChildren);	// These are sufficiently deep copies
		childIsAttribute= new java.util.Vector<Boolean>(v.childIsAttribute);	// since String and Boolean are immutable.
		_canHaveText	= v._canHaveText;
	}

	public String	getThisElement()			{ return thisElement; }
	public boolean	canHaveText()				{ return _canHaveText; }
	public void	setCanHaveText(boolean _canHaveText)	{ this._canHaveText = _canHaveText; }

	public void	addValidChild(String child, boolean isAttribute)
	{
		if (childIsValid(child, isAttribute))
			return;

		validChildren.add(child);
		childIsAttribute.add(new Boolean(isAttribute));
	}

	public boolean	childIsValid(String child, boolean isAttribute)
	{
		for (int i = 0; i < validChildren.size(); i++)
			if (childIsAttribute.elementAt(i).booleanValue() == isAttribute &&
			  validChildren.elementAt(i).compareTo(child) == 0)
				return true;

		return false;
	}

	//
	// For XML validation completeness, ValidChildren should also have methods for verifying the validity of attribute values
	// as commented in original version of XMLValidator.
	//
}
