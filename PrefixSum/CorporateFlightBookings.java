package PrefixSum;

import java.util.Arrays;

public class CorporateFlightBookings {
    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;

        // Correct way to print array
        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        // Final answer array (initially sab flights pe 0 booking)
        int[] ans =  new int[n];

        // Har booking ko process karenge
        for(int i = 0; i < bookings.length; i++) {
            int first = bookings[i][0];  // booking start flight number
            int last = bookings[i][1];   // booking end flight number
            int seats = bookings[i][2];  // seats booked from first to last flight

            // Difference array approach:
            // start index pe +seats karo
            ans[first - 1] += seats;

            // end+1 index pe -seats karo (taaki prefix sum ke baad range limit ho)
            if(last < n) ans[last] -= seats;
        }

        // Prefix sum step: har index pe pichle index ka sum add karte chalo
        // Taaki difference array actual seat count mein convert ho jaye
        for(int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }

        // Final ans[] array mein har flight ke liye booked seats aagayi
        return ans;
    }
}
