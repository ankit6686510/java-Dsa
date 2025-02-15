package sorting;

import java.util.Arrays;

public class cyclic_sort {
    public static void main(String[] args) {

        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, };
        cyclicsort(arr);    //cyclic sort function call
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");//for printing array element
        }
        System.out.println(Arrays.toString(arr));//for printing arrays 
    }
    public static void cyclicsort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] -1;
             // Handle duplicates: If element is already in place or is duplicate, skip it
    //          if (arr[i] >= 1 && arr[i] <= arr.length && arr[i] != arr[correct]) {
    //             swap(arr, i, correct);
    //         } else {
    //             i++;
    //         }
    //     }
    // }
            if(arr[i] != arr[correct]){
                swap(arr,i ,correct);

            }else{
                i++;
            }
        }
    }
    public static void swap(int [] arr, int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] =  temp;

    }

}
