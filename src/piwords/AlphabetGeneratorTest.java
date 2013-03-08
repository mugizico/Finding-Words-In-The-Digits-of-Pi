package piwords;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AlphabetGeneratorTest
{
	@Test
	public void inOrderGenerateFrequencyAlphabetTest()
	{
		// This tests when you have pairs already in order
		List<Pair<Character, Integer>> testInput = new ArrayList<Pair<Character, Integer>>();
		testInput.add(new Pair<Character, Integer>('a', 4));
		testInput.add(new Pair<Character, Integer>('b', 4));
		testInput.add(new Pair<Character, Integer>('c', 2));

		char[] expectedOutput = { 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c',
				'c' };
		assertArrayEquals(expectedOutput,
				AlphabetGenerator.generateFrequencyAlphabet(testInput));
	}

	@Test
	public void outOfOrderGenerateFrequencyAlphabetTest()
	{
		// This tests when you have pairs out of order
		List<Pair<Character, Integer>> testInput = new ArrayList<Pair<Character, Integer>>();
		testInput.add(new Pair<Character, Integer>('z', 4));
		testInput.add(new Pair<Character, Integer>('d', 4));
		testInput.add(new Pair<Character, Integer>('r', 2));

		char[] expectedOutput = { 'd', 'd', 'd', 'd', 'r', 'r', 'z', 'z', 'z',
				'z' };
		assertArrayEquals(expectedOutput,
				AlphabetGenerator.generateFrequencyAlphabet(testInput));
	}

	@Test
	public void emptyGenerateFrequencyAlphabetTestOutOfOrder()
	{
		// This tests when you have no pairs
		List<Pair<Character, Integer>> testInput = new ArrayList<Pair<Character, Integer>>();

		char[] expectedOutput = {};
		assertArrayEquals(expectedOutput,
				AlphabetGenerator.generateFrequencyAlphabet(testInput));
	}

	@Test
	public void repeatedPairsInOrderGenerateFrequencyAlphabetTest()
	{
		// This tests when you have repeated pairs in order
		List<Pair<Character, Integer>> testInput = new ArrayList<Pair<Character, Integer>>();
		testInput.add(new Pair<Character, Integer>('f', 4));
		testInput.add(new Pair<Character, Integer>('f', 4));
		testInput.add(new Pair<Character, Integer>('h', 2));
		testInput.add(new Pair<Character, Integer>('z', 2));
		char[] expectedOutput = { 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'h',
				'h', 'z', 'z' };
		assertArrayEquals(expectedOutput,
				AlphabetGenerator.generateFrequencyAlphabet(testInput));
	}

	@Test
	public void repeatedPairsOutOfOrderGenerateFrequencyAlphabetTest()
	{
		// This tests when you have repeated pairs out of order
		List<Pair<Character, Integer>> testInput = new ArrayList<Pair<Character, Integer>>();
		testInput.add(new Pair<Character, Integer>('u', 4));
		testInput.add(new Pair<Character, Integer>('s', 2));
		testInput.add(new Pair<Character, Integer>('u', 4));
		testInput.add(new Pair<Character, Integer>('t', 2));
		char[] expectedOutput = { 's', 's', 't', 't', 'u', 'u', 'u', 'u', 'u',
				'u', 'u', 'u' };
		assertArrayEquals(expectedOutput,
				AlphabetGenerator.generateFrequencyAlphabet(testInput));
	}

	@Test
	public void zeroTestGenerateFrequencyAlphabetTest()
	{
		// This tests when you have a pair with 0
		List<Pair<Character, Integer>> testInput = new ArrayList<Pair<Character, Integer>>();
		testInput.add(new Pair<Character, Integer>('u', 0));
		char[] expectedOutput = {};
		assertArrayEquals(expectedOutput,
				AlphabetGenerator.generateFrequencyAlphabet(testInput));
	}

	@Test
	public void maxCharGenerateFrequencyAlphabetTest()
	{
		// This tests when you have a pair with 0
		List<Pair<Character, Integer>> testInput = new ArrayList<Pair<Character, Integer>>();
		testInput.add(new Pair<Character, Integer>(Character.MAX_VALUE, 4));
		char[] expectedOutput = { Character.MAX_VALUE, Character.MAX_VALUE,
				Character.MAX_VALUE, Character.MAX_VALUE };
		assertArrayEquals(expectedOutput,
				AlphabetGenerator.generateFrequencyAlphabet(testInput));
	}
	@Test
	public void minCharGenerateFrequencyAlphabetTest()
	{
		// This tests when you have a pair with 0
		List<Pair<Character, Integer>> testInput = new ArrayList<Pair<Character, Integer>>();
		testInput.add(new Pair<Character, Integer>(Character.MIN_VALUE, 4));
		char[] expectedOutput = { Character.MIN_VALUE, Character.MIN_VALUE,
				Character.MIN_VALUE, Character.MIN_VALUE };
		assertArrayEquals(expectedOutput,
				AlphabetGenerator.generateFrequencyAlphabet(testInput));
	}
}
