package Lecture_32_backtracking; 
public class queen_permutation {
    public static void main(String[] args) {
        int n = 4;
        int totalQueen = 2;
        boolean[] board =  new boolean[n];
        permutation(board , totalQueen , 0 , "");

    }public static void permutation(boolean[] board , int totalQueen , int qpsf , String ans) {
        //qpsf--> queen placed so far
        if(totalQueen == qpsf){
            System.out.println(ans);
            return;
        }
        //recursive call
        for(int i = 0 ; i < board.length ; i++){
            if(board[i] == false){
                board[i] = true;
                permutation(board, totalQueen, qpsf +1, ans + "b" + i + "q" + qpsf);
                board[i] = false;
            }
        }
        
    }
    
}
