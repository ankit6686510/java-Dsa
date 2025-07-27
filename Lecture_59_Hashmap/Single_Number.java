package Lecture_59_Hashmap;

import java.util.HashMap;
import java.util.Map;

public class Single_Number {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1; // fallback in case no single element found
    }
}
//using xor 
/*
  int res  = 0;

        for(int num : nums){
            res = res ^ num;
        }
        return res;
        
 */

 //using set

 /*
  class Solution {
    public int singleNumber(int[] nums) {
        //using sum set approach

        //set bnaa lo 
        Set<Integer> set = new HashSet<>();

        int sum = 0 ,sumset = 0;

        //use formula 2* sumset -num - unique number

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumset += num;
            }
            sum += num;
        }
        return 2 * sumset - sum;

    }
}
  */