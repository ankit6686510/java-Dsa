import java.util.*;
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Step 1: Count frequencies of characters in magazine
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Try to use characters from the ransomNote

        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false; // Not enough characters
            }
            map.put(ch, map.get(ch) - 1); // Use 1 character
        }

        return true; // All characters matched
    }
}
