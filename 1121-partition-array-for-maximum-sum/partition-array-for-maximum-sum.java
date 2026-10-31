class Solution {
    Integer[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        memo = new Integer[n];
        return solve(arr , 0 , k);
    }
    private int solve(int[] arr , int index , int k){
        if(index >= arr.length) return 0;
        if(memo[index] != null) return memo[index];
        int max = 0;
        int ans = Integer.MIN_VALUE;

            for(int i = index ; i < Math.min(arr.length , index + k);i++){
                max = Math.max(max , arr[i]);
  
                int curr = max * (i - index + 1) + solve(arr , i+1 , k);
                ans = Math.max(ans , curr);
            }
        
        return memo[index] =  ans;
    }
}