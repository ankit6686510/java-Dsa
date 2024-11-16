import java.util.Scanner;

public class PetrAndCalendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int daysInMonth = sc.nextInt(); // Days in the month
        int startDay = sc.nextInt(); // Starting day of the week (1 = Monday)

        // Print initial spaces for the first week
        for (int i = 1; i < startDay; i++) {
            System.out.print("   "); // Print spaces for days before the start day
        }

        // Loop through the days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day); // Print the day
            if ((day + startDay - 1) % 7 == 0) {
                System.out.println(); // Start a new line after each week
            }
        }

        System.out.println(); // Print a new line at the end
        sc.close();
    }
}
