package Lecture_33_Backtracking;

public class Count_coin_permutation {
    public static void main(String[] args) {
        int[] coin = {2, 1, 3, 5};
        int amount = 4;
        int totalCount = coinPermutaions(coin, amount, ""); // 🌟 store the returned count
        System.out.println("Total permutations: " + totalCount); // 🌟 print count
    }

    public static int coinPermutaions(int[] coin, int amount, String ans) {
        if (amount == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < coin.length; i++) {
            if (amount >= coin[i]) {
                count += coinPermutaions(coin, amount - coin[i], ans + coin[i]);
            }
        }

        return count; // 🌟 return the total count to previous stack
    }
}
