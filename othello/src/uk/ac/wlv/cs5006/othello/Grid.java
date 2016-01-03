package uk.ac.wlv.cs5006.othello;

/**
 * This class represents the game Grid.
 * @author ianskenny
 * @since 14/15
 */

public class Grid
{
	/**
	 * The number of rows in the Grid.
	 */
	private int rows;

	/**
	 * The number of columns in the Grid.
	 */
	private int cols;

	/**
	 * The Grid as a 2d array of GridCell objects.
	 */
	private GridCell[][] cells;


	/**
	 * Constructor
	 * @param nrows the number of rows on this Grid.
	 * @param ncols the number of columns on this Grid.
	 */
  	public Grid(int nrows, int ncols)
	{
  		rows = nrows;
  		cols = ncols;
  		cells = new GridCell[rows][cols];
  		clear();
	}

  	/**
  	 * Gets the number of rows on this Grid.
  	 * @return the number of rows on this Grid.
  	 */
  	public int getNumRows()
  	{
  		return rows;
  	}

  	/**
  	 * Gets the number of columns on this Grid.
  	 * @return the number of columns on this Grid.
  	 */
  	public int getNumColumns()
  	{
  		return cols;
  	}


	/**
	 * Clears the Grid and sets all tokens to EMPTY
	 */
	public void clear()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				cells[i][j] = new GridCell(i, j, new Item("EMPTY"));
			}
		}
	}

	/**
	 * Sets the given cell to the Item value.
	 * @param row the row number.
	 * @param col the column number.
	 * @param value the Item value.
	 */
	public boolean setItemValue(int row, int col, String value)
	{
		 if (isOnGrid(row, col))
		 {
			 cells[row][col].setValue(value);
			 return true;
		 }

		 return false;
	}

	/**
	 * Gets the Item at the given cell.
	 * @param row the row number.
	 * @param col the column number.
	 * @return the Item at the given cell.
	 */
	public Item getItem(int row, int col)
	{
		 if (isOnGrid(row, col))
		 {
			 return cells[row][col].getItem();
		 }

		 return null;
	}

	/**
	 * Tests if the cell represented by (row, col) is on the Grid.
	 * @param row the row number.
	 * @param col the column number.
	 * @return true if the cell is on the Grid, false otherwise.
	 */
	public boolean isOnGrid(int row, int col)
	{
		 if (row >= 0 && row < rows && col >= 0 && col < cols)
		 {
			 return true;
		 }

		 else return false;
	}

	/**
	 * Checks if the Grid is full.
	 * @return true if the Grid is full, false otherwise (i.e. one or more EMPTY locations).
	 */
	public boolean gridIsFull()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (getItem(i, j).getValue().equals("EMPTY"))
					return false;
			}
		}

		return true;
	}

	/**
	 * Checks if the Grid contains only one colour.
	 * @return true if the Grid contains a single colour, false otherwise.
	 */
	public boolean gridHasSingleValue()
	{
	    // find the first token
	    Item checkItem = null;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (!(getItem(i, j).getValue().equals("EMPTY")))
                    checkItem = getItem(i, j);
            }
        }

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (!getItem(i, j).getValue().equals("EMPTY") && (!getItem(i, j).getValue().equals(checkItem.getValue())))
					return false;
			}
		}

		return true;
	}
}
