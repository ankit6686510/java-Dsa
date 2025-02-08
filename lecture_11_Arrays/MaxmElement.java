package lecture_11_Arrays;

public class MaxmElement {
    public static void main(String[] args) {
        int[] arr = {1,5,8,7,9,6};
        System.out.println(max(arr));
        System.out.println(max_2(arr));

    }
    public static int max(int[] arr ){
        int max = arr[0];
        for(int i = 1; i <arr.length;i++){
            if(arr[i]> max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int max_2(int[] arr){
        int max= Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return  max;
    }
}
