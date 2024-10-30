package BasicsIntro;
import java.util.Scanner;

public class DataTypeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Primitive Data Types
        byte age = 25;
        short year = 2024;
        int distance = 3000;       // in meters
        long population = 8000000L;
        float height = 5.9f;       // in feet
        double weight = 75.8;      // in kg
        char grade = 'A';
        boolean isEligible = true;

        // Printing initial values
        System.out.println("Initial Values:");
        System.out.println("Age: " + age);
        System.out.println("Year: " + year);
        System.out.println("Distance: " + distance + " meters");
        System.out.println("Population: " + population);
        System.out.println("Height: " + height + " feet");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Grade: " + grade);
        System.out.println("Eligibility: " + isEligible);
        System.out.println();

        // Logic: Checking if eligible for a job based on age
        System.out.print("Enter your age: ");
        age = scanner.nextByte();
        if (age >= 18) {
            isEligible = true;
            System.out.println("You are eligible to apply for the job.");
        } else {
            isEligible = false;
            System.out.println("You are not eligible to apply for the job.");
        }

        // Logic: Calculating BMI
        System.out.print("Enter your weight (kg): ");
        weight = scanner.nextDouble();
        System.out.print("Enter your height (meters): ");
        height = scanner.nextFloat();
        double bmi = weight / (height * height);
        System.out.printf("Your BMI: %.2f\n", bmi);

        // Checking health status based on BMI
        String healthStatus;
        if (bmi < 18.5) {
            healthStatus = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            healthStatus = "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            healthStatus = "Overweight";
        } else {
            healthStatus = "Obese";
        }
        System.out.println("Health Status: " + healthStatus);

        // Logic: Calculating monthly population growth based on growth rate
        double growthRate = 1.2; // in percentage
        long newPopulation = (long) (population + (population * growthRate / 100));
        System.out.println("Projected population for next month: " + newPopulation);

        // Character and ASCII code demonstration
        System.out.print("Enter a character: ");
        grade = scanner.next().charAt(0);
        int asciiValue = (int) grade; // Explicit casting
        System.out.println("ASCII value of '" + grade + "': " + asciiValue);

        // Checking if a number is odd or even
        System.out.print("Enter a number to check if it's even or odd: ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

        scanner.close();
    }
}


// //Here are some common interview questions on **data types** and
// **variables** in Java. These questions are great for testing your
// understanding of Java’s memory management, variable types, and nuances of
// data handling.

// ### Interview Questions on Data Types and Variables

// 1. **What are the primary data types in Java, and how are they categorized?**
// - Expected Answer: Java data types are categorized into two main types:
// *primitive types* (byte, short, int, long, float, double, char, boolean) and
// *reference types* (such as classes, interfaces, arrays).

// 2. **Explain the difference between `int` and `Integer` in Java.**
// - Expected Answer: `int` is a primitive data type that holds a 32-bit
// integer, whereas `Integer` is a wrapper class that wraps the `int` value in
// an object. `Integer` allows null values, and it provides utility methods,
// like `parseInt`.

// 3. **What is the default value of a variable that is declared but not
// initialized in Java?**
// - Expected Answer: For primitive data types, the default values are:
// - `byte`, `short`, `int`, `long` - `0`
// - `float`, `double` - `0.0`
// - `char` - `'\u0000'`
// - `boolean` - `false`
// - For reference types, the default value is `null`.

// 4. **What’s the difference between `float` and `double` in Java?**
// - Expected Answer: Both are used for decimal values, but `float` is a
// single-precision 32-bit IEEE 754 floating point, whereas `double` is a
// double-precision 64-bit IEEE 754 floating point. `double` is more precise and
// is the default for decimal values.

// 5. **Why does Java have a `boolean` type instead of using `int` like C/C++?**
// - Expected Answer: Java enforces type safety and readability by having a
// dedicated `boolean` type for true/false values, rather than allowing integers
// for logical values. This avoids potential errors and makes the code more
// readable.

// 6. **Can you assign a double to an `int` variable directly? Why or why not?**
// - Expected Answer: No, because `double` has a higher precision and a larger
// range than `int`. Assigning a `double` to an `int` would require explicit
// casting (`(int) myDouble`) which might lead to data loss.

// 7. **What is type casting in Java? Explain the difference between implicit
// and explicit casting.**
// - Expected Answer: Type casting is converting a variable from one data type
// to another. *Implicit casting* (widening) occurs automatically when moving to
// a larger type (e.g., `int` to `long`). *Explicit casting* (narrowing)
// requires the cast operator (e.g., `(int) myDouble`) and may result in data
// loss.

// 8. **How does Java handle overflow for primitive data types like `int`?**
// - Expected Answer: When an integer exceeds its max or min limit (e.g., adding
// 1 to `Integer.MAX_VALUE`), it wraps around to the opposite limit. This is
// called integer overflow.

// 9. **What’s the difference between `final` and `const` in Java?**
// - Expected Answer: Java doesn’t use `const` as in other languages. Instead,
// it has the `final` keyword to declare constants. `final` variables can only
// be assigned once, making them immutable.

// 10. **Explain the difference between `static` and `instance` variables.**
// - Expected Answer: `static` variables belong to the class and are shared
// across all instances, while instance variables are specific to each instance
// of a class. `static` variables are initialized once and stored in the class
// area, whereas instance variables are stored in the heap with each object.

// 11. **What is variable shadowing, and can you give an example?**
// - Expected Answer: Variable shadowing occurs when a variable declared within
// a scope (like a method or constructor) has the same name as a variable in an
// outer scope. The inner variable "shadows" the outer one, so the inner
// variable is used within that scope.

// ```java
// class Example {
// int x = 10; // Outer variable

// void display() {
// int x = 20; // Inner variable shadows the outer x
// System.out.println(x); // Prints 20
// }
// }
// ```

// 12. **Why does Java use `String` as a non-primitive data type while some
// other languages use it as a primitive?**
// - Expected Answer: Java treats `String` as a non-primitive type because it
// allows for immutability, supports methods, and gives more flexibility by
// being part of the `java.lang` package, which enhances performance and
// security.

// ### Coding Practice
// 1. Write a program to demonstrate implicit and explicit casting in Java.
// 2. Create a class with both `static` and instance variables, then demonstrate
// the difference by creating multiple instances of the class.