import java.util.ArrayList;
import java.util.HashMap;
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class intersectionOfTwoArrays {
    class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersectionOfTwoArrays(nums1, nums2);
    }

    public static int[] intersectionOfTwoArrays(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count elements from arr1
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Check elements in arr2 against the map
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                list.add(arr2[i]);
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }

        // Convert list to array
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}

    
}
