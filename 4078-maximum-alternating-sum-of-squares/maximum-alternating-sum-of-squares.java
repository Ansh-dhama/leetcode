class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
       long[] square = new long[n];
       long ans = 0;

       for(int i =0;i<n;i++){
        square[i] = (nums[i] * nums[i]);
       }

       Arrays.sort(square);

       for(int i =0;i<n;i++){
        if(i < n/2){
            ans -= square[i];
        }else{
            ans += square[i];
        }
       }
       return ans;
    }
}