import java.util.*;
public class studentClient {
    public static void main(String[] args) {
        ArrayList<Integer> ll = new ArrayList<>();
        ll.add(10);
        ArrayList<Integer> lll = new ArrayList<>();
        lll.add(500);

        System.out.println("hello bhaiya kaa karat baaani");
        student s = new student();
        s.name = "ankit";
        s.age = 22;
        s.Intro_yourself();
        student s1 =  new student();
        s1.name = "jha";
        s1.age = 22;

        s1.Intro_yourself();
        s1.sayHey("ankit baabu");

        s.sayHey("ankit baabu");

        s.fun();
        s1.fun();


    }
    
}
