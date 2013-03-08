package piwords;

import java.util.HashMap;
import java.util.Map;

public class WordFinder
{
	/**
	 * Given a String (the haystack) and an array of Strings (the needles),
	 * return a Map<String, Integer>, where keys in the map correspond to
	 * elements of `needles' that were found as substrings of `haystack', and
	 * the value for each key is the lowest index of `haystack' at which that
	 * needle was found. A needle that was not found in the haystack should not
	 * be returned in the output map.
	 * 
	 * For example, let haystack = "abaaaaba" and needles = {"ab", "aaaa",
	 * "bb"}; then findWords would return {"ab" -> 0, "aaaa" -> 2}.
	 * 
	 * @param haystack
	 *            The string to search in.
	 * @param needles
	 *            The array of strings to search for. This array is not mutated.
	 *            No element of this array may be empty ("") or null.
	 * @return A map associating each needle that was found in the haystack with
	 *         the lowest index of the haystack at which that needle was found.
	 */
	public static Map<String, Integer> findWords(String haystack,
			String[] needles)
	{
		// First I create the Map of found words that I'm going to populate
		Map<String, Integer> foundWords = new HashMap<String, Integer>();
		// Here I iterate through every needle and check if it's in the Haystack
		for (int i = 0; i < needles.length; i++)
		{
			String currentNeedle = needles[i];
			// The indexOf function of Strings finds the starting index of a
			// word if it's a substring.
			// It returns -1 if the current needle is not in haystack.
			int indexInHaystack = haystack.indexOf(currentNeedle);
			// If it's in haystack, add it to he map
			if (indexInHaystack != -1)
			{
				foundWords.put(currentNeedle, indexInHaystack);
			}
		}
		return foundWords;

	}
}
