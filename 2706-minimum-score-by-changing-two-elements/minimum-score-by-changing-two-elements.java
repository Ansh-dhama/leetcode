class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
      
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        

        ans = Math.min(ans , nums[n-1] - nums[2] );

        ans = Math.min(ans , nums[n-2] - nums[1]);

        ans = Math.min(ans , nums[n-3] - nums[0]);
       return ans;
    }
}
//1,4,5, 7, 8
