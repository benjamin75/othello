package uk.ac.wlv.cs5006.othello;

public abstract class AbstractController
{
	/**
	 * The Model.
	 */
	protected AbstractModel model;

	/**
	 * Constructor.
	 * @param model the Model.
	 */
	public AbstractController(AbstractModel model)
	{
		this.model = model;
	}

	/**
	 * Get the Item at the location specified.
	 * @param row the row number.
	 * @param col the column number.
	 * @return the Item at the location specified.
	 */
	public Item getItem(int row, int col)
	{
		return model.getItem(row, col);
	}

	/**
	 * Get the number of rows on the Grid.
	 * @return the number of rows on the Grid.
	 */
	public int getNumRows()
	{
		return model.getNumRows();
	}

	/**
	 * Get the number of columns on the Grid.
	 * @return the number of columns on the Grid.
	 */
	public int getNumColumns()
	{
		return model.getNumColumns();
	}

	/**
	 * Resets the board for a new game.
	 */
	public void newGame()
	{
		model.newGame();
	}

	/**
	 * Checks if the board is full.
	 * @return true if the board is full, false otherwise (i.e. one or more EMPTY locations).
	 */
	public boolean boardIsFull()
	{
		return model.gridIsFull();
	}

	/**
	 * Checks if the board contains only one colour of Item.
	 * @return true if the board has only one colour of Item, false otherwise.
	 */
	public boolean boardHasSingleValue()
	{
		return model.gridHasSingleValue();
	}
}
