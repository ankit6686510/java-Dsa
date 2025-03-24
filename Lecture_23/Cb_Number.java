package Lecture_23;

/**
 * This class checks for CB numbers in a given string
 * and counts valid CB numbers based on specific rules
 */
public class Cb_Number {

	public static void main(String[] args) {
		String input = "81615";
		System.out.println("Count of CB numbers: " + countCbNumbers(input));
	}

	/**
	 * Counts the number of valid CB numbers in the given string
	 * @param s input string to process
	 * @return count of valid CB numbers
	 */
	public static int countCbNumbers(String s) {
		int count = 0;
		boolean[] visited = new boolean[s.length()];
		
		// Check all possible substring lengths
		for (int len = 1; len <= s.length(); len++) {
			for (int j = len; j <= s.length(); j++) {
				int i = j - len;
				String substring = s.substring(i, j);
				long number = Long.parseLong(substring);
				
				if (isCbNumber(number) && isValid(visited, i, j)) {
					count++;
					// Mark all characters in this substring as visited
					for (int k = i; k < j; k++) {
						visited[k] = true;
					}
				}
			}
		}
		return count;
	}

	/**
	 * Checks if the range from i to j-1 contains any visited positions
	 * @param visited array of visited positions
	 * @param i start index (inclusive)
	 * @param j end index (exclusive)
	 * @return true if no position in the range is visited, false otherwise
	 */
	public static boolean isValid(boolean[] visited, int i, int j) {
		for (; i < j; i++) {
			if (visited[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determines if a number is a CB number based on specific rules
	 * @param num number to check
	 * @return true if the number is a CB number, false otherwise
	 */
	public static boolean isCbNumber(long num) {
		// 0 and 1 are not CB numbers
		if (num == 0 || num == 1) {
			return false;
		}
		
		// Prime numbers that are considered CB numbers
		int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
		
		// Check if the number is in the primes list
		for (int prime : primes) {
			if (num == prime) {
				return true;
			}
		}
		
		// Check if the number is divisible by any prime
		for (int prime : primes) {
			if (num % prime == 0) {
				return false;
			}
		}
		
		return true;
	}
}