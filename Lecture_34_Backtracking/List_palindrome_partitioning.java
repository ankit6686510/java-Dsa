package Lecture_34_Backtracking;

import java.util.*;

public class List_palindrome_partitioning {
    public static void main(String[] args) {
        String ques = "nitin";
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        
        partitioning(ques, list, ans);
        System.out.println(ans);
    }

    public static void partitioning(String ques, List<String> list, List<List<String>> ans) {
        if (ques.length() == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= ques.length(); i++) {
            String s = ques.substring(0, i);
            if (isPalindrome(s)) {
                list.add(s);
                partitioning(ques.substring(i), list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
