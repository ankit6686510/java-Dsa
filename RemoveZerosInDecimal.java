public class RemoveZerosInDecimal {
    
    /**
     * Removes all zeros from the decimal representation of a positive integer.
     * 
     * @param n The positive integer
     * @return The integer obtained by removing all zeros
     */
    public static long removeZeros(long n) {
        // Convert number to string
        String numStr = String.valueOf(n);
        
        // StringBuilder to build result without zeros
        StringBuilder result = new StringBuilder();
        
        // Iterate through each character and skip zeros
        for (char ch : numStr.toCharArray()) {
            if (ch != '0') {
                result.append(ch);
            }
        }
        
        // Convert back to long and return
        return Long.parseLong(result.toString());
    }
    
    // Alternative one-liner solution using replace
    public static long removeZerosAlternative(long n) {
        return Long.parseLong(String.valueOf(n).replace("0", ""));
    }
    
    public static void main(String[] args) {
        // Test case 1
        long n1 = 1020030;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + removeZeros(n1));
        System.out.println("Expected: 123");
        System.out.println();
        
        // Test case 2
        long n2 = 1;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + removeZeros(n2));
        System.out.println("Expected: 1");
        System.out.println();
        
        // Additional test cases
        long n3 = 1000000;
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + removeZeros(n3));
        System.out.println("Expected: 1");
        System.out.println();
        
        long n4 = 9876543210L;
        System.out.println("Input: n = " + n4);
        System.out.println("Output: " + removeZeros(n4));
        System.out.println("Expected: 987654321");
        System.out.println();
        
        // Test alternative method
        System.out.println("Testing alternative method:");
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + removeZerosAlternative(n1));
        System.out.println("Expected: 123");
    }
}
