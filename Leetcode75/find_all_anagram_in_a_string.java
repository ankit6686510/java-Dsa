import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class find_all_anagram_in_a_string {
   
    public List<Integer> findAnagrams(String s, String p) {

        int[] pCount =  new int[26];
        int[]sCount = new int[26];
        List<Integer> result =  new ArrayList<>();

        //count freq of charc in p array
        for( char c : p.toCharArray()){
            pCount[c - 'a']++;
        }
         //sliding window to count freq of charcater in s

         for(int i = 0 ; i < s.length() ; i++){
            sCount[s.charAt(i) -'a']++;

            //remove the charcater that is out of window

            if(i >= p.length()){
                sCount[s.charAt(i - p.length()) - 'a']--;

            }
            //compare count

            if(Arrays.equals(pCount ,sCount)){
                result.add(i - p.length() + 1);
            }
         }
        return result;
    }
}

