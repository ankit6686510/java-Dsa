package lecture_7;

public class Binary_to_Decimal {
    public static void main(String[] args) {
        int n = 101101;
        int sum = 0;
        int mul = 1;
        while(n>0){
            int rem = n % 10;
            sum = sum +rem*mul;
            mul = mul * 2;
            n = n/10;


        }
        System.out.println(sum);
    }
}
