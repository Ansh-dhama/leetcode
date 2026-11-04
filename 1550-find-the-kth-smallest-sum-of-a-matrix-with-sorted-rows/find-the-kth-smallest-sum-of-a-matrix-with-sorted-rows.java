class Solution {
    int k;
    int[][] grid;
    Integer[][] memo;
    public int kthSmallest(int[][] mat, int k) {
        this.k = k;
       grid = mat;
        
        int low =0;
        int high = 0;

        for(int[] row : mat){
            low += row[0];
            high += row[row.length-1];
        }

        while(low < high){
            int mid = low + (high - low)/2;
          memo = new Integer[mat.length][mid+1];
            if(canCount(0,mid) >= k){
                high = mid;
            }else{
                low = mid+1;
            }
        }
      

       return low;
    }
    private int canCount(int row , int sum){
     if(sum < 0) return 0;
        if(row == grid.length) return 1;
        
if(memo[row][sum] != null) return memo[row][sum];
        int ways =0;

        for(int i =0;i<grid[0].length;i++){
               if(sum < grid[row][i] ) break;
             ways += canCount(row +1 ,sum - grid[row][i]);

           
             if(ways >= k) {
                ways = k;
                break;
             }

        }
        return memo[row][sum] = ways;
    }
}