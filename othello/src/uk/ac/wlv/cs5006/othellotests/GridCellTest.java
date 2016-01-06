package uk.ac.wlv.cs5006.othellotests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.wlv.cs5006.othello.GridCell;
import uk.ac.wlv.cs5006.othello.GridLocation;
import uk.ac.wlv.cs5006.othello.Item;

public class GridCellTest {

	

	@Test
	public void testGridCell() {
		GridCell gjj = new GridCell(0, 0, null);
		Item bhg = new Item (null);
		gjj.setItem(bhg);
		
		
	}
	

	@Test
	public void testSetValue3() {
		Item pickitem	= new Item ("BLACK");
		
		pickitem.setValue("WHITE");
		assertEquals("testSetValue,setValue to WHITE", pickitem.getValue(),"WHITE");
		
		pickitem.setValue("BLACK");
		assertEquals("testSetValue,setValue to BLACK", pickitem.getValue(),"BLACK");
	}

	@Test
	public void invalidsquare3() {
		GridLocation df = new GridLocation (-1,-1);
		df.setInvalid();
		assertTrue(df.isInvalid());
		GridLocation tlc = new GridLocation (1,1);
 
	}

	@Test
	public void invalid() {
		GridLocation df = new GridLocation (-1,-1);
		df.setInvalid();
		assertTrue(df.isInvalid());
	}

	@Test
	public void testGetLocation() {
	Item itm = new Item("WHITE");
		GridCell token4= new GridCell(1, 1, itm);
		assertTrue(token4.getLocation().getCol()==1);
		assertTrue(token4.getLocation().getRow()==1);
	}

}
