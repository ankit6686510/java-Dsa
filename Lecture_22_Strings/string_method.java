public class string_method {
    public static void main(String[] args) {
        String str =  "hello";
        String str1 = new String("hello");
        String str2  =  "hello";
        String str3  =  new String("hello");

        System.out.println(str == str1);//false           
        System.out.println(str2 == str);//true
        System.out.println(str3 == str1);//false

    }
}
