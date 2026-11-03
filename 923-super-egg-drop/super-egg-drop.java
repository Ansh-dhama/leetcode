class Solution {
    Integer[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new Integer[n+1][k+1];
        return solve(n, k);
    }
    private int solve(int n , int k ){
        if(n == 0 || n== 1) return n;
        if(k == 1 ) return n;
        if(memo[n][k] != null) return memo[n][k];
        int left = 1;
        int right = n;
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right -left)/2;

            int brea = solve(mid - 1 , k-1);
            int survive = solve(n - mid , k );

            ans = Math.min(ans,1 + Math.max(brea , survive));
            
            if(brea < survive){
                left = mid+1;
            }else if(survive < brea){
                 right = mid- 1;
            }else{
                break;
            }
        }

        return memo[n][k] = ans;
    }
}