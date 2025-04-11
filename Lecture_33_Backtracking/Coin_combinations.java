package Lecture_33_Backtracking;

public class Coin_combinations {
    public static void main(String[] args) {
        int[] coin =  {2 , 1, 3, 5};
        int amount = 4;
        coinCombination(coin , amount , "" , 0);
    }

    public static void coinCombination(int[] coin, int amount, String ans, int idx) {
        if(amount == 0){
            System.out.println(ans);
            return; 
        }

        for(int i = idx; i < coin.length; i++){
            if(amount >= coin[i]){
                coinCombination(coin, amount - coin[i], ans + coin[i] + " ", i);
            }
        }
    }
}
