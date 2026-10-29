class Solution {
    int count =0;
    Integer[][] memo;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        memo = new Integer[nums.size()][target+1];
       return solve(0 ,nums , target);
       
    }
    private int solve(int index ,List<Integer> nums , int target){
           if(target == 0) {
            return 0;
        }
        if(index >= nums.size()) return -1;
        if(memo[index][target] != null) return memo[index][target];
        int notTake = solve(index +1 , nums , target);

        int take =-1;

        if(nums.get(index) <= target){
            int result = solve(index+1 , nums , target - nums.get(index));

            if(result != -1){
                take = 1 + result;
            }
        }

        return memo[index][target] =  Math.max(take , notTake);
    }
}