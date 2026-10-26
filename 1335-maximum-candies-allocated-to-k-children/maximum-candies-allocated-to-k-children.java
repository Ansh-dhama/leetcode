class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left =1;
      long sum = 0;
int maxPile = 0;

for (int num : candies) {
    sum += num;
    maxPile = Math.max(maxPile, num);
}
if (sum < k) return 0;

int right = (int) Math.min((long) maxPile, sum / k);

int ans = 0;
      while(left <= right){
        int mid = left + (right - left)/2;

        if(solve(candies , mid ,  k)){
            ans = mid;
            left = mid+1;
        }else{
            right = mid-1;
        }
      }
      return ans ;
    }
    private boolean solve(int[] nums , int thres , long k){
        long kids = 0;

        for(int num : nums){
            if(num >= thres){
                kids += (num) / thres;
               if(kids >= k) return true;
            }
        }
        return kids >= k;
    }
}