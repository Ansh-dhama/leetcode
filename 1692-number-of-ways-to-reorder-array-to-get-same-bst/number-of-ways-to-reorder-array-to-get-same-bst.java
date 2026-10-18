import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[][] combinations;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        combinations = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            combinations[i][0] = combinations[i][i] = 1;

            for (int j = 1; j < i; j++) {
                combinations[i][j] =
                        (combinations[i - 1][j - 1]
                         + combinations[i - 1][j]) % MOD;
            }
        }

        List<Integer> values = new ArrayList<>();

        for (int num : nums) {
            values.add(num);
        }

        return (int) ((count(values) - 1 + MOD) % MOD);
    }

    private long count(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        int leftCount = left.size();
        int rightCount = right.size();

        long leftWays = count(left);
        long rightWays = count(right);

        long mixingWays =
                combinations[leftCount + rightCount][leftCount];

        return mixingWays * leftWays % MOD * rightWays % MOD;
    }
}