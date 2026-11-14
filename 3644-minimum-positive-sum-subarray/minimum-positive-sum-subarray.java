class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        int ans = Integer.MAX_VALUE;

      
        for(int size = l ; size <= r ;size++ ){
              int left =0;
        int currSum = 0;
            for(int i =0;i<nums.size();i++){
            currSum += nums.get(i);

            if(i - left+1 > size){
                currSum -= nums.get(left);
                left++;
            }
            int len = i- left+1;
            if(size == len && currSum > 0 ){
                ans = Math.min(currSum , ans);
            }
            
        }
    }
      
      
   
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}