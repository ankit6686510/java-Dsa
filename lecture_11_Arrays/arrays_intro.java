package lecture_11_Arrays;

import java.util.Scanner;

public class arrays_intro {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        display(arr);
        
    }
    public static void display(int[] arr){
        for(int i =0 ;i <arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
  

}

