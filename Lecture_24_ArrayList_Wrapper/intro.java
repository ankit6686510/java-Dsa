package Lecture_24_ArrayList_Wrapper;

public class intro {

    public static void main(String[] args) {
        Integer a1 = 10;
        int a = 10;
       
        // System.out.println(i1 == i2);

        int b = 78;
        Integer b1 = 89;

        System.out.println(b1);

        a1 = a; //autoboxing
        b = b1;//unboxing

        Integer c1 = 10;
        Integer c2 = 10;
        System.out.println(c1 == c2); //true
        Integer c3 = 157;
        Integer c4 = 157;
        System.out.println(c3 == c4);//false
        
        }
    }

