class Solution {
    //  int count =0;
    // Integer[][] memo;
    // int MOD = 1000_000_007;
    // public int numberOfPaths(int[][] grid, int k) {
    //      int n = grid.length;
    //     int m = grid[0].length;
    //     memo = new int[n][m];
    //     solve(0,0,grid,k,0);
    //     return count;
    // }
    // private void solve(int row , int col , int[][] grid , int k , int sum){
    //     int n = grid.length;
    //     int m = grid[0].length;

    //     if(row < 0 || col < 0 || row > n-1 || col > m-1 )return;

    //     if(row == n - 1 && col == m-1){
    //         sum += grid[row][col];
    //         if(sum % k ==0){
    //             count = (count + 1 ) % MOD;
    //         }
    //         return;
    //     }

    //      solve(row , col + 1 , grid, k , sum + grid[row][col]);
    //      solve(row + 1 , col  , grid, k , sum + grid[row][col]);

    // }

    Integer[][][] memo;
    int MOD = 1000_000_007;
    public int numberOfPaths(int[][] grid, int k) {
         int n = grid.length;
        int m = grid[0].length;
        memo = new Integer[n][m][k];
       return  solve(0,0,grid,k,0);
      
    }
    private int solve(int row , int col , int[][] grid , int k , int rem ) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || col < 0 || row > n-1 || col > m-1 )return 0;
     
        if(memo[row][col][rem] != null) return memo[row][col][rem];

        int nextRem = (rem + grid[row][col] ) % k;
        if(row == n-1 && col == m-1)return memo[row][col][rem] = (nextRem == 0) ? 1 : 0;

        int right =  solve(row , col + 1 , grid, k ,nextRem);
        int down =  solve(row + 1 , col  , grid, k ,nextRem);
        
        return memo[row][col][rem] = (right + down) % MOD;
    }
}