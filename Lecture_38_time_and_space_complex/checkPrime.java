public class checkPrime {

    public static void main(String[] args) {
        System.out.println(isprime(5));
    }
    public static boolean isprime(int n){
        int div = 2;
        while(div*div <= n){ // div square less than under root n
            if(n % div == 0){
                return false;
            }
            div++;  
        }
        return true;
    }
    
}