public class Find_celebrity {
   
    } public int findCelebrity(int[][] M) {
        int top = 0;
        int down = M.length - 1;

        while (top < down) {
            if (M[top][down] == 1) {
                top = top + 1; // top knows down => top can't be celebrity
            } else {
                down = down - 1; // top doesn't know down => down can't be celebrity
            }
        }

        // Now top is the potential celebrity
        for (int i = 0; i < M.length; i++) {
            if (i != top) {
                // Celebrity should not know anyone, and everyone should know celebrity
                if (M[top][i] == 1 || M[i][top] == 0) {
                    return -1;
                }
            }
        }

        return top;
    }
}
