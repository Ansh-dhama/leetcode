class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int left =1;
        int right = 0;
       Arrays.sort(nums);
        for(int num : nums){
            right = Math.max(right , num);
        }
        int ans =right;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(isVerify(nums , mid,  maxOperations)){
                ans = mid;
                right = mid-1;
            }else{
left = mid+1;
            }
        }
        return ans;
    }
    private boolean isVerify(int[] nums, int threas , int k ){
       long operation =0;
       
       for(int num : nums){
        if(num > threas){
            operation += (num - 1) / threas;

            if(operation > k) return false;
        }
       }
       return true;
    }
}