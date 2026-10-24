class Solution {
    int gap = 0;
    public int maximumTastiness(int[] price, int k) {
        if(k == 0) return 0;
       Arrays.sort(price);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : price){
            min = Math.min(num , min);
            max = Math.max(num , max);
        }
        int left =0;

        int right = max - min;
        int ans = 0;
        while(left <= right ){
            int mid = left + (right - left)/2;

            if(isValid(price , mid , k)){
                ans = mid ;
               left = mid+1;
            }else{
                right = mid - 1;
            }
        }
    return ans;
    }
     private boolean isValid(int[] nums, int d, int k) {
        int count = 1;      
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= d) {
                count++;
                last = nums[i];

                if (count >= k) {
                    return true;
                }
            }
        }

        return count >= k;
    }
}