import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// https://leetcode.com/problems/group-anagrams/description/
public class groupAnagramsByFreq {
 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Check for empty input
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> freqstringmap = new HashMap<>();

        for (String str : strs) {
            String freqstring = getfreqstring(str); // Get frequency string

            // If frequency string already exists, add to the list
            if (freqstringmap.containsKey(freqstring)) {
                freqstringmap.get(freqstring).add(str);
            } else {
                // Create a new list and put it in map
                List<String> strlist = new ArrayList<>();
                strlist.add(str);
                freqstringmap.put(freqstring, strlist);
            }
        }

        return new ArrayList<>(freqstringmap.values());
    }

    private String getfreqstring(String str) {
        // Frequency bucket of 26 chars
        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        // Use StringBuilder to build unique key
        StringBuilder freqstring = new StringBuilder();

        char c = 'a';

        for (int i : freq) {
            freqstring.append(c);   // character
            freqstring.append(i);   // its count
            c++;
        }

        return freqstring.toString(); // fixed
    }
}
}
