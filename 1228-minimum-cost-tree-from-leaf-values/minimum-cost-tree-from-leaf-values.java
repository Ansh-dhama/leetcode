class Solution {
    Integer[][] memo;
    public int mctFromLeafValues(int[] arr) {
        memo = new Integer[arr.length][arr.length];
        return solve(arr ,0 ,arr.length-1);
    }
    private int solve(int[] arr , int left , int right){
        if(right == left ) return 0;

        int ans = Integer.MAX_VALUE;
if(memo[left][right]  != null) return memo[left][right];
        for(int i = left ; i<right;i++){
            int lc = solve(arr ,left , i);
            int rc = solve(arr, i+1  ,right);
            int leftM = findMax(arr, left,i);
            int rightM = findMax(arr , i+1 , right);
            int curr = leftM * rightM;
            ans = Math.min(ans , curr+lc+rc);
        }
        return memo[left][right] = ans;
    }
    private int findMax(int[] arr , int left , int right){
int max = 0;
        while(left <= right){
            max = Math.max(arr[left] , max);
            left++;
        }
        return max;
    }
}