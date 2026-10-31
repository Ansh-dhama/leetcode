class Solution {
    // public int splitArray(int[] nums, int k) {
    //     int max =0;
    //     int sum =0;

    //     for(int num :nums){
    //         max = Math.max(max , num); 
    //         sum += num;
    //     }
    //     int left  = max;
    //     int right = sum;

    //     while(left<right){
    //         int mid = left + (right - left)/2;

    //         if(canWeSplit(nums, k ,mid)){
    //             right = mid;
    //         }
    //         else{
    //             left = mid+1;
    //         }
    //     }
    //     return left;
    // }
    // private boolean canWeSplit(int[] nums , int k , int maxSumAllowed){
    //     int split = 1;
    //     int currentSum =0;
        
    //     for(int num : nums){
    //         if(currentSum+ num > maxSumAllowed){
    //             split++;
    //             currentSum =num;

    //             if(split>k) return false;
    //         }else{
    //             currentSum +=  num;
    //         }
    //     }
    //     return true;
    // }

Integer[][] memo;
 public int splitArray(int[] nums, int k) {
    memo = new Integer[nums.length][k+1];
     return solve(nums,0 ,k);
 }
 private int solve(int[] nums , int index , int k){
     if(memo[index][k]!= null) return memo[index][k];
    if(k==1){
        int leftSum = 0;
        for(int i = index;i<nums.length;i++){
            leftSum += nums[i];
        }
        return leftSum;
    }
    
   
    int sum =0;
    int max = Integer.MAX_VALUE;

    for(int i = index; i <= nums.length - k;i++){
        sum += nums[i];
        int nextSum = solve(nums , i+1,k-1);

        max =Math.min(Math.max(sum , nextSum) , max);
    }

    return memo[index][k] = max;
 }
}