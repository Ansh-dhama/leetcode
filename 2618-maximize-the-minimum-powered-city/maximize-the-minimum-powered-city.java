class Solution {
    public long maxPower(int[] stations, int r, int k) {
     
       int n = stations.length;

       long[] power = new long[n];
       long[] prefix = new long[n];
       prefix[0] = stations[0];
       for(int i =1;i<n;i++){
        prefix[i] = prefix[i-1] + stations[i];
       }
       for(int i =0;i<n;i++){
            int left = Math.max(0 , i - r);
            int right = Math.min(n-1, i+r);
            long curr = prefix[right];
            if (left > 0) {
        curr -= prefix[left - 1];
    }
         power[i] = curr;
       }

       long left =0;
       long right = 0;

       for(long num : power){
           right = Math.max(num , right);
       }

       right += k;
long ans =0 ;
       while(left <= right ){
           long mid = left + (right - left)/2;

           if(canArchive(power , r , k , mid)){
              ans = mid;
              left = mid+1;
           }else{
            right = mid-1;
           }
       }
       return ans;
    }
    private boolean canArchive(long[] power , int r , int k , long target){
         long[] diff = new long[power.length+1];
         long extrapower =0;
         long used = 0;
         for(int i =0;i<power.length;i++){
              extrapower += diff[i];
              
              long currP = extrapower + power[i];

              if(currP < target){
                
                 long need = target - currP;
            used += need;
                 if(used > k){
                    return false;
                 }

                 extrapower += need;
                 
                 int end = (int) Math.min(
    (long) power.length,
    (long) i + 2L * r + 1
);

                 diff[end] -= need;
              } 


         }
         return true;
    }
}