class Solution {
    public int minFallingPathSum(int[][] grid) {
        int sum = Integer.MAX_VALUE;
         int n = grid.length;
         Integer[][] dp = new Integer[n][n];
        for(int i =0;i<n;i++){
            sum = Math.min(sum , dfs(grid , 0 ,i , dp));
        }
        return sum;
    }
    private int dfs(int[][] grid , int row , int col, Integer[][] dp){
        int n= grid.length;

        if (row == n - 1) return grid[row][col];

        if(dp[row][col] != null) return dp[row][col];

        int sum = Integer.MAX_VALUE ;

       
        for(int i = 0;i<n;i++){
            if(i != col){
            sum = Math.min(sum  , dfs(grid , row+1 ,i , dp));
         }
        }
        return dp[row][col] = grid[row][col] + sum;
    }
}