package piwords;

public class PiGenerator
{
	/**
	 * Returns `precision' hexadecimal digits of the fractional part of pi.
	 * Returns digits in most significant to least significant order.
	 * 
	 * @param precision
	 *            The number of digits after the decimal place to retrieve.
	 *            Requires precision >= 0.
	 * @return An array listing `precision' digits of pi (after the decimal
	 *         point) in hexadecimal.
	 */
	public static int[] computePiInHex(int precision)
	{
		// throw new RuntimeException("not implemented");
		// First we create the array of int that we are going to return,
		// we know exactly how large it is so we allocate precision space
		int[] arrayOfPiDigits = new int[precision];
		for (int i = 0; i < precision; ++i)
		{
			// And then for every element we calculate the corresponding pi
			// digit
			arrayOfPiDigits[i] = piDigit(i + 1);
		}
		return arrayOfPiDigits;
	}

	/**
	 * Computes a^b mod m.
	 * 
	 * For example, if a = 2, b = 3, and m = 5, this function computes 2^3 mod
	 * 5, which is 3.
	 * 
	 * The result of computing 0^0 is unspecified.
	 * 
	 * @param a
	 *            base; requires that a >= 0.
	 * @param b
	 *            exponent; requires that b >= 0.
	 * @param m
	 *            divisor for modulo operation; requires m > 0.
	 * @return a^b mod m
	 */
	public static int powerMod(int a, int b, int m)
	{
		// throw new RuntimeException("not implemented");
		// Initialize the final answer, it equals 1 because if b ==0, then a^b
		// will be 1
		long powerModAnswer = 1;
		long base = a;
		int exponent = b;
		int numberToMod = m;
		// Then we'll loop through until the exponent is 0
		while (exponent > 0)
		{
			// We then check if the exponent is odd
			if (exponent % 2 == 1)
			{
				// If it is odd, modify powerModAnswer using a property of mods
				powerModAnswer = (powerModAnswer * base) % numberToMod;
			}
			// Then divide the base by two
			exponent /= 2;
			// And use the same property again
			base = (base * base) % m;
		}
		// This last check is in case we have an exponent of 0 and a base of 1.
		powerModAnswer = powerModAnswer % m;
		return (int) powerModAnswer;

	}

	/**
	 * Computes the nth digit of Pi in base-16.
	 * 
	 * @param n
	 *            The digit of Pi to retrieve in base-16; the first digit after
	 *            the decimal point is n=1.
	 * @return The nth digit of Pi in base-16.
	 * @throws IllegalArgumentException
	 *             when n is less than 0.
	 */
	public static int piDigit(int n) throws IllegalArgumentException
	{
		if (n < 0)
			throw new IllegalArgumentException(
					"n less than 0 passed into piDigit");

		n -= 1;
		double x = 4 * piTerm(1, n) - 2 * piTerm(4, n) - piTerm(5, n)
				- piTerm(6, n);
		x = x - Math.floor(x);

		return (int) (x * 16);
	}

	private static double piTerm(int j, int n)
	{
		// Calculate the left sum
		double s = 0;
		for (int k = 0; k <= n; ++k)
		{
			int r = 8 * k + j;
			s += powerMod(16, n - k, r) / (double) r;
			s = s - Math.floor(s);
		}

		// Calculate the right sum
		double t = 0;
		int k = n + 1;
		// Keep iterating until t converges (stops changing)
		while (true)
		{
			int r = 8 * k + j;
			double newt = t + Math.pow(16, n - k) / r;
			if (t == newt)
			{
				break;
			} else
			{
				t = newt;
			}
			++k;
		}

		return s + t;
	}
}
