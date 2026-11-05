class Solution {
    int[] dp ;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n =books.length;
        
        dp = new int[n+1];
        
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
      

      
       for(int i =0;i<n;i++){
         int maxHeight = 0;
         int width =0;
       
              for(int j =i;j >= 0 ; j--){
                width += books[j][0];
            
                maxHeight = Math.max(maxHeight,books[j][1]);
       
                if(width > shelfWidth) break;
                                             

                  dp[i+1] = Math.min(dp[i+1] , dp[j] + maxHeight);  
              }
       }
        
       
        return dp[n];
    }
    
} 

// 1 , 3 