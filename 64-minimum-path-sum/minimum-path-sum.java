class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;

        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for(int i =1;i<n;i++){
            for(int j=1;j<m;j++){

                dp[i][j] = (grid[i][j]+ Math.min(dp[i-1][j] , dp[i][j-1]));
            }
        }
        return dp[n-1][m-1];
        // return solve(0,0,grid);
    }
    private int solve(int row , int col , int[][] grid){
        int m = grid[0].length;
        int n = grid.length;

        if(row > n-1 || col > m-1 ) return Integer.MAX_VALUE/2;
        if(row == n-1 && col == m-1) return grid[row][col];
        int right =  grid[row][col] + solve(row  ,col+1 ,grid);
        int down =  grid[row][col] + solve(row+1 , col , grid);
        return Math.min(right , down);

    }
}