import java.util.*;

public class DI_string {

    public static void main(String[] args) {
        String s = "IIIDDII";
        System.out.println(diString(s));
    }

    public static String diString(String s) {
        int[] ans = new int[s.length() + 1];
        Stack<Integer> st = new Stack<>();
        int count = 1;

        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == 'I') {
                ans[i] = count;
                count++;
                while (!st.isEmpty()) {
                    ans[st.pop()] = count;
                    count++;
                }
            } else {
                st.push(i);
            }

        }
        String s1 = "";
        for (int i = 0; i < ans.length; i++) {
            s1 += ans[i];

        }
        return s1;

    }
}
