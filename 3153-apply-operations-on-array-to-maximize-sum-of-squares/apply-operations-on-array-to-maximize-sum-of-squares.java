import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;
        int[] bitCounts = new int[31];
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if (((num >> bit) & 1) == 1) {
                    bitCounts[bit]++;
                }
            }
        }

        long totalMaxSum = 0;
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit < 31; bit++) {
                if (bitCounts[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCounts[bit]--;
                }
            }
                        totalMaxSum = (totalMaxSum + (currentNum * currentNum) % MOD) % MOD;
        }

        return (int) totalMaxSum;
    }
}