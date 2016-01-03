package uk.ac.wlv.cs5006.othello;

/**
 *
 * @author ianskenny
 * @since 14/15
 */

public abstract class AbstractModel
{
	/**
	 * The Grid of cells representing the board.
	 */
	protected Grid grid;

	/**
	 * The number of rows on the Grid.
	 */
	protected int rows;

	/**
	 * The number of columns on the Grid.
	 */
	protected int cols;

	/**
	 * Constructor.
	 * @param rows number of rows on the Grid.
	 * @param cols number of columns on the Grid.
	 */
	public AbstractModel(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;

		grid = new Grid(rows, cols);

		setInitialState();
	}

	/**
	 * Get the number of rows on the Grid.
	 * @return the number of rows on the Grid.
	 */
	public int getNumRows()
	{
		return rows;
	}

	/**
	 * Get the number of cols on the Grid.
	 * @return the number of cols on the Grid.
	 */
	public int getNumColumns()
	{
		return cols;
	}

	/**
	 * Resets the model for a new game.
	 */
	public void newGame()
	{
		grid.clear();
		setInitialState();
	}

	/**
	 * Clears the board of all non-EMPTY tokens and sets the initial configuration.
	 */
	public abstract void setInitialState();

	/**
	 * Gets the token at the position given.
	 * @param row the row number.
	 * @param col the column number.
	 * @return the Item at the position given.
	 */
	public Item getItem(int row, int col)
	{
		return grid.getItem(row, col);
	}

	/**
	 * Checks if the board is full.
	 * @return true if the board is full, false otherwise (i.e. one or more EMPTY locations).
	 */
	public boolean gridIsFull()
	{
		return grid.gridIsFull();
	}

	/**
	 * Checks if the board contains only one colour of Item.
	 * @return true if the board has only one colour of Item, false otherwise.
	 */
	public boolean gridHasSingleValue()
	{
		return grid.gridHasSingleValue();
	}
}
