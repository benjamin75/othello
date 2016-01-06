package uk.ac.wlv.cs5006.othellotests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.wlv.cs5006.othello.GridLocation;

public class GridLocationTest {

	

	@Test
	public void testGridLocation() {
	GridLocation jg = new GridLocation (1,1);
	assertTrue (jg.getRow() ==1);
	assertTrue(jg.getCol() ==1);
	}

	@Test
	public void setrow() {
		GridLocation swe = new Grid
	}

	@Test
	public void testSetInvalid3() {
		GridLocation df = new GridLocation (-1,-1);
		df.setInvalid();
		assertTrue(df.isInvalid());
		GridLocation tlc = new GridLocation (1,1);
		
	}

	@Test
	public void testIsInvalid() {
		GridLocation df = new GridLocation ();
		df.setInvalid();
		assertTrue(df.isInvalid());
	}

	@Test
	public void invalidrow2() {
		GridLocation  = new GridLocation ();
	}

	@Test
	public void testGetCol() {
		
	}

	@Test
	public void testSetRow() {
	}

	@Test
	public void testSetCol() {
		
	}

}
