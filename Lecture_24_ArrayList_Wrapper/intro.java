package Lecture_24_ArrayList_Wrapper;

/**
 * This class demonstrates auto-boxing and unboxing in Java
 * along with Integer object comparison behavior
 */
public class intro {

    public static void main(String[] args) {
        // Primitive int vs Integer object
        Integer a1 = 10;
        int a = 10;
       
        // System.out.println(i1 == i2);

        // Integer objects for boxing/unboxing examples
        int b = 78;
        Integer b1 = 89;

        System.out.println("Integer value: " + b1);

        // Auto-boxing: automatic conversion of primitive to wrapper
        a1 = a; // autoboxing
        
        // Unboxing: automatic conversion of wrapper to primitive
        b = b1; // unboxing

        // Integer cache demonstration
        // Values between -128 to 127 are cached and reused
        Integer c1 = 10;
        Integer c2 = 10;
        System.out.println("c1 == c2 (10): " + (c1 == c2)); // true - cached values
        
        // Values outside cache range create new objects
        Integer c3 = 157;
        Integer c4 = 157;
        System.out.println("c3 == c4 (157): " + (c3 == c4)); // false - outside cache
    }
}

