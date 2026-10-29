class Solution {
    int MOD = 1000_000_007;
    Integer[][] memo;
    public int numRollsToTarget(int n, int k, int target) {
        memo = new Integer[n][target+1];

        return (int) solve(0 , n,k,target) % MOD ;
    }
    private long solve(int index , int n , int k ,int target){


        if (target < 0) return 0;

        if(index == n) return target == 0 ? 1 : 0;

        if(memo[index][target] != null) return memo[index][target];
        
        int remain = n - index;

        if(target < remain || target > (long)remain * k) return 0;
        
        long take =0;

        for(int i =1;i<=k;i++){
           take += solve(index +1 ,n , k, target - i);
           take = take % MOD;
        }
        return memo[index][target] =  (int) take % MOD;
       
    }
}