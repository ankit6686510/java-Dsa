import java.util.HashMap;
import java.util.*;
package Lecture_59_Hashmap;

public class isomorphicString_HASHMAP {
    class Solution {
    public boolean isIsomorphic(String s, String t) {
        // base case check
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> charMappingMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!charMappingMap.containsKey(original)) {
                // check if replacement is already mapped to some other character
                if (charMappingMap.containsValue(replacement)) {
                    return false;
                }
                charMappingMap.put(original, replacement);
            } else {
                char mappedCharacter = charMappingMap.get(original);
                if (mappedCharacter != replacement) {
                    return false;
                }
            }
        }

        return true;
    }
}
}
