package Lecture_28_Recursion;

public class Coin_toss {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		PrintAnswer(n, "");

	}

	public static void PrintAnswer(int n, String ans) {
		if (n == 0) {
			System.out.print(ans + " ");
			return;
		}

		PrintAnswer(n - 1, ans + "H");
		PrintAnswer(n - 1, ans + "T");

	}
    
}
