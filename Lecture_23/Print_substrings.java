package Lecture_23;

public class Print_substrings {
    public static void main(String[] args) {
        String str = "84513";
        System.out.println("All substrings of \"" + str + "\":");
        printSubstrings(str);
    }
    
    // Function to print all substrings
    public static void printSubstrings(String input) {
        // Iterate through all possible substring lengths
        for (int len = 1; len <= input.length(); len++) {
            // For each length, find all possible substrings
            for (int j = len; j <= input.length(); j++) {
                int i = j - len;
                String substring = input.substring(i, j);
                System.out.println(substring);
            }
        }
    }
}
