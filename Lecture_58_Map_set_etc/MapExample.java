import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        // Map<key, value> map = new HashMap<>();


        // Add key-value pairs
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("orange", 5);

        // Access a value by key
        System.out.println(map.get("banana")); // Output: 2

        // Check if key exists
        System.out.println(map.containsKey("apple")); // true

        // Remove a key
        map.remove("orange");

        // Iterate over keys and values
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
