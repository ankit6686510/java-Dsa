public class person{
    String name =  "Ankit";
    int age = 22;

    public void Intro_yourself(){
        System.out.println("my name is " + name + " and age is "+ age);
    }
    public void fun(){
        System.out.println("hey fun karo");
    }
    public person(){

    }
    public person(int age , String name){
        this.age  =  age;
        this.name =  name;
    }
    public static void main(String[] args) {
        person p = new person(25 ,"ankit");
        p.Intro_yourself();
    }

}