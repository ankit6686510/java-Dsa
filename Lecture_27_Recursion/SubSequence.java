public class SubSequence {
    public static void main(String[] args) {
        String ques = "abc";
        printsubseq(ques,"");
    }
    public static void printsubseq(String ques, String ans){

        // base case--> if string is empty print the answer

        if(ques.length() == 0){
            System.out.println(ans + " ");
            return;

        }

        //take the first character
        char ch = ques.charAt(0);

            // Exclude current character
        printsubseq(ques.substring(1), ans);

        // Include current character
        printsubseq(ques.substring(1), ans+ch);


    }
}
