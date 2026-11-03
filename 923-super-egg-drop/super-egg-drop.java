class Solution {
    Integer[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new Integer[n+1][k+1];
        return solve(k , n);
    }
    private int solve(int k ,int n){
        if(n == 0 || n== 1) return n;
        if(memo[n][k] != null) return memo[n][k];
        if(k==1) return n;
 
        int ans = Integer.MAX_VALUE;

         int left = 1;
         int right = n;

         while(left<= right){
            int mid = left + (right - left)/2;

            int brea = solve(k-1 , mid - 1);
            int survive = solve(k , n-mid);

            ans = Math.min(ans , 1 + Math.max(brea , survive));

            if(brea > survive){
                right = mid -1;
            }else if(brea < survive){
                left = left+1;
            }
             else {
                break;
            }
         }
     
        return memo[n][k] = ans;
    }
}