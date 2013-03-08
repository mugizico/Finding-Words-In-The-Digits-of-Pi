package piwords;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordFinderTest
{
	@Test
	public void basicFindWordsTest()
	{
		// This is just checking to make sure it works
		String haystack = "abcde";
		String[] needles = { "ab", "abc", "de", "fg" };

		Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
		expectedOutput.put("ab", 0);
		expectedOutput.put("abc", 0);
		expectedOutput.put("de", 3);

		assertEquals(expectedOutput, WordFinder.findWords(haystack, needles));
	}

	@Test
	public void complexFindWordsTest()
	{
		// This tests with a more complex haystack and needles
		String haystack = "thisisasentencethat";
		String[] needles = { "this", "is", "a", "sentence", "hat", "that" };

		Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
		expectedOutput.put("this", 0);
		expectedOutput.put("is", 2);
		expectedOutput.put("a", 6);
		expectedOutput.put("sentence", 7);
		expectedOutput.put("hat", 16);
		expectedOutput.put("that", 15);

		assertEquals(expectedOutput, WordFinder.findWords(haystack, needles));
	}

	@Test
	public void noNeedlesFindWordsTest()
	{
		// This tests for when none of the needles are in the haystack
		String haystack = "thisisasentencethat";
		String[] needles = { "these", "words", "arent", "in", "the", "haystack" };

		Map<String, Integer> expectedOutput = new HashMap<String, Integer>();

		assertEquals(expectedOutput, WordFinder.findWords(haystack, needles));
	}

	@Test
	public void emptyNeedleTest()
	{
		// This tests for when the needle is empty
		String haystack = "thisisasentencethat";
		String[] needles = {};

		Map<String, Integer> expectedOutput = new HashMap<String, Integer>();

		assertEquals(expectedOutput, WordFinder.findWords(haystack, needles));
	}

	@Test
	public void emptyNeedleAndEmptyHaystack()
	{
		// This tests for when the needle and haystack
		String haystack = "";
		String[] needles = {};

		Map<String, Integer> expectedOutput = new HashMap<String, Integer>();

		assertEquals(expectedOutput, WordFinder.findWords(haystack, needles));
	}

	@Test
	public void emptyHaystack()
	{
		// This tests for when just the haystack is empty.
		String haystack = "";
		String[] needles = { "aasdf" };

		Map<String, Integer> expectedOutput = new HashMap<String, Integer>();

		assertEquals(expectedOutput, WordFinder.findWords(haystack, needles));
	}

	@Test
	public void needleModificationTest()
	{
		// This checks if the input array needles has been modified.
		String haystack = "";
		String[] needles = { "aasdf" };
		String[] needlesCopy = { "aasdf" };
		WordFinder.findWords(haystack, needles);
		assertArrayEquals(needles, needlesCopy);
	}
}
