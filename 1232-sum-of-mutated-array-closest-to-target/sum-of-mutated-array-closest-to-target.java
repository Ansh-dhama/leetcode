class Solution {
    public int findBestValue(int[] arr, int target) {
        int right = 0;
        for(int num : arr){
        right =     Math.max(num, right);
        }
    
        int left = 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(getSum(arr  , mid) < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        int sum1 = getSum(arr, left);
        int sum2= getSum(arr,left -1 );

        if(Math.abs(sum1 - target) < Math.abs(sum2 - target)){
            return left;
        }
        return left-1;

    }
    private int getSum(int[] arr , int threshold){
        int sum = 0;
        for(int num : arr){
            sum += Math.min(num , threshold);
        }
       
        return sum;
    }
}