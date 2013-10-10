import static org.junit.Assert.*;

import org.junit.Test;


public class IntegerListTest {


	@Test
	public void testAddToTail() {
		IntegerList list = new IntegerList(5);
		list.addToTail(6);
		assertEquals(6, list.getTailValue());
		assertEquals(5, list.getHeadValue());
	}

	@Test
	public void testAddToHead() {
		IntegerList list = new IntegerList(5);
		list.addToHead(7);
		list.addToHead(6);
		assertEquals(6, list.getHeadValue());
		assertEquals(5, list.getTailValue());
	}

	@Test
	public void testGetHeadValue() {
		IntegerList list = new IntegerList(5);
	
		assertEquals(5, list.getHeadValue());
	}

	@Test
	public void testGetTailValue() {
		IntegerList list = new IntegerList(5);
		list.addToTail(6);
		list.addToTail(7);
		
		assertEquals(7, list.getTailValue());
	}

	@Test
	public void testGetSize() {
		IntegerList list = new IntegerList(5);
		list.addToTail(6);
		list.addToHead(7);
		list.addToTail(8);
		assertEquals(4, list.getSize());
		
	}

	@Test
	public void testEqualsObjectEqual() {
		IntegerList list = new IntegerList(5);
		list.addToTail(6);
		list.addToHead(7);
		list.addToTail(8);
		
		IntegerList list2 = new IntegerList(5);
		list2.addToTail(6);
		list2.addToHead(7);
		list2.addToTail(8);
		
		assertTrue(list.equals(list2));
	
	}

	@Test
	public void testEqualsObjectNotEqual() {
		IntegerList list = new IntegerList(5);
		list.addToTail(6);
		list.addToHead(7);
		list.addToTail(8);
		
		IntegerList list2 = new IntegerList(5);
		list2.addToHead(4);
		list2.addToHead(7);
		list2.addToTail(8);
		
		assertFalse(list.equals(list2));
	
	}
	
	@Test
	public void testContains()
	{
		IntegerList list = new IntegerList(5);
		list.addToTail(6);
		list.addToHead(7);
		list.addToTail(8);
		assertTrue(list.contains(5));

		assertTrue(list.contains(6));

		assertTrue(list.contains(7));

		assertTrue(list.contains(8));
		

		assertFalse(list.contains(42));
	}
}

