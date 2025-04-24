package Lecture_39_Divide_and_Conquer;

import java.util.Random;

public class RandomNo {
    public static void main(String[] args) {
        int si  = 10;
        int ei =  90;
        randomeno(si ,ei);
    }
    public static void randomeno(int si , int ei){
        Random rand  =  new Random();
        int lo =  si;
        int hi = ei;
        for(int i  = 0 ; i < 10 ; i++){
            int rn =  rand.nextInt(hi -lo +1) +10;
            System.out.print(rn  + " ");
        }
    }
}
