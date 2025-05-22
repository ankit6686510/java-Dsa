
import java.util.HashMap;
// https://leetcode.com/problems/longest-consecutive-sequence/

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] arr =  { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] arr){
        HashMap<Integer , Boolean> map =  new HashMap<>();
        for(int i = 0; i < arr.length ; i++){
            if(map.containsKey(arr[i] - 1)){
                map.put(arr[i] , false);//it has a previos -> not a start


            }else{
                map.put(arr[i], true);//assume it is a start
            }
            if(map.containsKey(arr[i] + 1)){
                map.put(arr[i] + 1, false);// next element can't be start
            }
        }
        int ans = 0;
        for(int key : map.keySet()){
            if(map.get(key)){
                int count = 0;
                while(map.containsKey(key)){
                    count++;
                    key++;
                }
                ans = Math.max(ans,count);
            }
            
        }
        return ans;

    }

}
    

