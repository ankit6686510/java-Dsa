public class prime_sieve {
    public static void main(String[] args) {
        primesieve(100);
        
    }
    public static void primesieve(int n){
        boolean[] prime  = new boolean[n+1];
        for(int i = 2 ;i < prime.length ; i++){
            prime[i] =  true; //by defalu boolean false marks kar deta hai

        }
        for(int i = 2 ; i*i < prime.length ;i++){
            if(prime[i] == true){
                for(int j =2 ; j*i < prime.length ;j++){
                    prime[i*j] = false;
                }
            }
        }

        for(int i  = 2; i< prime.length ; i++){
            if(prime[i] == true){
                System.out.println(i +" is a prime number");
            }
        }
  }

}
