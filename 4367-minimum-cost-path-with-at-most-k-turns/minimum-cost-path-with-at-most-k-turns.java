class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m =grid[0].length;

        int[][][][] memo = new int[n][m][k+1][5];
        for(int[][][] row : memo){
            for(int[][] col : row){
                for(int[] d : col){
                    Arrays.fill(d , Integer.MAX_VALUE);
                }
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->Integer.compare(a.cost , b.cost));
        queue.offer(new Pair(0,0,grid[0][0],4,0));
        memo[0][0][0][4] = grid[0][0];
        int[][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int row =curr.row;
            int col = curr.col;
            int cost = curr.cost;
            int prev = curr.prev;
            int dist = curr.dist;
if(row == n-1 && col == m-1) return cost;
if(cost > memo[row][col][dist][prev]) continue;

            for(int i =0;i<4;i++){
                int newRow = dir[i][0] +row;
                int newCol =  dir[i][1] +col;
               
               if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m){
                   int currStep = dist;

                   if(prev != 4 && i != prev){
                      currStep++;
                   }
                   if(currStep > k) continue;
int newCost = cost + grid[newRow][newCol];
                   if(newCost < memo[newRow][newCol][currStep][i]){
                    memo[newRow][newCol][currStep][i] = newCost;
                    queue.offer(new Pair(newRow, newCol ,newCost ,i, currStep));
                   }
               }
            } 
        }
        return -1;
    }
    class Pair{
        int row;
        int col;
        int cost;
        int prev;
        int dist;

        Pair(int row , int col , int cost , int prev , int dist){
            this.row = row;
            this.col = col;
            this.cost= cost;
            this.prev = prev;
            this.dist= dist;
        }
    }
}