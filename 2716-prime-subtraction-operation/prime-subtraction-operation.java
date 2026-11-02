class Solution {
    public boolean primeSubOperation(int[] nums) {
        int prev = 0;
        for(int i =0;i<nums.length;i++){
            int diff = nums[i] - prev;

            int gr = greatestPrime(diff - 1);
            
            if(gr != -1) {
                nums[i] -= gr;
            }
            if(prev >= nums[i]) return false;

            prev = nums[i];
        }
        return true;
    }
    private int greatestPrime(int n) {
        for (int i = n; i >= 2; i--) {
            if (isPrime(i)) {
                return i;
            }
        }

        return -1;
    }
    private static boolean isPrime(int n){
if (n < 2) return false;
        for(int i =2;i * i <=n;i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}