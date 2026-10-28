class Solution {
    Integer[][][] memo;
        int NEG = -1_000_000;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

         memo = new Integer[n][n][m]; 
         return Math.max(0 , (solve(0 ,0,0,grid)));
    }
    private int solve(int r1 ,int c1, int r2 , int[][] grid){
          int n = grid.length;
        int m = grid[0].length;
        int c2 = r1 + c1 - r2;

        if(r1 > n-1 || c1 > m-1 || c2 > m-1|| r2 > n-1) return NEG;
        
        if(grid[r1][c1] == -1 || grid[r2][c2] == -1) return NEG;
       if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if(memo[r1][r2][c1] != null) return  memo[r1][r2][c1];
        int cherry = grid[r1][c1];

        if(r1 != r2 || c1 != c2 ){
            cherry += grid[r2][c2];
        }
        int best = Math.max(
            Math.max(solve(r1+1 , c1 , r2+1,grid) , solve(r1+1 , c1 , r2,grid)) , 
            Math.max(solve(r1 , c1 +1 , r2 +1 , grid) , solve(r1,c1+1 , r2 , grid))
        );
         if (best == NEG) {
            return memo[r1][r2][c1] = NEG;
        }

        return memo[r1][r2][c1] = cherry + best; 
    }
} 