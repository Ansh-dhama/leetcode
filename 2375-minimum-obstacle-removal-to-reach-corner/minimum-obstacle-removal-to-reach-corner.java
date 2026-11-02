class Solution {
    public int minimumObstacles(int[][] grid) {
    int  n = grid.length;
    int m = grid[0].length;

    int[][] dist = new int[n][m];
int[][] dir = {
    {1,0},
    {0,1},
    {-1,0},
    {0,-1}
};
    for(int[] row : dist){
        Arrays.fill(row , Integer.MAX_VALUE);
    }

    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[2] - b[2]);
        queue.offer(new int[]{0,0,0});
     dist[0][0] =0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int cost = curr[2];

            if(cost > dist[row][col] ) continue;
      if(row  == n-1 && col == m-1) return cost;
            for(int[] d : dir){
                int nr = d[0]+row;
                int nc = d[1] +col;

                if(nr < 0 || nr >  n-1 || nc < 0 || nc > m -1) continue;
 
                int currCost = cost;

                if(grid[nr][nc] == 1) currCost++; 

                if(currCost < dist[nr][nc]) {
                    dist[nr][nc] = currCost;
                    queue.offer(new int[]{nr , nc , currCost});
                } 
            }
        }
     return 0 ;
    }
}