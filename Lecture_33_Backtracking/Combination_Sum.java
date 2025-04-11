package Lecture_33_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {

    // https://leetcode.com/problems/combination-sum/description/
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();

        combinations(candidates, target, ll, 0, ans);

        System.out.println(ans);

    }

    public static void combinations(int[] coin, int amount, List<Integer> ll, int idx, List<List<Integer>> ans) {

        // base case
        if (amount == 0) {
            ans.add(new ArrayList<Integer>(ll));
            return;
        }
        for (int i = idx; i < coin.length; i++) {
            if (amount >= coin[i]) {
                ll.add(coin[i]);
                combinations(coin, amount - coin[i], ll, i, ans);
                ll.remove(ll.size() - 1);
            }
        }
    }
}
