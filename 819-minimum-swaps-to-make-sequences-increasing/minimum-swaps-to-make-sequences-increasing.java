class Solution {
    int INF = 1000_000_007;
    Integer[][] memo;
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;

        memo = new Integer[n][2];

        return solve(0,0,nums1,nums2);
    }
    private int solve(int i ,int prevSwap ,int[] nums1 , int[] nums2){
        if(i >= nums1.length ||i >= nums2.length) return 0;

          if(memo[i][prevSwap] != null) return memo[i][prevSwap];
        int prevA = Integer.MIN_VALUE;
        int prevB = Integer.MIN_VALUE;

        if (i > 0) {
            prevA = (prevSwap == 1) ? nums2[i-1] : nums1[i-1];
            prevB = (prevSwap == 1) ? nums1[i-1] : nums2[i-1];
        }

        int notTake = INF;
        int take = INF;

        if(nums1[i] > prevA && nums2[i] > prevB){
          notTake = solve(i+1 , 0, nums1,  nums2);
        }
        if(nums1[i] > prevB && nums2[i] > prevA){
            take = 1  + solve(i+1 ,1, nums1,nums2);
        }

        return memo[i][prevSwap] =  Math.min(notTake , take);
    }
}