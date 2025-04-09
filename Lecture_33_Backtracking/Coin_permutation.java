package Lecture_33_Backtracking;

public class Coin_permutation {
    public static void main(String[] args) {
        int[] coin = {2, 1 , 3 , 5};
        int amount = 4;
        coinPermutaions(coin , amount , "");
    }
    public static void coinPermutaions(int[] coin , int amount , String ans){
        if(amount == 0){
            System.out.println(ans);
            return;
        }
        for(int i = 0 ; i < coin.length ; i++){
            if(amount >= coin[i]){
                coinPermutaions(coin, amount-coin[i], ans + coin[i]);//changes will be in amount in frame
            }
        }
    }
    
    
}