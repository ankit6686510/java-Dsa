public class NotelockTest {
    
    // Test method using the same logic as main solution
    public static int minProtections(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[] protected_pos = new boolean[n];
        int protections = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') {
                if (canBeChanged(arr, protected_pos, i, k)) {
                    protected_pos[i] = true;
                    protections++;
                }
            }
        }
        
        return protections;
    }
    
    private static boolean canBeChanged(char[] arr, boolean[] protected_pos, int pos, int k) {
        if (protected_pos[pos]) {
            return false;
        }
        
        int start = Math.max(0, pos - k + 1);
        for (int i = start; i < pos; i++) {
            if (arr[i] == '1') {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // Test cases from the example
        String[] testStrings = {
            "11",           // n=2, k=2, expected: 1
            "100001",       // n=6, k=6, expected: 1
            "10000",        // n=5, k=3, expected: 1
            "1010101",      // n=7, k=2, expected: 4
            "0000001",      // n=7, k=4, expected: 1
            "010",          // n=3, k=3, expected: 1
            "011",          // n=3, k=2, expected: 1
            "1001001",      // n=7, k=4, expected: 1
            "00000000"      // n=8, k=3, expected: 0
        };
        
        int[] kValues = {2, 6, 3, 2, 4, 3, 2, 4, 3};
        int[] expected = {1, 1, 1, 4, 1, 1, 1, 1, 0};
        
        System.out.println("Testing Notelock solution:");
        System.out.println("==========================");
        
        for (int i = 0; i < testStrings.length; i++) {
            int result = minProtections(testStrings[i], kValues[i]);
            String status = (result == expected[i]) ? "PASS" : "FAIL";
            
            System.out.printf("Test %d: s=%s, k=%d -> Result: %d, Expected: %d [%s]\n", 
                            i+1, testStrings[i], kValues[i], result, expected[i], status);
        }
        
        // Additional detailed analysis for key test cases
        System.out.println("\nDetailed Analysis:");
        System.out.println("==================");
        
        // Test case 1: "11", k=2
        System.out.println("\nTest 1: s=\"11\", k=2");
        System.out.println("- Position 0: '1' can be changed (no previous elements), needs protection");
        System.out.println("- Position 1: '1' cannot be changed (position 0 has '1' in previous k-1=1 elements)");
        System.out.println("- Result: 1 protection needed");
        
        // Test case 2: "100001", k=6  
        System.out.println("\nTest 2: s=\"100001\", k=6");
        System.out.println("- Position 0: '1' can be changed, needs protection");
        System.out.println("- Position 5: '1' cannot be changed (position 0 has '1' in previous k-1=5 elements)");
        System.out.println("- Result: 1 protection needed");
        
        // Test case 4: "1010101", k=2
        System.out.println("\nTest 4: s=\"1010101\", k=2");
        System.out.println("- Position 0: '1' can be changed, needs protection");
        System.out.println("- Position 2: '1' can be changed (position 1 is '0'), needs protection");
        System.out.println("- Position 4: '1' can be changed (position 3 is '0'), needs protection");
        System.out.println("- Position 6: '1' can be changed (position 5 is '0'), needs protection");
        System.out.println("- Result: 4 protections needed");
    }
}
