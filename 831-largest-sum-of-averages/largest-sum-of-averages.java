class Solution {
    Double[][] memo;
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        memo = new Double[n][k+1];
        return solve(nums , 0, k);
    }
    private double solve(int[] nums , int index , int k ){
        if(k==1){
            double avg =0;
            for(int i =index;i<nums.length;i++){
                avg += nums[i];
            }
            avg /= (nums.length - index);

            return avg;
        }
        if(memo[index][k]!= null) return memo[index][k];
        if(index>= nums.length) return 0;
        
        double ans = Integer.MIN_VALUE;
        double sum =0;
        for(int i =index ;i<= nums.length-k;i++){
            sum += nums[i];
            double curr = (sum / (i-index +1) ) + solve(nums , i+1, k-1 );
            ans = Math.max(curr , ans);
        }
        return memo[index][k] = ans;
    }
}