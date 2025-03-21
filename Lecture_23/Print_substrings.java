package Lecture_23;

public class Print_substrings {
    public static void main(String[] args) {
        String str = "84513";
        printSubString(str);
    }
    public static void printSubString(String s){
        for(int len = 1; len<=s.length();len++){
            for(int j = len; j <= s.length();j++){
                int i = j-len;
                System.out.println(s.substring(i,j) + " ");
              
            }
        }

    }

  
}
