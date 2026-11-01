class Solution {
Integer[][] memo;
    public int maxCoins(int[] nums) {
        int[] position = new int[nums.length+2];
        for(int i =0;i<nums.length;i++){
            position[i+1] = nums[i];
        }
        memo = new Integer[position.length][position.length];
        position[0] =1;
        position[nums.length+1] = 1;
        return solve(position , 0 , nums.length + 1 );
    }
    private int solve(int[] nums , int left , int right){
     if(right -left ==1) return 0;
     if(memo[left][right] != null) return memo[left][right];
       int ans = Integer.MIN_VALUE;
        for(int i =left+1;i<right;i++){
           
            int lC = solve(nums , left , i);
            int rc = solve(nums , i, right);
            int coin = nums[i] * nums[left] * nums[right];
            int curr  = coin + lC + rc;
            ans = Math.max(ans , curr);
            
        }
        return memo[left][right] = ans;
    }
}