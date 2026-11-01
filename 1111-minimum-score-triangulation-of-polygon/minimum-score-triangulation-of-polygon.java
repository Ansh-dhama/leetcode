class Solution {
    Integer[][] memo;
    public int minScoreTriangulation(int[] values) {
        memo = new Integer[values.length][values.length];
        return solve(values,0,values.length-1);
    }
    private int solve(int[] nums , int left , int right){
        if(right - left == 1) return 0 ;
if(memo[left][right] != null) return memo[left][right];




        int ans= Integer.MAX_VALUE;

        for(int i = left+1;i<right;i++){
            int lScore = solve(nums , left,i);
            int rScore = solve(nums , i , right);
            
            int score = nums[i] * nums[left] * nums[right];

            int curr = score + lScore + rScore;

            ans =Math.min(ans ,curr);
        }  
        return memo[left][right] = ans;
    }
}