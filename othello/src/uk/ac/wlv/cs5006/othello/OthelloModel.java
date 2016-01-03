package uk.ac.wlv.cs5006.othello;

/**
 * The OthelloModel class.
 * @author ianskenny.
 * @since 14/15.
 */

public class OthelloModel extends AbstractModel
{
	/**
	 * DefaultConstructor. Initialises the game Grid.
	 */
	public OthelloModel(int rows, int cols)
	{
		super(rows, cols);
	}

	/**
	 * Clears the Grid and sets the initial configuration.
	 */
	public void setInitialState()
	{
		grid.clear();
		grid.setItemValue((grid.getNumRows()/2)-1,(grid.getNumColumns()/2)-1, "BLACK");
		grid.setItemValue((grid.getNumRows()/2)-1,(grid.getNumColumns()/2), "WHITE");
		grid.setItemValue((grid.getNumRows()/2),(grid.getNumColumns()/2)-1, "WHITE");
		grid.setItemValue((grid.getNumRows()/2),(grid.getNumColumns()/2), "BLACK");
	}

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
	 * Attempts to play the Item at the location specified. If the move is
	 * legal then the play will be made. If the move is not legal it won't be made.
	 * Thus if the move isn't legal the Grid will be left in the same state
	 * it was in prior to the method call.
	 *
	 * @param row the row number.
	 * @param col the column number.
	 * @param token the Item to attempt to play.
	 * @return true if the play was legal, false otherwise.
	 */
	public boolean attemptPlay(int row, int col, Item token)
	{
		// {horizontal right, horizontal left, vertical down, vertical up,
		// diagonal right down, diagonal left up, diagonal right up, diagonal left down}
		int[] rowInc = new int[]{0, 0, 1,-1, 1, -1, 1, -1};
		int[] colInc = new int[]{1,-1, 0, 0, 1, -1, -1, 1};

		boolean successfulPlay = false;

		// cannot play a null Item
		if (token == null)
			return successfulPlay;

		// is the attempted play location on the Grid?
		if (!grid.isOnGrid(row, col))
			return successfulPlay;

		// does the location already have a Item?
		if (!(grid.getItem(row, col).getValue().equals("EMPTY")))
			return successfulPlay;

		// save the Item at the play location in case the move is illegal
		String savedVal = grid.getItem(row, col).getValue();

		// play the Item first, then check it
		grid.setItemValue(row, col, token.getValue());

		for (int i = 0; i < rows; i++)
		{
			// calculate the starting cell for checking for a legal play
			GridLocation startLocation = new GridLocation(row + rowInc[i], col + colInc[i]);

			// check whether the cells contain a legal move
			CheckResult result = checkCells(startLocation, rowInc[i], colInc[i], token);

			// if there are any tokens to flip (i.e. a legal move) ...
			if (result.numItemsToFlip > 0)
			{
				// flip the tokens to this player's colour
				flipItems(result.start, rowInc[i], colInc[i], result.numItemsToFlip, token);
				successfulPlay = true;
			}
		}

		// if we didn't find a successful play, revert the token
		if (!successfulPlay)
			grid.setItemValue(row, col, savedVal);

		return successfulPlay;
	}

	/**
	 * Flips the given tokens to the opposite colour.
	 * @param start The location to start flipping from.
	 * @param rowInc The row increment (direction).
	 * @param colInc The column increment (direction).
	 * @param numToFlip The number of tokens to flip.
	 * @param token The desired colour of the Item.
	 */
	private void flipItems(GridLocation start, int rowInc, int colInc, int numToFlip, Item token)
	{
		int row = start.getRow();
		int col = start.getCol();

		for (int i = 0; i < numToFlip; i++) // assumes square Grid!
		{
			grid.setItemValue(row, col, token.getValue());
			row += rowInc;
			col += colInc;
		}
	}

	/**
	 * Check for a legal play in the direction given.
	 * @param start The location to start checking from.
	 * @param rowInc The row increment (direction).
	 * @param colInc The column increment (direction).
	 * @param token The Item that has been played.
	 * @return The CheckResult result.
	 */
	private CheckResult checkCells(GridLocation start, int rowInc, int colInc, Item token)
	{
		CheckResult result = new CheckResult();
		result.start = start;

		boolean done = false;

		int tokenCount = 0;

		int row = start.getRow();
		int col = start.getCol();

		for (/*  */; row < grid.getNumRows() && row >=0 && col < grid.getNumColumns() && col >= 0 && !done; row += rowInc, col += colInc) // assumes square Grid!
		{
			Item tok = grid.getItem(row, col);

			if (tok.getValue().equals("EMPTY"))
				done = false;

			if (tok.getValue() == getOpponent(token.getValue()))
				tokenCount++;

			else if (tok.getValue().equals(token.getValue()))
			{
				result.end.setRow(row);
				result.end.setCol(col);
				done = true;
			}
		}

		if (result.end.isInvalid())
			result.numItemsToFlip = 0;
		else result.numItemsToFlip = tokenCount;

		return result;
	}

	/**
	 * Checks if the Grid is full.
	 * @return true if the Grid is full, false otherwise (i.e. one or more EMPTY locations).
	 */
	public boolean gridIsFull()
	{
		return grid.gridIsFull();
	}

	/**
	 * Checks if the Grid contains only one colour of Item.
	 * @return true if the Grid has only one colour of Item, false otherwise.
	 */
	public boolean gridHasSingleValue()
	{
		return grid.gridHasSingleValue();
	}

	/**
	 * Gets the opponent of the Item.
	 * @param player the Item to find the opponent of.
	 * @return the opponent of the Item passed in.
	 */
	public String getOpponent(String player)
	{
		if (player.equals("BLACK"))
			return "WHITE";

		if (player.equals("WHITE"))
			return "BLACK";

		else return "EMPTY";
	}

	/**
	 * Gets the winning Item.
	 * @return the winning Item. EMPTY if a draw.
	 */
	public String getWinner()
	{
		int blackCount = 0;
		int whiteCount = 0;

		for (int i = 0; i < grid.getNumRows(); i++)
		{
			for (int j = 0; j < grid.getNumColumns(); j++)
			{
				Item tok = getItem(i, j);
				if (tok.getValue().equals("WHITE"))
					whiteCount++;

				else if (tok.getValue().equals("BLACK"))
					blackCount++;
			}
		}

		if (blackCount > whiteCount)
			return "BLACK";
		if (whiteCount > blackCount)
			return "WHITE";

		return "NONE"; // draw
	}

	/**
	 * The CheckResult class. A private class.
	 * @author ianskenny
	 * @since 14/15
	 */
	private class CheckResult
	{
		/**
		 * The start location.
		 */
		public GridLocation start;

		/**
		 * The end location.
		 */
		public GridLocation end;

		/**
		 * The number of Items to flip.
		 */
		public int numItemsToFlip;

		/**
		 * Constructor.
		 */
		public CheckResult()
		{
			start = new GridLocation();
			end = new GridLocation();

			clear();
		}

		/**
		 * Clears the result.
		 */
		public void clear()
		{
			start.setInvalid();
			end.setInvalid();
			numItemsToFlip = 0;
		}
	}
}


