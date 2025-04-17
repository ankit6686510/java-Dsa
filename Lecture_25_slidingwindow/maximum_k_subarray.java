public class maximum_k_subarray  // if file name is maximum_k_subarray.java
{
    //https://leetcode.com/problems/subarray-product-less-than-k/
    //to find=> k size k uss subarry ka sum jo maximum ho
    public static void main(String[] args) {
        int[] arr= {2,1,3,4,5,6,7,8,9,2,3};
        int k  = 3;
        System.out.println(maxsum_of_size_k(arr, k));
       
    }
    public static int maxsum_of_size_k(int[] arr,int k){
        //1st window ka sum
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < k ;i++){
            sum += arr[i];
        }
        ans = sum;
        for(int i  = k;i <arr.length;i++){
            sum += arr[i];
            sum -= arr[i-k];
            ans = Math.max(ans,sum);
        }
        return ans;

    }
}