    package lecture_11_Arrays;

    import java.util.Scanner;

    public class ArmstrongNuber {
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            // System.out.println(countdigit(n));
            System.out.println(is_armsstrong_number(n));
        }

        public static boolean is_armsstrong_number(int n) {
            int d = countdigit(n);
            int sum = 0;
            int p = n;
            while (n > 0) {
                int rem = n % 10;
                sum = (int) (sum + Math.pow(rem, d));
                n = n / 10;
            }
            if (sum == p) {
                return true;

            } else {
                return false;
            }

        }

        public static int countdigit(int n) {
            int count = 0;
            while (n > 0) {

                count++;
                n = n / 10;

            }
            return count;

        }

    }
