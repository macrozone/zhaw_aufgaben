import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerSetTest {

	@Test
	public void testAddElement() {
		IntegerSet set = new IntegerSet();
		set.addElement(5);
		assertEquals("{5}", set.toString());
	}

	@Test
	public void testHasElement() {
		IntegerSet set = new IntegerSet();
		set.addElement(5);
		set.addElement(6);
		set.addElement(7);
		assertTrue(set.hasElement(6));
		assertTrue(set.hasElement(7));
		assertTrue(set.hasElement(5));
		assertFalse(set.hasElement(9));

	}

	@Test
	public void testToString() {
		IntegerSet set = new IntegerSet();
		assertEquals("{}", set.toString());
		set.addElement(5);
		assertEquals("{5}", set.toString());
		set.addElement(6);
		assertEquals("{5,6}", set.toString());
	}

	@Test
	public void testUnion() {
		IntegerSet set = new IntegerSet();
		set.addElement(5);
		set.addElement(6);
		set.addElement(7);
		set.addElement(8);
		IntegerSet otherSet = new IntegerSet();
		otherSet.addElement(9);
		otherSet.addElement(10);
		otherSet.addElement(7);
		set.union(otherSet);

		assertTrue(set.hasElement(5));

		assertTrue(set.hasElement(6));

		assertTrue(set.hasElement(7));

		assertTrue(set.hasElement(8));

		assertTrue(set.hasElement(9));

		assertTrue(set.hasElement(10));

	}

	@Test
	public void testInterSec() {
		IntegerSet set = new IntegerSet();
		set.addElement(5);
		set.addElement(6);
		set.addElement(7);
		set.addElement(8);
		IntegerSet otherSet = new IntegerSet();
		otherSet.addElement(5);
		otherSet.addElement(10);
		otherSet.addElement(7);
		set.interSec(otherSet);

		assertTrue(set.hasElement(5));

		assertFalse(set.hasElement(6));

		assertTrue(set.hasElement(7));

		assertFalse(set.hasElement(8));

		assertFalse(set.hasElement(9));

		assertFalse(set.hasElement(10));
	}

	@Test
	public void testEqualsObject() {
		IntegerSet set = new IntegerSet();
		set.addElement(5);
		set.addElement(6);
		set.addElement(7);
		set.addElement(8);
		IntegerSet otherSet = new IntegerSet();
		otherSet.addElement(8);
		otherSet.addElement(5);
		otherSet.addElement(7);
		otherSet.addElement(6);
		assertTrue(set.equals(otherSet));

		IntegerSet anotherSet = new IntegerSet();
		anotherSet.addElement(6);
		anotherSet.addElement(5);
		anotherSet.addElement(13);
		assertFalse(set.equals(anotherSet));
	}

}
