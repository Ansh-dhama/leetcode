class Solution {
    Integer[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
         int n = dungeon.length;
        int m = dungeon[0].length;

        memo = new Integer[n][m];

        return solve(0 , 0 , dungeon);
    }
    private int solve(int row , int col ,int[][] dungeon){
        int n = dungeon.length;
        int m = dungeon[0].length;

        if(row > n-1 || col > m-1) return Integer.MAX_VALUE/2;
        if(memo[row][col] != null) return memo[row][col];
        if(row == n-1 && col == m-1 ) return Math.max(1 , 1 - dungeon[row][col]);

        int down = solve(row+1 , col ,dungeon);
        int right = solve(row , col+1 , dungeon);

        int next = Math.min(down , right);

        return memo[row][col] =  Math.max(1 , next - dungeon[row][col]);
    }
}