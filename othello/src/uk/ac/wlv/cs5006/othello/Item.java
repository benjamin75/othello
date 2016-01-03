package uk.ac.wlv.cs5006.othello;
/**
 * The Item class.
 * @author ianskenny.
 * @since 15/16
 */
public class Item
{
    /**
     * The value of this Item.
     */
	protected String value;

	/**
	 * Constructor.
	 * @param val the value to initialise this Item to.
	 */
	public Item(String val)
	{
		value = val;
	}

	/**
	 * Sets the value of the Item.
	 * @param val the value to set the Item to.
	 */
	public void setValue(String val)
	{
		value = val;
	}

	/**
	 * Gets the value of this Item.
	 * @return the value of this Item.
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Tests if another Item has the same value as this Item.
	 * @param other the Item to test against this Item.
	 * @return true if the Items have the same value, false otherwise.
	 */
	public boolean equals(Item other)
	{
		return this.value.equals(other.value);
	}
}
