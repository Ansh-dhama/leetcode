class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       boolean[][] visited = new boolean[n][m];
       int count =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    if(dfs(grid, i ,j ,visited)){
                    count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid , int i , int j ,boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || j< 0 || i>=n || j>=m) return false;

         if(grid[i][j]==1) return true;
         if(visited[i][j]) return true;

         visited[i][j] =true;
        boolean left =dfs(grid,i,j+1,visited);
        boolean right = dfs(grid,i , j-1,visited);
       boolean up =  dfs(grid,i+1,j,visited);
        boolean bottom = dfs(grid,i-1,j,visited);

        return left && right && up && bottom;
    }
}