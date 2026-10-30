class Solution {
    Integer[][] dp;
    public int minCost(int n, int[] cuts) {
        int number = cuts.length;

        int[] position = new int[number +2];

        for(int i = 0;i<number;i++){
            position[i+1] = cuts[i];
        }
        position[number+1] = n;

         dp = new Integer[number+2][number+2];
      Arrays.sort(position);
        return solve( 0, number + 1 , position);
    }
    private int solve(int left , int right , int[] position){
        if(right -  left == 1) return 0;
if(dp[left][right] != null) return dp[left][right];
        int minCost = Integer.MAX_VALUE;

        for(int i = left +1 ;i<right;i++){
            int currCost = position[right] - position[left];
            
            int l = solve(left , i , position );
            int r = solve(i , right ,position);

            currCost += r+l;

            minCost = Math.min(minCost , currCost);
        }
        return dp[left][right] = minCost;
    }
}