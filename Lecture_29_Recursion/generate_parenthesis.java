import java.util.ArrayList;
import java.util.List;

public class generate_parenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> ll = new ArrayList<>();
        parenthesis(n, 0, 0, "", ll);

        System.out.println(ll); // ✅ Print the list after function call
    }

    public static void parenthesis(int n, int open, int close, String ans, List<String> ll) {
        if (open == n && close == n) {
            ll.add(ans);  // ✅ Store valid parentheses in the list
            return;
        }
        if (open < n) {   // ✅ Open bracket tabhi add hoga jab open < n
            parenthesis(n, open + 1, close, ans + "(", ll);
        }
        if (close < open) {  // ✅ Close bracket tabhi add hoga jab close < open
            parenthesis(n, open, close + 1, ans + ")", ll);
        }
    }
}
