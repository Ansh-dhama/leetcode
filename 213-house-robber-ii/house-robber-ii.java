class Solution {
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     if( n== 1) return nums[0];
    //     int[] memo = new int[n];
    //  Arrays.fill(memo,-1);
    //     int take = solve(nums , n,1 ,memo);
    //     Arrays.fill(memo , -1);
    //     int notTake = solve(nums , n-1 ,0,memo);
    //     return Math.max(take , notTake);
    // }
    // private int solve(int[] nums, int n , int index,int[] memo){
    //     if(index >= n) return 0;
    // if(memo[index] != -1) return memo[index];
    //     int take = nums[index] + solve(nums , n , index+2,memo);
    //     int notTake = 0 + solve(nums , n , index+1 ,memo);

    //     return memo[index] = Math.max(take , notTake);
    // }

    public int rob(int[] nums) {
    int n = nums.length;
       if(n==0) return 0;
       if(n == 1)return nums[0];
       if(n== 2) return Math.max(nums[0] , nums[1]);

       int[] dp1 = new int[n];
       dp1[0] = nums[0];
       dp1[1] = Math.max(nums[0] , nums[1]);
       for(int i =2;i<n-1;i++){
        dp1[i] = Math.max(dp1[i-1] , dp1[i-2] + nums[i]);
       }

       int[] dp2 = new int[n];
       dp2[1] = nums[1];
       dp2[2] = Math.max(nums[1] , nums[2]);
       for(int i =3;i<n;i++){
        dp2[i] = Math.max(dp2[i-1] , dp2[i-2] + nums[i]);
       }

       return Math.max(dp1[n-2], dp2[n-1]);

    }
}