class Solution {
    Integer[][] dp;
    public int lastStoneWeightII(int[] stones) {
       int sum = 0;
       
       for(int num : stones){
        sum += num;
       }
       int target = sum / 2 ;
       dp = new Integer[stones.length][target+1];
       int result =  solve(0 , target , stones);
    
       return sum - 2 * result;
    }

    private int solve(int index , int remain , int[] stones){
        if(index >= stones.length) return 0;
if(dp[index][remain] != null) return dp[index][remain];

        int notTake = solve(index + 1 , remain , stones);

        int take =0;

        if(stones[index]  <= remain){
            take = stones[index] + solve(index +1 , remain - stones[index] , stones);
        }

        return dp[index][remain] = Math.max(take , notTake);
    }
}