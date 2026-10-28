class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
    
        boolean[][][] dp = new boolean[m][n][1024];
                dp[0][0][grid[0][0]] = true;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                for (int v = 0; v < 1024; v++) {
                    if (dp[r][c][v]) {
                        if (r + 1 < m) {
                            dp[r + 1][c][v ^ grid[r + 1][c]] = true;
                        }
                        if (c + 1 < n) {
                            dp[r][c + 1][v ^ grid[r][c + 1]] = true;
                        }
                    }
                }
            }
        }
        
        for (int v = 0; v < 1024; v++) {
            if (dp[m - 1][n - 1][v]) {
                return v;
            }
        }
        
        return 0; 
    }
}