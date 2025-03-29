import java.util.Scanner;
//https://code-gym.codingblocks.com/problems/446
public class KartikBhaiyaAndStrings {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        String s = scn.next();

        // Calling the function with correct case
        int flip_a = maxLenString(s, 'a', k);
        int flip_b = maxLenString(s, 'b', k);

        // Printing the max perfectness
        System.out.println(Math.max(flip_a, flip_b));
        
        scn.close();  // Close the scanner to avoid memory leaks
    }

    // Method to find max perfectness
    public static int maxLenString(String str, char ch, int k) {
        int si = 0;            // Start of sliding window
        int ei = 0;            // End of sliding window
        int ans = 0;           // Maximum length
        int flip = 0;          // Number of flips

        while (ei < str.length()) {
            // Expand window
            if (str.charAt(ei) == ch) {
                flip++;
            }

            // Shrink window if flip > k
            while (flip > k && si <= ei) {
                if (str.charAt(si) == ch) {
                    flip--;
                }
                si++;
            }

            // Calculate the max length
            ans = Math.max(ans, ei - si + 1);

            // Move the end pointer
            ei++;
        }

        return ans;
    }
}
