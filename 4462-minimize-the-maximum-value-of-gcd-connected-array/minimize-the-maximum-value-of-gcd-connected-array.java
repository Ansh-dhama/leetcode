class Solution {
    public long minimumMaxValue(int n, int index, int value) {
         if(value == 1 ) return -1;
         long p = smallestPrimeNo((long) value);

         long left = (value - p ) / 2;

         if(left < index) return -1;

         long right = n - index -1;

         if(right == 0) return value;

         return  value + p + 2L * (right - 1);
         
    }
    private long smallestPrimeNo(long n){
        if (n % 2 == 0) return 2;
        for(long i =3; i * i <n;i+=2){
            if(n % i == 0) return i;
        }
        return n;
    }
}