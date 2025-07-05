package Lecture_23;

public class Cb_Number {

	public static void main(String[] args) {
		String input = "81615";
		System.out.println("Count of CB numbers: " + countCbNumbers(input));
	}

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

	public static boolean isValid(boolean[] visited, int i, int j) {
		for (; i < j; i++) {
			if (visited[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isCbNumber(long num) {
		// 0 and 1 are not CB numbers
		if (num == 0 || num == 1) {
			return false;
		}

		// Prime numbers that are considered CB numbers
		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

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
