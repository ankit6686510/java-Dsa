package lecture_11_Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,7,9 -4,7,11};
        int item  = 4;
        System.out.println(search(arr,item));
    }
    public static int search(int[] arr , int item){
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == item){
                return i;
            }
        }
        return -1;
    }
}
