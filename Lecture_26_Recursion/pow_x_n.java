public class pow_x_n {
    public static void main(String[] args) {
        int x = 4;
        int n =5;
        System.out.println(pow(x,n));
    }
    public static int pow(int x,int n){
        if(n==0){
            return 1;
        }
        int ans = pow(x,n-1);
        return x*ans;
    }
    
}
