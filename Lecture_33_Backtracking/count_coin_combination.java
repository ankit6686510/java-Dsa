package Lecture_33_Backtracking;

public class count_coin_combination {
    public static void main(String[] args) {
        int[] coin = {2, 1, 3, 5};
        int amount = 4;
        int totalCount = coinCombination(coin, amount, "", 0); // ✅ pass correct arguments
        System.out.println("Total combinations: " + totalCount); // ✅ print count
    }

    public static int coinCombination(int[] coin, int amount, String ans, int idx) {
        if (amount == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coin.length; i++) {
            if (amount >= coin[i]) {
                count += coinCombination(coin, amount - coin[i], ans + coin[i], i); // ✅ include i
            }
        }
        return count;
    }
}
