class Solution {
    // public int maxProfit(int[] prices) {
    //     int buy1 = Integer.MIN_VALUE;
    //     int profit1 = 0;
    //     int buy2 = Integer.MIN_VALUE;
    //     int profit2 =0;

    //     for(int num : prices){
    //         buy1 = Math.max(buy1, -num);
    //         profit1 = Math.max(profit1  , buy1 + num);
    //         buy2 = Math.max(buy2 , profit1 - num);
    //         profit2 = Math.max(profit2 , buy2 + num); 
    //     }
    //     return profit2;
    // }
    Integer[][]memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new Integer[n][4];
       return solve(0,0,prices);
    }
    private int solve(int index , int trans , int[] prices){
        if(index >= prices.length || trans == 4) return 0;
      if( memo[index][trans] != null) return  memo[index][trans];
        int take = 0;

        if(trans % 2 == 0){
            take = -prices[index] + solve(index+1 , trans+1 , prices);
        }else{
            take = prices[index]+ solve(index+1 ,trans+1 , prices);
        }

        int notTake = solve(index +1 ,trans , prices);
       
       return memo[index][trans] = Math.max(take  , notTake);
    }
}
