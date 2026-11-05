class Solution {
    int[] dp ;
    Integer[] memo;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n =books.length;
        
        dp = new int[n+1];
        memo = new Integer[n+1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
      solve(0 , books , shelfWidth);

      
    //    for(int i =0;i<n;i++){
    //      int maxHeight = 0;
    //      int width =0;
       
    //           for(int j =i;j >= 0 ; j--){
    //             width += books[j][0];
            
    //             maxHeight = Math.max(maxHeight,books[j][1]);
       
    //             if(width > shelfWidth) break;
                                             

    //               dp[i+1] = Math.min(dp[i+1] , dp[j] + maxHeight);  
    //           }
    //    }
        
       
        return dp[n];
    }

    private int solve(int index , int[][] books , int shelfWidth){
        if(index >= books.length) return Integer.MAX_VALUE/2;
   if(memo[index] != null) return memo[index];
         int maxHeight = 0;
         int width =0;
       
              for(int j =index;j >= 0 ; j--){
                width += books[j][0];
            
                maxHeight = Math.max(maxHeight,books[j][1]);
       
                if(width > shelfWidth) break;
                                             

                  dp[index+1] = Math.min(dp[index+1] , dp[j] + maxHeight);  
              }
        return memo[index] = solve(index+1 , books ,shelfWidth );
    }
    
} 

// 1 , 3 