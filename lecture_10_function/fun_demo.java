public class fun_demo{
    public static void main(String[] args) {
        System.out.println("hey");
        int a  =9;
        int b = 7;
        int ans = Add(a,b);
        System.out.println(ans);

    }
    public static int Add(int a ,int b){
        int c = a+b;
        System.out.println(sub(c,a));
        return c ;
    }
    public static int sub(int a ,int b){
        return a-b;
    }
}
