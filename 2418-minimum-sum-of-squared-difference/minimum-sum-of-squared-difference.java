class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int maxDiff = 0;

        for (int i = 0; i < nums1.length; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums1[i] - nums2[i]));
        }

        long[] frequency = new long[maxDiff + 1];

        for (int i = 0; i < nums1.length; i++) {
            frequency[Math.abs(nums1[i] - nums2[i])]++;
        }

        long operations = (long) k1 + k2;

        // Reduce the largest differences in batches.
        for (int diff = maxDiff; diff > 0 && operations > 0; diff--) {
            long changes = Math.min(frequency[diff], operations);

            frequency[diff] -= changes;
            frequency[diff - 1] += changes;
            operations -= changes;
        }

        long answer = 0;

        for (int diff = 1; diff <= maxDiff; diff++) {
            answer += frequency[diff] * diff * diff;
        }

        return answer;
    }
}