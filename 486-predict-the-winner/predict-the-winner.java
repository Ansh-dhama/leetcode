class Solution {
    Integer[][] memo;
    public boolean predictTheWinner(int[] nums) {
        memo = new Integer[nums.length][nums.length];
        return solve(0 , nums , nums.length-1) >=0;
    }
    private int solve(int left , int[] nums , int right){
        if(left > right) return 0;
if(memo[left][right] != null) return memo[left][right];
        int takeL = nums[left] -  solve(left+1 , nums, right);
        int takeR = nums[right] - solve(left , nums , right-1);

        return memo[left][right] =  Math.max(takeL , takeR);   
    }
}