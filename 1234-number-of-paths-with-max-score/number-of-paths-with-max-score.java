class Solution {
    
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
int MOD = 1000_000_007;
        int[][][] dp = new int[n][n][2];

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
          dp[i][j][0] = -1;
            }
        }
int[][] dir = {
    {1,0},{0,1},{1,1}
};
dp[n-1][n-1][0] = 0;
dp[n - 1][n - 1][1] = 1;
        for(int i = n-1 ;i>=0;i--){
            for(int j = n-1;j>=0 ;j--){
                char ch  = board.get(i).charAt(j);

                if(ch == 'X' || (i == n-1 && j == n-1)) continue;

                int max = -1;
                int path = 0;

                for(int[] d : dir){
                    int ni = d[0] + i;
                    int nj = d[1] +j;

                    if(ni > n-1 ||  nj > n-1) continue;
                    if(dp[ni][nj][0] == -1) continue;

                    int score = dp[ni][nj][0];
                    if(score > max ){
                        max = score;
                        path = dp[ni][nj][1];
                    }else if(max == score){
                        path = (path + dp[ni][nj][1]) % MOD;
                    }
                }
            
                if(max!= -1){
                    int cellval = (ch == 'E' )? 0 : ch-'0';
                    dp[i][j][0] = max + cellval;
                    dp[i][j][1] = path;
                }
            }
        } 
        if (dp[0][0][0] == -1) {
    return new int[]{0, 0};
}
        return new int[]{dp[0][0][0] , dp[0][0][1]};   
    }
}