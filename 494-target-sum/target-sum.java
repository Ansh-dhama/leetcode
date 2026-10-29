class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums , target , 0);
    }
    private int solve(int[] nums , int target , int index){
        if(index == nums.length) return target == 0 ? 1 : 0;

        int plus = solve(nums , target + nums[index] , index+1);

        int minus = solve(nums, target - nums[index] , index+1);
        return plus + minus;
    }
}