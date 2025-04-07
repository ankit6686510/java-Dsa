package lecture31recursion;

public class LexicalCountingPrint {
    public static void main(String[] args) {
        int n = 1000;
        printLexicographic(0,n);
    }
    public static void printLexicographic(int curr, int n){
        

        if(curr > n){
            return;
        }
        System.out.println(curr);
        
        int i  = 0;
        if(curr == 0){
            i = 1;
        }
        for(; i <=9 ; i++){
            printLexicographic(curr*10 + i ,n);
        }
        
    }
}
