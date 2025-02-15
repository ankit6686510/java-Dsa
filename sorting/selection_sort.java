package sorting;

public class selection_sort {
    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        selectionsort(arr);
        for(int i = 0 ; i <arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void selectionsort(int arr[]){
          for(int i = 0 ; i <arr.length; i++){
            int mini =  i ;//index
            for(int j = i+1; j <arr.length ; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;


        }

    }
}
