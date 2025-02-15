package sorting;

public class insertion_sort {
    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        insertionsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionsort(int arr[]) {
        // first element ko sorted assume karnege due to which loop 1 s start karenge
        for (int i = 1; i < arr.length; i++) {
            int picked = arr[i];// hand picked card
            int j = i - 1;
            while (j >= 0 && arr[j] > picked) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = picked;

        }
    }
}
//time complexities 
//worst case O(n2)--> n is the element of array (isme hme descending order m aggr array milgya to)
//best case O(n) --> linear search for sorted array