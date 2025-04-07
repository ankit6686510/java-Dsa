package Lecture_30_Recursion;

public class count_maze_path {
    public static void main(String[] args) {
        int n = 4;//row
        int m = 5;//col
       System.out.println("\n"+ PrintPath(0, 0, n-1, m-1 , "")); //n-1 and m-1 due to indexing starts from 0
    }
    // cc-> current col , cr-> current row, er-> end row , ec-> end col
    public static int PrintPath(int cc, int cr , int er , int ec ,String ans){
        if(cr == er && cc == ec){
            System.out.println(ans);
            return 1;
        }
        if(cr > er || cc > ec){
            return 0;
        }
       int a1 =  PrintPath(cc+1, cr, er, ec , ans+"H");//horizontal move
        int a2 = PrintPath(cc, cr+1, er, ec , ans+"V");//horizontal move
        return a1+a2;

    }
}
