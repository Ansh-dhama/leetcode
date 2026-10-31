class Solution {
    int count =0;
    int MOD = 1000_000_007;
    Integer[][] memo;
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        memo = new Integer[n][m];
       return  solve(grid , 0 , 0 , true);

    }
    private int solve(int[][] grid , int row , int col ,boolean down){
          int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || col < 0 || row > n-1 || col > m - 1) return 0;
if(memo[row][col] != null) return memo[row][col];
        if(row == n-1 && col == m-1) return 1 ;
       if(down && grid[row][col] ==1) return solve(grid, row, col+1 ,false);
       if(!down && grid[row][col] == 1) return solve(grid , row +1 ,col, true);
       int dos = solve(grid , row +1, col , true);

       int ri = solve(grid,row,col+1 , false);

       return memo[row][col] = (dos + ri) % MOD;
    }
}