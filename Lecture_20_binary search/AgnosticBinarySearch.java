public class AgnosticBinarySearch {
//     Agnostic ka matlab hota hai → "Order independent".

// Agnostic binary search: ✅ Ascending aur Descending dono tarike ki arrays par kaam karta hai

    public static int agnosticBinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        // Check array order
        boolean isAsc = arr[low] < arr[high];//checking the order that is ascending or descending

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;  // Target found
            }

            if (isAsc) {   // Ascending case
                if (target > arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {   // Descending case
                if (target > arr[mid]) {
                    high = mid - 1;  
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;  // Target not found
    }

    public static void main(String[] args) {
        int[] ascending = {10, 20, 30, 40, 50};
        int[] descending = {50, 40, 30, 20, 10};

        System.out.println(agnosticBinarySearch(ascending, 30));   // Output: 2
        System.out.println(agnosticBinarySearch(descending, 30));  // Output: 2
        System.out.println(agnosticBinarySearch(ascending, 100));  // Output: -1
    }
}
