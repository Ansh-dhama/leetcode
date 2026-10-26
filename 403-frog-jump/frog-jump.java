class Solution {
   Map<Integer,Integer> map;
 Boolean[][] dp ;
    public boolean canCross(int[] stones) {
      if(stones[1] != 1) return false;

       map = new HashMap<>();
      int n =stones.length;
     
       for(int i =0;i<stones.length;i++){
        map.put(stones[i] , i);
       }
       
    dp   = new Boolean[n][n+1];

        return solve(stones , 1,1);
    }
    private boolean solve(int[] stones ,int index , int k ){

        if(index >= stones.length -1) return true;

        if(dp[index][k] != null) return dp[index][k];

        for(int i = k-1;i<=k+1;i++){
            if(i > 0){
                int nextPos = stones[index] + i;
                if(map.containsKey(nextPos)){
                    int nextIndex = map.get(nextPos);

                    if(solve(stones, nextIndex , i)){
                       return dp[index][k] = true;
                    }
                }
            }
        }
        return dp[index][k] = false;

    }
}