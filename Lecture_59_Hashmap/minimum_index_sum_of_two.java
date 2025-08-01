package Lecture_59_Hashmap;
import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/minimum-index-sum-of-two-lists/

public class minimum_index_sum_of_two {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        // store list1 strings with their indices
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        // check in list2
        for (int j = 0; j < list2.length; j++) {
            String word = list2[j];
            if (map.containsKey(word)) {
                int sum = j + map.get(word);
                if (sum < minIndexSum) {
                    result.clear(); // new smaller sum found
                    result.add(word);
                    minIndexSum = sum;
                } else if (sum == minIndexSum) {
                    result.add(word); // same min sum → add to list
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
