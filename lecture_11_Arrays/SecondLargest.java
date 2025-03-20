package lecture_11_Arrays;

import BasicsIntro.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
    }
    public static void SecondLargestElement(int arr[],int largest,int secondLargest){
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(
                arr[i] > secondLargest && arr[i] != largest
            )
    }
}
