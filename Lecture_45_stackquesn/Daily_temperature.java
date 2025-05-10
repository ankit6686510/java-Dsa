import java.util.Stack;

public class Daily_temperature {
  public static void main(String[] args) {
      int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
      int[] ans = dailyTemperatures(arr);
      for (int i = 0; i < ans.length; i++) {
          System.out.print(ans[i] + " ");
      }
  }
  public static int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] ans = new int[n];           // Final answer array: kitne din baad temp badhega
    Stack<Integer> st = new Stack<>(); // Stack to store indices, not values

    for (int i = 0; i < n; i++) {
        // Jab tak stack khali nahi ho jata aur current temp stack ke top wale se bada hai
        while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
            int prevIndex = st.pop();           // us purane din ka index nikaal lo
            ans[prevIndex] = i - prevIndex;     // difference = current day - previous day
        }
        st.push(i); // current index stack mein daal do
    }

    return ans;
}

}
