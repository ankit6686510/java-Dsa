import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class groupAnagramsBruteForce {
     public List<List<String>> groupAnagrams(String[] strs) {
        // Final result list of lists
        List<List<String>> result = new ArrayList<>();

        // Loop through each string in the input array
        for (String str : strs) {
            // Sort the characters of the string to get its "signature"
            String sortedStr = sortString(str);

            boolean added = false;

            // Try to find an existing group with the same sorted string
            for (List<String> group : result) {
                // Compare with first element of the group after sorting
                if (sortString(group.get(0)).equals(sortedStr)) {
                    group.add(str);  // If match found, add to this group
                    added = true;
                    break;
                }
            }

            // If no matching group found, make a new group
            if (!added) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                result.add(newGroup);
            }
        }

        return result;
    }

    // Helper function to return sorted version of a string
    private String sortString(String str) {
        char[] chars = str.toCharArray(); // Convert to char array
        Arrays.sort(chars);               // Sort the characters
        return new String(chars);         // Convert back to string
    }
}
