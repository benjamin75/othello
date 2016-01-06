package uk.ac.wlv.cs5006.othellotests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.wlv.cs5006.othello.GridCell;
import uk.ac.wlv.cs5006.othello.Item;

public class GridCellTest {

	

	@Test
	public void testGridCell() {
		GridCell grid1 = new GridCell ("BLACK");
		assertNotNull("", "BLACK");
		
		GridCell grid2 = new GridCell ("WHITE");
		assertNotNull("", "WHITE");
		
		
	}

	@Test
	public void testSetItem() {
		
	}

	@Test
	public void testSetValue() {
		
	}

	@Test
	public void testGetItem() {
		
	}

	@Test
	public void testGetLocation() {
	
	}

}
