package Lecture_35_Backtracking;

public class merge_two_sorted_array {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 5, 7, 11};
        int[] arr2 = {1, 2, 3, 7, 12, 13, 14, 15};
        int[] ans =  mergeSortedArray(arr1, arr2);
        for(int i  = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }
    public static int[] mergeSortedArray(int[] arr1 , int[] arr2){
        int n =  arr1.length;
        int m =  arr2.length;
        int[] ans =  new int[n + m];
        int i = 0; //arr1
        int j = 0; // arr2
        int k = 0; //ans waale index ka track

        while( i < n  && j < m){
            if(arr1[i] < arr2[j]){
                ans[k] = arr1[i];
                i++;
                k++;
            }else{
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }
        while(i < n){
            //aggr hamara array 1 bach gya hota to 
            ans[k] = arr1[i];
            i++;
            k++;

        }
        //ya array 2 bach gya ho to
        while(j < m ){
            ans[k] = arr2[j];
            j++;
            k++;
        }
        return ans;



    } 
}
