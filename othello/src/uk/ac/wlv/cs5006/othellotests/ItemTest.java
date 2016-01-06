package uk.ac.wlv.cs5006.othellotests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.wlv.cs5006.othello.Item;

public class ItemTest {

	@Test
	public void testItem() {
		Item item1 = new Item ("BLACK");
		assertNotNull("", "BLACK");
		
		Item item2 = new Item ("WHITE");
		assertNotNull("", "WHITE");
	}

	@Test
	public void testSetValue() {
		Item pickitem	= new Item ("BLACK");
		
		pickitem.setValue("WHITE");
		assertEquals("testSetValue,setValue to WHITE", pickitem.getValue(),"WHITE");
		
		pickitem.setValue("BLACK");
		assertEquals("testSetValue,setValue to BLACK", pickitem.getValue(),"BLACK");
	}

	@Test
	public void testGetValue() {
Item pickitem	= new Item ("BLACK");
		
		pickitem.setValue("WHITE");
		assertEquals("testGetValue,getValue to WHITE", pickitem.getValue(),"WHITE");
		
		pickitem.setValue("BLACK");
		assertEquals("testGetValue,getValue to BLACK", pickitem.getValue(),"BLACK");
	}

	@Test
	public void testEqualsItem() {
		Item item1= new Item("WHITE");
		Item item2= new Item("WHITE");
		Item item3= new Item("BLACK");
		
		assertFalse("testEqualsItem", item1.equals(item3));
		assertTrue("testEqualsItem", item1.equals(item2));
	}

}
