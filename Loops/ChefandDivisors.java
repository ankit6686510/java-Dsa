public class ChefAndDivisors {
    public static void main(String[] args) {
        int n = 36;
        int count = 0;
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count += (i == n / i) ? 1 : 2;
            }
        }
        
        System.out.println(count);
    }
}
