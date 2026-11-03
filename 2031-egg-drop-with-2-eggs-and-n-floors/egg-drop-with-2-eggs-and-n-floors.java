class Solution {
    Integer[][][] memo;
    public int twoEggDrop(int n) {
        memo =  new Integer[n+1][n+1][2+1];
        return solve(2, 1 , n);
    }
    private int solve(int k , int low , int high){
        if(low > high) return 0;
        if( k == 1) return high - low +1;
        if( memo[low][high][k]!=null) return  memo[low][high][k];
        int ans = Integer.MAX_VALUE;
        
        int left = low;
        int right= high;

       
         while(left <= right){
            int mid = left + (right - left)/2;

         int brea = solve(k-1 , low, mid -1);
          int survive =  solve(k , mid+1, high);
         
         ans = Math.min(ans , 1 + Math.max(brea , survive));
            
            if(brea > survive){
                right = mid -1;
            }else if(brea < survive){
                left = mid+1;
            }
            else {
    break;
   }
        }
          
        return memo[low][high][k] = ans;
    }
}