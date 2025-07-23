package Lecture_59_Hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection_of_two_array {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;

        Set<Integer> set = new HashSet<>();

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                set.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i] = num;
            i++;
        }
        return res;

    }
}
