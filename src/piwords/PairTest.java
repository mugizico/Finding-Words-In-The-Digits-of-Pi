package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest
{

	@Test
	public void testEquals()
	{
		Pair<Integer, String> pair1 = new Pair<Integer, String>(5, "hello");
		Pair<Integer, String> pair2 = new Pair<Integer, String>(5, "hello");
		Pair<Integer, String> pair3 = new Pair<Integer, String>(4, "hello");
		Pair<String, String> pair4 = new Pair<String, String>("hello", "world");

		assertTrue(pair1.equals(pair1));
		assertTrue(pair1.equals(pair2));
		assertTrue(pair2.equals(pair1));

		assertFalse(pair1.equals(pair3));
		assertFalse(pair3.equals(pair1));
		assertFalse(pair3.equals(pair2));

		assertFalse(pair4.equals(pair1));
	}

	@Test
	public void testHashCode()
	{
		Pair<Integer, String> pair1 = new Pair<Integer, String>(40, "foo");
		Pair<Integer, String> pair2 = new Pair<Integer, String>(40, "foo");
		assertTrue(pair1.hashCode() == pair2.hashCode());
	}

	@Test
	public void lessThanCompareTo()
	{
		//Checks the less than ability of compareTo
		Pair<Character, Integer> pair1 = new Pair<Character, Integer>('a', 2);
		Pair<Character, Integer> pair2 = new Pair<Character, Integer>('a', 3);
		assertTrue(pair1.compareTo(pair2) < 0);
		Pair<Character, Integer> pair3 = new Pair<Character, Integer>('a', 2);
		Pair<Character, Integer> pair4 = new Pair<Character, Integer>('b', 3);
		assertTrue(pair3.compareTo(pair4) < 0);
	}

	@Test
	public void equalsCompareTo()
	{
		//Checks the equals ability of compareTo
		Pair<Character, Integer> pair1 = new Pair<Character, Integer>('a', 2);
		Pair<Character, Integer> pair2 = new Pair<Character, Integer>('a', 2);
		assertTrue(pair1.compareTo(pair2) == 0);
	}

	@Test
	public void greaterThanCompareTo()
	{
		//Checks the greater than ability of compareTo
		Pair<Character, Integer> pair1 = new Pair<Character, Integer>('a', 3);
		Pair<Character, Integer> pair2 = new Pair<Character, Integer>('a', 2);
		assertTrue(pair1.compareTo(pair2) > 0);
		Pair<Character, Integer> pair3 = new Pair<Character, Integer>('b', 3);
		Pair<Character, Integer> pair4 = new Pair<Character, Integer>('a', 2);
		assertTrue(pair3.compareTo(pair4) > 0);
	}

	@Test
	public void differentTypeComparison()
	{
		//Checks a comparison with types are not <character, integer> to make sure it's not Char/Int specific.
		Pair<Integer, Character> pair1 = new Pair<Integer, Character>(3, 'a');
		Pair<Integer, Character> pair2 = new Pair<Integer, Character>(2, 'a');
		assertTrue(pair1.compareTo(pair2) > 0);
		Pair<Integer, Character> pair3 = new Pair<Integer, Character>(3, 'c');
		Pair<Integer, Character> pair4 = new Pair<Integer, Character>(3, 'b');
		assertTrue(pair3.compareTo(pair4) > 0);
	}

}
