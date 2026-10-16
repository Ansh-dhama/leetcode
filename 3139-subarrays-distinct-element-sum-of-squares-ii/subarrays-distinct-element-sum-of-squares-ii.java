import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] sum;
    private long[] squares;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        sum = new long[4 * n];
        squares = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long answer = 0;

        for (int right = 0; right < n; right++) {
            int previous = lastSeen.getOrDefault(nums[right], -1);

            update(1, 0, n - 1, previous + 1, right);

            answer = (answer + squares[1]) % MOD;
            lastSeen.put(nums[right], right);
        }

        return (int) answer;
    }

    // Add 'value' to every distinct count in this segment.
    private void apply(int node, int length, long value) {
        // (x + value)^2 = x^2 + 2*x*value + value^2
        squares[node] = (
                squares[node]
                + (2 * value % MOD) * sum[node] % MOD
                + (value * value % MOD) * length % MOD
        ) % MOD;

        sum[node] = (sum[node] + value * length) % MOD;
        lazy[node] = (lazy[node] + value) % MOD;
    }

    private void push(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) return;

        int mid = left + (right - left) / 2;

        apply(node * 2, mid - left + 1, lazy[node]);
        apply(node * 2 + 1, right - mid, lazy[node]);

        lazy[node] = 0;
    }

    // Add 1 to every position in [queryLeft, queryRight].
    private void update(
            int node,
            int left,
            int right,
            int queryLeft,
            int queryRight
    ) {
        if (queryLeft <= left && right <= queryRight) {
            apply(node, right - left + 1, 1);
            return;
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        if (queryLeft <= mid) {
            update(node * 2, left, mid, queryLeft, queryRight);
        }

        if (queryRight > mid) {
            update(node * 2 + 1, mid + 1, right,
                    queryLeft, queryRight);
        }

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        squares[node] = (
                squares[node * 2] + squares[node * 2 + 1]
        ) % MOD;
    }
}