package Lecture_39_Divide_and_Conquer;

import Lecture_35_Backtracking.merge_two_sorted_array;

public class MergeSort {
    public static void main(String[] args){
        int[] arr = { 5, 1, 3, 4, 2 };
        arr = sort(arr , 0 , arr.length-1);
        for(int i = 0; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }

    }
    public static int[] sort(int[] arr , int si ,int ei){
        if(si ==ei){
            int[] base =  new int[1];
            base[0] =arr[si];
            return base;
        }
        int mid=  (si+ei)/2;
        int[] left = sort(arr , si , mid);
        int[] right = sort(arr , mid+1 , ei);
        return merge_two_sorted_array(left , right);
    }
    public static int[] merge_two_sorted_array(int[] arr1 , int[] arr2){
        int n =  arr1.length;
        int m = arr2.length;
        int[] ans =  new int[n+m];
        int i  = 0; //arr1
        int j = 0; //arr2
        int k = 0; //ans ka track rakhega

        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                ans[k] = arr1[i];
                i++;
                k++;
            }
            else{
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }
        while(i < n){
            ans[k] = arr1[i];
            i++;
            k++;
        }
        while(j < m){
            ans[k] = arr2[j];
            j++;
            k++;
        }
        return ans;

    }
}
