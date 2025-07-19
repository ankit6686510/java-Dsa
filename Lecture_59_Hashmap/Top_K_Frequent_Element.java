package Lecture_59_Hashmap;

import java.util.*;

public class Top_K_Frequent_Element {

    public int[] topKFrequent(int[] nums, int k) {

    
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            // Increase the count for num
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a Min Heap to keep track of top K frequent elements
        // Heap stores Map.Entry where key = number, value = frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue() // sort by frequency (min heap)
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);

            // If heap size exceeds k, remove the element with lowest frequency
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract top K elements from the heap
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }

        return result;
    }

}
