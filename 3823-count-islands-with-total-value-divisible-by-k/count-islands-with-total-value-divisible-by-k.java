class Solution {
    public int countIslands(int[][] grid, int k) {
        int count =0;

        int n = grid.length;
        int m = grid[0].length;

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] != 0){
                    if(dfs(grid , i ,j) % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private long dfs(int[][] grid , int row , int col ){
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || col < 0 || row > n-1 || col > m-1 || grid[row][col]==0)return 0;

        long sum = 0;
        sum += grid[row][col];

        grid[row][col] = 0;

        sum +=   dfs(grid, row +1 , col) +
         dfs(grid , row , col+1) + 
         dfs(grid, row -1 , col) + 
         dfs(grid , row, col-1 );

        return sum;
    }
}