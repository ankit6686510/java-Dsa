package Lecture_34_Backtracking;

public class palindrome_partioning {
    public static void main(String[] args) {
        String ques = "nitin";
        partitioning(ques,  "");
    }
    public static void partitioning(String ques , String ans){
        if(ques.length() == 0 ){
            System.out.println(ans);
            return;
        }
        for(int i = 1 ; i <= ques.length() ; i++){
            String s =  ques.substring(0 ,i);
            if(isPalindrome(s) == true){
                partitioning(ques.substring(i) ,ans + s + "|");
            }
        }
    }
    public static boolean isPalindrome(String s){
        int  i = 0;
        int  j = s.length() -1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
