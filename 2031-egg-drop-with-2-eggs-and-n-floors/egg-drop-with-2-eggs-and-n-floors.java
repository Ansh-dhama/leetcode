class Solution {
    Integer[][] memo;
    public int twoEggDrop(int n) {
        memo =  new Integer[n+1][n+1];
        return solve(2, 1 , n);
    }
    private int solve(int k , int left , int right){
        if(left > right) return 0;
        if( k == 1) return right - left +1;
        if( memo[left][right]!=null) return  memo[left][right];
        int ans = Integer.MAX_VALUE;
       
        for(int i =left;i<=right;i++){
          int brea = solve(k-1 , left, i-1);
          int survive =  solve(k , i+1, right);
         
         ans = Math.min(ans , 1 + Math.max(brea , survive));
        }
          
        return memo[left][right] = ans;
    }
}