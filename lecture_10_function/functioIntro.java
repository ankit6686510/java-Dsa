public class functioIntro {
    public static void main(String[] args) {
        System.out.println("hey"); //hey
        int a =  9;
        int b = 7;
        int c = a +b;
        add();
        System.out.println(c);//16
    }
    public static void add(){
        int a = 11;
        int b = 17;
        int c= a+b;
        sub();//-6
        System.out.println(c);//28
    }
    public static void sub(){
        int a = 11;
        int b = 17;
        int c= a-b;
        System.out.println(c);  //-6
    }

}
// it will print
/*
 * hey
 * -6
 * 28
 * 16
 */