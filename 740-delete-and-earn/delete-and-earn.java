class Solution {
    // int[] points;
    // Integer[] memo;
    // public int deleteAndEarn(int[] nums) {
    //     int max = 0;

    //     for(int num : nums){
    //         max = Math.max(max , num);
    //     }

    //     points = new int[max+1];
    //    memo = new Integer[max+1];
    //     for(int num : nums){
    //         points[num] += num;
    //     }
    //     for(int num : points){
    //         System.out.println(num);
    //     }
    //     return solve(0);
    // }
    // private int solve(int value){
    //     if(value >= points.length) return 0;
    //     if(memo[value]!= null) return memo[value];
    //     int take = points[value] + solve(value+2);
    //     int notTake = solve(value+1);

    //     return memo[value] = Math.max(take , notTake);

    // }
    public int deleteAndEarn(int[] nums) {
          int max = 0;

        for(int num : nums){
            max = Math.max(max , num);
        }
        int[] points = new int[max+1];

        for(int num : nums){
            points[num] += num;
        }
        
        int[] dp = new int[max+1];
        dp[0] = points[0];
        dp[1] = points[1];

        for(int i =2;i<=max;i++){
           dp[i] =  Math.max(dp[i-1],dp[i-2]+ points[i]);
        }
    
        return dp[max];
    }

}