// public package Lecture_38_time_and_space_complex;

class power_logn {

    public static void main(String[] args) {
        int x = 3, n = 4;
        System.out.println(power(x, n));
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int ans = power(x, n / 2);
        ans = ans*ans;

        if (n % 2 != 0) {
            ans *= x;
        } 
        return ans;
    }
}