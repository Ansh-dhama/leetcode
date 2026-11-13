
class Solution {

    int n;
    int log;

    int[] nums;
    int[][] up;

    long[][] blockSum;
    long[] prefix;

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        this.nums = nums;
        n = nums.length;
        prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[] nextGreater = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {

            while (top >= 0 &&
                    nums[stack[top]] <= nums[i]) {
                top--;
            }

            nextGreater[i] = (top == -1)
                    ? n
                    : stack[top];

            stack[++top] = i;
        }
        log = 1;

        while ((1 << log) <= n) {
            log++;
        }

        up = new int[log][n + 1];
        blockSum = new long[log][n + 1];
        up[0][n] = n;

        for (int i = 0; i < n; i++) {

            up[0][i] = nextGreater[i];

            blockSum[0][i] =
                    (long) nums[i] * (nextGreater[i] - i);
        }
        for (int j = 1; j < log; j++) {

            for (int i = 0; i <= n; i++) {

                int mid = up[j - 1][i];

                up[j][i] = up[j - 1][mid];

                blockSum[j][i] =
                        blockSum[j - 1][i]
                        + blockSum[j - 1][mid];
            }
        }
        int left = 0;

        long answer = 0;

        for (int right = 0; right < n; right++) {

            while (left <= right &&
                    getCost(left, right) > (long) k) {

                left++;
            }

            answer += right - left + 1;
        }

        return answer;
    }
    private long getCost(int l, int r) {

        long maxSum = 0;

        int curr = l;
        for (int j = log - 1; j >= 0; j--) {

            int next = up[j][curr];

            if (next <= r + 1) {

                maxSum += blockSum[j][curr];

                curr = next;
            }
        }

        if (curr <= r) {

            maxSum +=
                    (long) nums[curr] * (r - curr + 1);
        }
        long originalSum = prefix[r + 1] - prefix[l];

        return maxSum - originalSum;
    }
}
