// import java.util.Scanner;

public class intro {    
    public static void main(String[] args) {
        String str = "hello";
        String str1 = new String("hello");
        String str2 = "hello";
        String str3 = new String("hello");

        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str.length());
        System.out.println(str.charAt(2));
        String s1 = "hey";
        String s2 = "bey";
        s1 = s1 + s2; //concatenation heap memory is allocated and then copied in stack memory no pool memory is used here. it is not a constant pool memory.
        System.out.println(s1);

        s1 = s1.concat(s2);
        System.out.println(s1);

    }
}