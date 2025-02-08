package lecture_11_Arrays;
import java.util.*;

public class Reverse_Range {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        //array input
        for(int i =0 ;i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int i = scn.nextInt();
        int j = scn.nextInt();

        reverse(arr, i, j);
        for(int k =0 ;k<arr.length ;k++){
            System.out.print(arr[k] + " ");
        }
        
    }
    public static void reverse(int[] arr,int i ,int j){
        while(i <j ){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }

    
}
