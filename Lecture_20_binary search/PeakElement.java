public class PeakElement {

    // Method to find the peak element in mountain array
    public static int getPeakElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Increasing part → Move right
                low = mid + 1;
            } else {
                // Decreasing part → Move left
                high = mid;
            }
        }
        // When low == high, we have found the peak
        return low;
    }

    public static void main(String[] args) {
        int[] mountainArr = {1, 3, 5, 7, 6, 4, 2};

        int peakIndex = getPeakElement(mountainArr);

        System.out.println("Peak Index: " + peakIndex);     // Output: 3
        System.out.println("Peak Element: " + mountainArr[peakIndex]);  // Output: 7
    }
}
