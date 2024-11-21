package Lecture4;

import java.util.Scanner;

public class primeNo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        scn.close();

        // Approach 1: Without `break`
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count >= 1) {
            System.out.println(n + " is not a prime number (Approach 1)");
        } else {
            System.out.println(n + " is a prime number (Approach 1)");
        }

        // Approach 2: Using `break`
        int countt = 0;
        for (int i = 2; i <n; i++) { 
            if (n % i == 0) {
                countt++;
                break;
            }
        }

        if (countt == 1) {
            System.out.println(n + " not a prime number (Approach 2)");
        } else {
            System.out.println(n + " is a prime number (Approach 2)");
        }
    }
}
