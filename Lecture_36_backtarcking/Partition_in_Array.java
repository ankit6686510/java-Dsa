package Lecture_36_backtarcking;

public class Partition_in_Array {
    public static void main(String[] args) {
        int[] arr  = {5,7,2,3,8,1,4,6,9 ,4};
        int idx = partition(arr, 0, arr.length-1);
        System.out.println(idx);    
        for(int i  = 0; i <arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
    public static int partition(int[] arr , int si ,int ei){
        int item =  arr[ei];
        int idx =  si;

        for(int i  = si ; i < ei ; i++){
            if(arr[i]  <= item){
                int temp =  arr[i];
                arr[i] = arr[idx];
                arr[idx] =  temp;
                idx++;
            }
        }
        int temp =  arr[ei];
        arr[ei] = arr[idx];
        arr[idx] = temp;
        return idx;
    }
}
