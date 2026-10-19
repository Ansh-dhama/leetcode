class Solution {
     public int shipWithinDays(int[] weights, int days) {
       int max = Integer.MIN_VALUE;
        int right = 0;
       for(int num : weights){
           max = Math.max(max , num);
       right += num;
           
       }

       int left =0;
       while(left< right){
           int mid = left + (right -left)/2;
           boolean currentCapacity = calculate(weights , mid , days);
           if(currentCapacity){
               right = mid;
           }else{
               left = mid +1;
           }
       }
       return left;
   }
    private boolean calculate(int[] weights, int capacity, int allowedDays) {
        int usedDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (weight > capacity) {
                return false;
            }

            if (currentLoad + weight <= capacity) {
                currentLoad += weight;
            } else {
                usedDays++;
                currentLoad = weight;

                if (usedDays > allowedDays) {
                    return false;
                }
            }
        }

        return true;
    }
}