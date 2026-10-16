class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);
        long remaining = Math.abs((long) dividend);
        long denominator = Math.abs((long) divisor);

        long quotient = 0;

        for (int shift = 31; shift >= 0; shift--) {
            if ((denominator << shift) <= remaining) {
                remaining -= denominator << shift;
                quotient += 1L << shift;
            }
        }

        return (int) (negative ? -quotient : quotient);
    }
}