package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseTranslatorTest
{
	@Test
	public void basicBaseTranslatorTest()
	{
		// Expect that .001 in base-2 is .25 in base-10
		// (0 * 1/2^1 + 0 * 1/2^2 + 1/2^3 = .125)
		int[] input = { 0, 0, 1 };
		int[] expectedOutput = { 1, 2, 5 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 2, 10, 3));
	}

	@Test
	public void differingSizeBaseTranslatorTest()
	{
		// This tests a basic case of base 10 to base 2
		int[] input = { 2, 5 };
		int[] expectedOutput = { 0, 1, 0 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 10, 2, 3));
	}

	@Test
	public void baseSixteenToBaseTwoTranslatorTest()
	{
		// .05 base 16 to base 2
		int[] input = { 0, 5 };
		int[] expectedOutput = { 0, 0, 0, 0, 0, 1, 0, 1, 0 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 16, 2, 9));
	}

	@Test
	public void baseSixteenToBaseFourTranslatorTest()
	{
		// .05 base 16 to base 4
		int[] input = { 0, 5 };
		int[] expectedOutput = { 0, 0, 1, 1, 0 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 16, 4, 5));
	}

	@Test
	public void baseSixteenToBaseEightTranslatorTest()
	{
		// .05 base 16 to base 8
		int[] input = { 0, 5 };
		int[] expectedOutput = { 0, 1, 2, 0 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 16, 8, 4));
	}

	@Test
	public void baseSixteenToBaseSixteenTranslatorTest()
	{
		// .05 base 16 to base 16, should be no change but adds a 0.
		int[] input = { 0, 5 };
		int[] expectedOutput = { 0, 5, 0 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 16, 16, 3));
	}

	@Test
	public void baseEightToBaseTwoTranslatorTest()
	{
		// .07 base 8 to base 2
		int[] input = { 0, 7 };
		int[] expectedOutput = { 0, 0, 0, 1, 1, 1, 0 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 8, 2, 7));
	}

	@Test
	public void baseEightToBaseFourTranslatorTest()
	{
		// .07 base 8 to base 4
		int[] input = { 0, 7 };
		int[] expectedOutput = { 0, 1, 3, 0 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 8, 4, 4));
	}

	@Test
	public void baseEightToBaseSixteenTranslatorTest()
	{
		// .07 base 8 to base 16
		int[] input = { 0, 7 };
		int[] expectedOutput = { 1, 12, 0 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 8, 16, 3));
	}

	@Test
	public void baseSevenToBaseTenTranslatorTest()
	{
		// .06452 base 7 to base 10, high precision
		int[] input = { 0, 6, 4, 5, 2 };
		int[] expectedOutput = { 1, 3, 6, 3, 1, 2, 2, 5, 0, 8, 4, 7, 8, 6 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 7, 10, 14));
	}

	@Test
	public void baseTwentyToBaseNinetyTranslatorTest()
	{
		// .021 base 20 to base 90, a high base translation
		int[] input = { 0, 2, 1 };
		int[] expectedOutput = { 0, 41, 46, 11, 22, 45 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 20, 90, 6));
	}

	@Test
	public void mutabilityTest()
	{
		// Checks if the input has been mutated.
		int[] input = { 0, 2, 1 };
		int[] inputCopy = new int[input.length];
		System.arraycopy(input, 0, inputCopy, 0, 3);
		BaseTranslator.convertBase(input, 20, 90, 6);
		assertArrayEquals(input, inputCopy);

	}

	@Test
	public void baseOverflowTest()
	{
		// Checks for overflow errors
		int[] input = { 3 };
		int[] expectedOutput = { 600000000 };
		assertArrayEquals(expectedOutput,
				BaseTranslator.convertBase(input, 10, 2000000000, 1));
	}

	@Test
	public void exceptionTestOne()
	{
		// Checks if the digits[i] >= baseA case throws an exception
		try
		{
			int[] input = { 0, 5, 3 };
			BaseTranslator.convertBase(input, 2, 5, 6);
			assertEquals(0, 1);
		} catch (IllegalArgumentException e)
		{
			assertEquals(1, 1);
		}
	}

	@Test
	public void exceptionTestTwo()
	{
		// Checks if the digits[i] < 0 case throws an exception
		try
		{
			int[] input = { 0, -1, 3 };
			BaseTranslator.convertBase(input, 2, 5, 6);
			assertEquals(0, 1);
		} catch (IllegalArgumentException e)
		{
			assertEquals(1, 1);
		}
	}
}
