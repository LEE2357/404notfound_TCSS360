/*
 * TCSS 360 - Spring 2019
 */

package model;

/**
 * Provides several static methods for formatting strings.
 * 
 * @author Gordon McCreary
 * @version May 30, 2019
 */
public class StringFormatters {
	
	/**
	 * Formats the given string by removing any non-integer characters.
	 * 
	 * @param theOriginal The original string before formatting.
	 * @return The new string after formatting to integer.
	 */
	public static String removeNonInt(final String theOriginal) {
		String result = "";
		for (int i = 0; i < theOriginal.length(); i++) {
			int c = Character.getNumericValue(theOriginal.charAt(i));
			if (Character.getNumericValue('0') <= c
								   && c <= Character.getNumericValue('9')) {
				result += theOriginal.charAt(i);
			}
		}
		return result;
	}
	
	/**
	 * Formats the given string to properly represent a US dollar value.
	 * 
	 * @param theOriginal The original string before formatting.
	 * @return The new string after formatting to US dollar.
	 */
	public static String formatCost(final String theOriginal) {
		String result = "$";
		final String[] split = theOriginal.split("\\.", 2);
		result += removeNonInt(split[0]);
		if (split.length > 1) {
			String change = removeNonInt(split[1]);
			while (change.length() < 2) {
				change += "0";
			}
			result += "." + change.substring(0, 2);
		}
		return result;
	}
	
	/**
	 * Formats the given string to make its length theLength or less..
	 * 
	 * @param theOriginal The original string before formatting.
	 * @param theLength The maximum length of the string.
	 * @return The new string after removing character past index theLength.
	 * @throws IndexOutOfBoundsException If theLength is negative.
	 */
	public static String formatLength(final String theOriginal, final int theLength) {
		String result = theOriginal;
		if (result.length() > theLength) {
			result = result.substring(0, theLength);
		}
		return result;
	}
}