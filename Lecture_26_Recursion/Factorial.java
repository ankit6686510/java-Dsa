public class Factorial {
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorialofnumber(n));
    }

    public static int factorialofnumber(int n) {
        // Base case: factorial of 1 or 0 is 1
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // Recursive call
        int fn = factorialofnumber(n - 1);
        
        return n * fn;
    }
}
