package Lecture_24_ArrayList_Wrapper;
import java.util.ArrayList;

public class ArrayList_Working {
    public static void main(String[] args) {
        ArrayList<Integer> ll = new ArrayList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.add(2,-6);

        System.out.println(ll);
        //to get all the item we can do ll.get(1)..ll.get(2)....and so onn but we will use loop
        //bcz we are kalu kaaliya
        for(int i =0 ;i < ll.size();i++){
            System.out.print(ll.get(i) + " ");
        }

        //using for each loop
        System.out.println();
        for(int jomankareworkhlo : ll){
            System.out.print( jomankareworkhlo + " ");
            // System.out.print( System.lineSeparator()+ jomankareworkhlo + " ");
        }
            System.out.println();
        char[] a = {'a' ,'b','c'};
        for(char ch : a){
            System.out.print(ch + " ");
        }

    }

}
