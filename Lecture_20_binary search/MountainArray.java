

// public class mountain_array {
//     public static void main(String[] args) {
//         int arr[]= {3,4,5,6,7,8,9,1,2};
//         System.out.println(peakIndexInMountainArray(arr));

        
//     }
//     public int peakIndexInMountainArray(int[] arr) {
//         int start = 0;
//         int end  =  arr.length-1;
        
//         while(start <end){
//             int mid =  start + (end-start)/2;
//             if(arr[mid ]> arr[mid+1]){
//                 //you are in dec part of array 
//                 //this may be the ans but we have too look at left
//                 //this is y end != mid-1;
//                 end = mid;
//             }else{
//                 //you are in inc part of array
//                 start = mid+1;//bevause mid+1 element is > mid element

//             }
//         }
//         //in the end start==mid and points to largest element due to 2 checks above
//         //start and end are always try to find maximum element in the abobe 2 checks
//         //hence ,   when they are ponting to just one element that is the maximum  element
//         return start;
        
//     }
// }

//upar waala non static method hai isliye run nhi karega but neeche waala static method run karega
public class MountainArray {
    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 6, 7, 8, 9, 1, 2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {  // Add "static"
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;  // Move to the left side
            } else {
                start = mid + 1;  // Move to the right side
            }
        }
        return start;
    }
}
