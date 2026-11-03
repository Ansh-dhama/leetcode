class Solution {
    Integer[][] memo;
    public int getMoneyAmount(int n) {
        memo = new Integer[n+1][n+1];
        return solve(1, n);
    }
    private int solve(int left , int right ){
        if(left >= right )return 0;
        if(memo[left][right]!= null) return memo[left][right];
       int ans = Integer.MAX_VALUE;
        for(int mid = left ;mid<= right ;mid++){
            int win = solve(mid+1 , right);
            int loss= solve(left , mid -1);

            ans = Math.min(ans , mid + Math.max(win , loss));
    
        }
        return memo[left][right] =ans;
    }
}