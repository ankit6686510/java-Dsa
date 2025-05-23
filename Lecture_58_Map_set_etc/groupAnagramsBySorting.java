import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagramsBySorting {
     public List<List<String>> groupAnagrams(String[] strs) {
        // Step 1: Edge case check
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Step 2: Create HashMap to group anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Step 3: Traverse each string in input
        for (String str : strs) {
            // Step 3.1: Convert string to char array
            char[] charArr = str.toCharArray();

            // Step 3.2: Sort the char array
            Arrays.sort(charArr);

            // Step 3.3: Convert sorted char array back to string
            String sortedStr = new String(charArr);

            // Step 3.4: Use sorted string as key in HashMap
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            // Step 3.5: Add original string to the list
            map.get(sortedStr).add(str);
        }

        // Step 4: Return grouped anagrams as list of lists
        return new ArrayList<>(map.values());
    }
}
