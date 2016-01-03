package uk.ac.wlv.cs5006.othello;

/**
 * This class represents a single cell on the Grid. It has a location and a token value.
 * @author ianskenny
 * @since 14/15
 */
public class GridCell
{
	/**
	 * The Item at this GridCell.
	 */
	private Item token;

	/**
	 * The CellLocation of this GridCell.
	 */
	private GridLocation location;

	/**
	 * Constructor.
	 * @param row the row number.
	 * @param col the column number.
	 * @param token the Item value.
	 */
	public GridCell(int row, int col, Item token)
	{
		this.token = token;
		location = new GridLocation(row, col);
	}

	/**
	 * Sets the Item value.
	 * @param token the Item value.
	 */
	public void setItem(Item token)
	{
		this.token = token;
	}

	/**
	 * Set the value of the Item in this GridCell.
	 * @param val the value of the Item.
	 */
	public void setValue(String val)
	{
		this.token.setValue(val);
	}

	/**
	 * Gets the Item value.
	 * @return the Item at this GridCell.
	 */
	public Item getItem()
	{
		return token;
	}

	/**
	 * Get the GridLocation for this GridCell.
	 * @return the GridLocation for this GridCell.
	 */
	public GridLocation getLocation()
	{
		return location;
	}
}
