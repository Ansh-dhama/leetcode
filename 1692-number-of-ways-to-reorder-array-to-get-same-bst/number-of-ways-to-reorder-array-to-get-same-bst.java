import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[][] memo;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        memo = new long[n + 1][n + 1];

        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }

        List<Integer> values = new ArrayList<>();

        for (int num : nums) {
            values.add(num);
        }

        return (int) ((count(values) - 1 + MOD) % MOD);
    }
    private long combination(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }

        if (memo[n][r] != -1) {
            return memo[n][r];
        }

        memo[n][r] = (
                combination(n - 1, r - 1)
                + combination(n - 1, r)
        ) % MOD;

        return memo[n][r];
    }

    private long count(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            int value = nums.get(i);

            if (value < root) {
                left.add(value);
            } else {
                right.add(value);
            }
        }

        long leftWays = count(left);
        long rightWays = count(right);

        long mixingWays =
                combination(left.size() + right.size(), left.size());

        return mixingWays * leftWays % MOD * rightWays % MOD;
    }
}