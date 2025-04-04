package Lecture_28_Recursion;

public class Count_SubSequnce {
    ublic static void main(String[] args) {
		
		String ques = "abc";
		System.out.println("\n"+PrintSubSeqnue(ques, ""));
		// System.out.println(count);

	}

//	static int count = 0;

	public static int PrintSubSeqnue(String ques, String ans) {
		
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			// count++;
			return 1;
		}

		char ch = ques.charAt(0);
		int a1 = PrintSubSeqnue(ques.substring(1), ans);
		int b1 = PrintSubSeqnue(ques.substring(1), ans + ch);
		return a1 + b1;
	}
}
