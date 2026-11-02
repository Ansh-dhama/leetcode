class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long left =0;
        long lcm = lcm(a,b);
        long right = (long)n * Math.min(a,b);
         
        int MOD =1000_000_007;
         while(left < right){
            long mid = left + (right- left)/2;

            long count = mid / a + mid /b - mid/lcm;

            if(count <  n) left = mid + 1 ;
            else right = mid;
         }

         return (int) (left % MOD);
    }
    
    private int gcd(int a , int b){
        if(b == 0) return a;
        return gcd(b , a % b);
    }

    private long lcm(int a , int b){
        return (long) a * b / gcd(a,b);
    }
}