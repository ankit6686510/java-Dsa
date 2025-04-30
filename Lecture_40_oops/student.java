public class student {
    String name ; //class ka data member ya variable
    int age; //class ka data member ya variable

    // static int count;

    public void Intro_yourself(){ // class ka method ya function

        System.out.println("my name is " + this.name + " and age is " + this.age);
    }
    public void sayHey(String name){
        fun();
        System.out.println(name +" say hey " + this.name);

    }
    public static void fun(){
        // System.out.println(count);

        System.out.println("m mure maje m hu");
    }
    static {
        System.out.println(" aur bhai kya chal rha hai ");

    }
    static  {
        System.out.println("hello mitraa");
    }
}
