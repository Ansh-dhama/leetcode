class Solution {
    public boolean predictTheWinner(int[] nums) {
        return solve(0 , nums , nums.length-1) >=0;
    }
    private int solve(int left , int[] nums , int right){
        if(left > right) return 0;

        int takeL = nums[left] -  solve(left+1 , nums, right);
        int takeR = nums[right] - solve(left , nums , right-1);

        return Math.max(takeL , takeR);   
    }
}