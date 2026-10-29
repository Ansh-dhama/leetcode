class Solution {
    // int[][] memo;
    // public int change(int amount, int[] coins) {
    //     memo = new int[coins.length][amount+1];
    //     for(int[] row : memo) Arrays.fill(row , -1);
    //     return solve(amount , coins,0);
    // }
    // private int solve(int amount , int[] coins , int index){
    //     if(index >= coins.length) return 0;
    //     if(amount<0) return 0;
    //     if(amount == 0) return 1;
    //      if(memo[index][amount]!= -1) return memo[index][amount];
    //     int take =0;
    //     if(coins[index] <= amount){
    //         take = solve(amount - coins[index] , coins , index);
    //     }
    //     int notTake = solve(amount , coins , index+1);

    //     return memo[index][amount]=  (take + notTake);
    // }


    public int change(int amount, int[] coins){
          
          int[] dp = new int[amount+1];

          dp[0] =1;

          for(int num : coins){
              for(int i = num;i<= amount;i++){
                 dp[i] += dp[i-num];
              }
          }
          return dp[amount];

     }
}