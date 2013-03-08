package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsToStringConverterTest
{
	@Test
	public void basicNumberSerializerTest()
	{
		// Input is a 4 digit number, 0123 represented in base 4
		int[] input = { 0, 1, 2, 3 };

		// Want to map 0 -> "d", 1 -> "c", 2 -> "b", 3 -> "a"
		char[] alphabet = { 'd', 'c', 'b', 'a' };

		String expectedOutput = "dcba";
		assertEquals(expectedOutput,
				DigitsToStringConverter.convertDigitsToString(input, 4,
						alphabet));
	}
	@Test
	public void complexSerializerTest()
	{
		// Input is a 4 digit number, 0123 represented in base 4
		int[] input = { 0, 1, 2, 3 };
		// Want to map 0 -> "!", 1 -> "?", 2 -> "#", 3 -> "$"
		char[] alphabet = { '!', '?', '#', '$' };

		String expectedOutput = "!?#$";
		assertEquals(expectedOutput,
				DigitsToStringConverter.convertDigitsToString(input, 4,
						alphabet));
	}
	@Test
	public void emptyNumberSerializerTest()
	{
		// This checks the case that the input is empty
		int[] input = {};

		// Want to map 0 -> "d", 1 -> "c", 2 -> "b", 3 -> "a"
		char[] alphabet = { 'd', 'c', 'b', 'a' };

		String expectedOutput = "";
		assertEquals(expectedOutput,
				DigitsToStringConverter.convertDigitsToString(input, 4,
						alphabet));
	}

	@Test
	public void repeatedNumberSerializerTest()
	{
		// Input is a 7 digit number, 0120134 represented in base 5
		int[] input = { 0, 1, 2, 0, 1, 3, 4 };

		// Want to map 0 -> "n", 1 -> "a", 2 -> "t", 3 -> "e", 4 -> "l"
		char[] alphabet = { 'n', 'a', 't', 'e', 'l' };

		String expectedOutput = "natnael";
		assertEquals(expectedOutput,
				DigitsToStringConverter.convertDigitsToString(input, 5,
						alphabet));
	}

	@Test
	public void inOrderSerializerTest()
	{
		// Input is a 7 digit number, 0123456 represented in base 7
		int[] input = { 0, 1, 2, 3, 4, 5, 6 };

		// Want to map 0 -> "g", 1 -> "e", 2 -> "t", 3 -> "a", 4 -> "h", 5 ->
		// "u", 6 -> "n"
		char[] alphabet = { 'g', 'e', 't', 'a', 'h', 'u', 'n' };

		String expectedOutput = "getahun";
		assertEquals(expectedOutput,
				DigitsToStringConverter.convertDigitsToString(input, 7,
						alphabet));
	}

	@Test
	public void exceptionTestOne()
	{
		// This makes sure it throws an exception when one of the input digits
		// >= the base
		try
		{
			int[] input = { 0, 1, 2, 3, 4, 5, 9 };
			char[] alphabet = { 'g', 'e', 't', 'a', 'h', 'u', 'n' };
			DigitsToStringConverter.convertDigitsToString(input, 7, alphabet);
			assertEquals(0, 1);
		} catch (IllegalArgumentException e)
		{
			assertEquals(1, 1);
		}

	}

	@Test
	public void exceptionTestTwo()
	{
		// This makes sure it throws an exception when one of the input digits <
		// 0
		try
		{
			int[] input = { 0, 1, 2, 3, 4, 5, -1 };
			char[] alphabet = { 'g', 'e', 't', 'a', 'h', 'u', 'n' };
			DigitsToStringConverter.convertDigitsToString(input, 7, alphabet);
			assertEquals(0, 1);
		} catch (IllegalArgumentException e)
		{
			assertEquals(1, 1);
		}
	}

	@Test
	public void mutationTestOne()
	{
		// This checks if the input array has been modified
		int[] input = { 0, 1, 2, 3, 4, 5 };
		int[] inputCopy = { 0, 1, 2, 3, 4, 5 };
		char[] alphabet = { 'g', 'e', 't', 'a', 'h', 'u', 'n' };
		DigitsToStringConverter.convertDigitsToString(input, 7, alphabet);
		assertArrayEquals(input, inputCopy);
	}

	@Test
	public void mutationTestTwo()
	{
		// This checks if the input alphabet is modified
		int[] input = { 0, 1, 2, 3, 4, 5 };
		char[] alphabet = { 'g', 'e', 't', 'a', 'h', 'u', 'n' };
		char[] alphabetCopy = { 'g', 'e', 't', 'a', 'h', 'u', 'n' };
		DigitsToStringConverter.convertDigitsToString(input, 7, alphabet);
		assertArrayEquals(alphabet, alphabetCopy);
	}

	@Test
	public void emptyAlphabet()
	{
		// This checks the case that the input is empty, the alphabet is empty
		// and it's in base 0.
		int[] input = {};
		char[] alphabet = {};
		assertEquals("", DigitsToStringConverter.convertDigitsToString(input,
				0, alphabet));
	}
}
