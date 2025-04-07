package Lecture_30_Recursion;

public class Maze_Path {
    public static void main(String[] args) {
        int n = 4; // Rows
        int m = 5; // Columns
        PrintPath(0, 0, n - 1, m - 1, ""); // (n-1, m-1) because indexing starts from 0
    }

    // cr -> current row, cc -> current col, er -> end row, ec -> end col
    public static void PrintPath(int cr, int cc, int er, int ec, String ans) {
        if (cr == er && cc == ec) { // ✅ Reached destination
            System.out.println(ans);
            return;
        }
        if (cr > er || cc > ec) { // ✅ Out of bounds
            return;
        }
        PrintPath(cr, cc + 1, er, ec, ans + "H"); // ✅ Horizontal move (Right)
        PrintPath(cr + 1, cc, er, ec, ans + "V"); // ✅ Vertical move (Down)
    }
}
