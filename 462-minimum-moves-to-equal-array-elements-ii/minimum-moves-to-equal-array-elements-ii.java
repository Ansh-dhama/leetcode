class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length /2;
        int mid =nums[n];
        int sum =0;
        for(int num : nums){          
            sum  += Math.abs((num - mid));
        }
      return sum;
    }
}