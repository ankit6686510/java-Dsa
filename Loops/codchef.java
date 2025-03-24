import java.util.Scanner;

public class codchef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of cards
        int[] cards = new int[n];

        // Read the cards' values
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int left = 0, right = n - 1; // Pointers for the two ends
        int serejaScore = 0, dimaScore = 0; // Players' scores
        boolean isSerejaTurn = true; // To track whose turn it is

        while (left <= right) { // While there are cards left
            int pick;
            if (cards[left] >= cards[right]) {
                pick = cards[left]; // Pick from left
                left++; // Move left pointer inward
            } else {
                pick = cards[right]; // Pick from right
                right--; // Move right pointer inward
            }

            // Update scores based on whose turn it is
            if (isSerejaTurn) {
                serejaScore += pick; // Sereja's score
            } else {
                dimaScore += pick; // Dima's score
            }
            isSerejaTurn = !isSerejaTurn; // Alternate turn
        }

        System.out.println(serejaScore + " " + dimaScore); // Print final scores
        sc.close();
    }
}
