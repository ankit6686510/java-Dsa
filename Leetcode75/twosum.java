public class twosum {
    class Pair implements Comparable<Pair> {
        //revise comaparable and comparator 
        int val;
        int idx;
        Pair(int val , int idx){
            this.val =  val;
            this.idx =  idx;
        }
        public int compareTo(Pair other){
            return this.val - other.val;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs =  new Pair[nums.length];
        for(int i = 0; i < nums.length ;i++){
            pairs[i] =  new Pair(nums[i], i);
        }

        Arrays.sort(pairs);

        int[] res =  new int[2];
        int li =  0;
        int ri = pairs.length - 1;

        while(li < ri){
            int left =  pairs[li].val;
            int right = pairs[ri].val;

            if(left + right < target){
                li++;
            } else if(left + right > target){
                ri--; 
            } else {
                res[0] = pairs[li].idx;
                res[1] = pairs[ri].idx;
                break;
            }
        }
        return res;
    }
}
