class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int left =0;
        int max = 0;
        int maxLen = 1;
        for(int i =1;i<nums.length;i++){
             if(nums[i] <= nums[i-1] ){
                left =i;
             }
             int curr = i -  left +1 ;
             if(curr > maxLen){                
                  maxLen = Math.max(curr , maxLen);
             }
        }
     left =0;
       for(int i =1;i<nums.length;i++){
             if(nums[i] >= nums[i-1] ){
                left =i;
             }
             int curr = i -  left +1 ;
             if(curr > maxLen){                
                  maxLen = Math.max(curr , maxLen);
             }
        }
        return maxLen ;
    }
}