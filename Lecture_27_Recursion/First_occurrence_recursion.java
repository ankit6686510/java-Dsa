public class First_occurrence_recursion {
    public static void main(String[] args) {
        int[] arr= {2,13,7,5,3,4,5,6,3,9,3};
        int item = 3;
        System.out.println(FirstIndex(arr,0,3));
        
    }
    public static int FirstIndex(int[] arr , int i, int item){

        if(i== arr.length){
            return -1;
        }

        if(arr[i] == item){
            return i;
        }
        return FirstIndex(arr, i+1, item);
        

    }
    
}
