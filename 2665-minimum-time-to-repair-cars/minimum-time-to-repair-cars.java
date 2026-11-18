class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);

        long left  =0;
        long right = (long) ranks[0] * cars * cars;
        long ans = 0;

        while(left <= right){
            long mid = left +(right -left)/2;

            if(check(mid , ranks , cars)){
                ans = mid; 
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    private boolean  check(long time , int[] ranks , int cars){
          long totalCars =0;
          
          for(int rank : ranks){
              long repaired = (long) Math.sqrt((double) time /  rank);

              totalCars += repaired;

              if(totalCars >= cars) return true;
          }
          return false;
    }
}
// n car / r
