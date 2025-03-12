public class Maximum_Subbarray_using_Kadanes {
    public static void main(String[] args) {
        // int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] arr = { -2, -3,-1,-4 };
        int n = arr.length;
        System.out.println(maxsum(arr));
    }

    public static int maxsum(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}
