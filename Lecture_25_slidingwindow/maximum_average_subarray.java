public class maximum_average_subarray {

    //link  https://leetcode.com/problems/maximum-average-subarray-i/
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(maximumaverage(nums,k));

        
    }
    public static double maximumaverage(int[] nums, int k) {
        int sum = 0;
        for(int i  = 0; i < k ;i++){
            sum += nums[i];
        }
        int maxsum = sum;

        //start karo window ko
        int startidx = 0;
        int endidx = k;

        //work karo --> hamar work hai add and subtarct krna window mai pehlay window s remove hoga ad then add karenge
        while(endidx < nums.length){
            sum -= nums[startidx];
            startidx++;

            sum += nums[endidx];
            endidx++;

            //ans calculation

            maxsum = Math.max(maxsum ,sum);

        }
        //ans return kar do hamre case mai ans average nikalna thaa

            return(double)maxsum/k;


        
    }
}
