package piwords;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PiGeneratorTest
{
	@Test
	public void basicPowerModTest()
	{
		// 5^7 mod 23 = 17
		assertEquals(17, PiGenerator.powerMod(5, 7, 23));
	}

	@Test
	public void morePowerModTests()
	{
		// 20^0 mod 23 = 1
		// Tests the case where the exponent is 0 to make sure the edge case is
		// covered
		assertEquals(1, PiGenerator.powerMod(20, 0, 23));
		// 0 ^ 5 mod 23 = 0
		// Tests the other edge case for possible a/b values
		assertEquals(0, PiGenerator.powerMod(0, 6, 23));
		// 1 ^ 50 mod 23
		assertEquals(1, PiGenerator.powerMod(1, 48, 23));
		// 50^0 mod 70
		assertEquals(1, PiGenerator.powerMod(50, 0, 70));
	}

	@Test
	public void largeNumberPowerModTest()
	{
		// 16407^1907990007 mod 20755
		// Tests the case in Main.java with very large numbers
		assertEquals(20138, PiGenerator.powerMod(16407, 1907990007, 20755));
		// 12189^203145978 mod 1009
		assertEquals(1, PiGenerator.powerMod(12189, 203145978, 1009));
	}

	@Test
	public void overFlowModTest()
	{
		// This tests for overflows by using Integer.maxValue - 3 as a base.
		assertEquals(265, PiGenerator.powerMod(2147483644, 3, 273));
	}

	@Test
	public void hexPiTest()
	{
		// First we check the edge condition of 0 precision
		assertEquals("[]", Arrays.toString(PiGenerator.computePiInHex(0)));
		// Next I check a precision of 1
		assertEquals("[2]", Arrays.toString(PiGenerator.computePiInHex(1)));
		// Last I just check a medium length number
		assertEquals("[2, 4, 3, 15, 6, 10, 8, 8, 8, 5]",
				Arrays.toString(PiGenerator.computePiInHex(10)));
	}
}
