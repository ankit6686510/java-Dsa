package Lecture_24_ArrayList_Wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * This class demonstrates basic operations of ArrayList in Java
 */
public class ArrayList_intro {
    public static void main(String[] args) {
        // Initialize an ArrayList of Integer type
        ArrayList<Integer> list = new ArrayList<>();

        // Print empty list and its size
        System.out.println("Initial list: " + list);
        System.out.println("Initial size: " + list.size());
        
        // Add elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        
        System.out.println("List after adding elements: " + list);
        
        // Insert element at specific index
        // Note: valid range is 0 to size()
        list.add(2, -6);
        
        System.out.println("List after insertion at index 2: " + list);
        System.out.println("Final size: " + list.size());

        // System.out.println(list.get(6));//it will give index out of bond error bcz range 0 to size -1 tk lena h bss
        System.out.println(list.get(3)); //range from 0 to size-1;
        System.out.println(list);

        // Collections.sort(list); SORT KRNE K LIYE USE KRTE HAI

        Collections.reverse(list); //REVERSE KRNE K LIYE USE KRTE HAI
        System.out.println(list);


    }
}
