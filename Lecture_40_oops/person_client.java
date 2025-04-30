public class person_client {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("hey");

        person p1 =  new person();
        System.out.println(p1);

        person p =  new person(10 , "samridhi");
        // person p1 =  new person(10 ,"mohini");

        p.Intro_yourself();
        System.out.println(p);

        //constructor
        Car c =  new Car("Red" , 800 , 9);
        c.color = "black";

        p1.fun();

        



    }
}
