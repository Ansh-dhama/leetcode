class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lcm1 = lcm(a,b);
        long lcm3 = lcm(a,c);
        long lcm4 = lcm(c,b);
        long lcm2 = lcm(lcm1 , c);
        long left = 0;
        long right =  (long) n * Math.min(a,Math.min(b,c));
        while(left <right){
            long mid = left + (right -left)/2;

            long count = (mid / a + mid /b + mid / c) - ( mid/lcm1 + mid/lcm3 +mid/lcm4 ) + mid/lcm2;

            if(count >= n){
                right = mid;
            }else left = mid +1;
        }
        return (int)left ;
    }
    private long gcd(long a , long b){
        if(b==0) return a;
        return gcd(b , a % b);
    }
    private long lcm(long a , long b){
        return (long)(a * b) / gcd(a,b);
    }
}