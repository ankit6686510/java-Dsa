package Lecture_59_Hashmap;

public class IsomorphicString {
    //brute force
    public boolean isIsomorphic(String s, String t) {

        //brute force 
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            // Find first occurrence indices of ch1 in s and ch2 in t
            for (int j = 0; j < s.length(); j++) {
                if ((s.charAt(i) == s.charAt(j)) != (t.charAt(i) == t.charAt(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
