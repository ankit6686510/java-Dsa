package Lecture_24_ArrayList_Wrapper;

import java.util.ArrayList;

public class Add_two_Number {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 6};
        int[] arr2 = {8, 3, 5, 3, 4, 7, 6};

        ArrayList<Integer> result = AddNumber(arr1, arr2);

        // Print the result
        System.out.print("Sum: ");
        for (int k = result.size() - 1; k >= 0; k--) {
            System.out.print(result.get(k) + " ");
        }
    }

    public static ArrayList<Integer> AddNumber(int[] arr1, int[] arr2) {
        ArrayList<Integer> ll = new ArrayList<>();
        int i = arr1.length - 1;
        int j = arr2.length - 1;

        int carry = 0;

        // Adding common length digits
        while (i >= 0 && j >= 0) {
            int sum = arr1[i] + arr2[j] + carry;
            ll.add(sum % 10);
            carry = sum / 10;    // ✅ Correct carry calculation
            i--;
            j--;
        }

        // Adding remaining digits of arr1
        while (i >= 0) {
            int sum = arr1[i] + carry;   // ✅ Correct indexing
            ll.add(sum % 10);
            carry = sum / 10;
            i--;
        }

        // Adding remaining digits of arr2
        while (j >= 0) {
            int sum = arr2[j] + carry;   // ✅ Correct indexing
            ll.add(sum % 10);
            carry = sum / 10;
            j--;
        }

        // Adding final carry
        if (carry > 0) {
            ll.add(carry);
        }

        return ll;
    }
}
