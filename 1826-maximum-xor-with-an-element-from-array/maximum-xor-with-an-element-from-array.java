import java.util.Arrays;

class Solution {
    private int[] zero;
    private int[] one;
    private int nodes;

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int q = queries.length;
        Integer[] order = new Integer[q];

        for (int i = 0; i < q; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) ->
                Integer.compare(queries[a][1], queries[b][1]));

        // Root is index 0; child index 0 means absent.
        int capacity = 1 + 30 * nums.length;
        zero = new int[capacity];
        one = new int[capacity];
        nodes = 0;

        int[] answer = new int[q];
        int inserted = 0;

        for (int index : order) {
            int x = queries[index][0];
            int limit = queries[index][1];

            while (inserted < nums.length && nums[inserted] <= limit) {
                // Duplicate numbers do not need another insertion.
                if (inserted == 0 || nums[inserted] != nums[inserted - 1]) {
                    insert(nums[inserted]);
                }

                inserted++;
            }

            answer[index] = inserted == 0 ? -1 : findMax(x);
        }

        return answer;
    }

    private void insert(int num) {
        int current = 0;

        for (int bit = 29; bit >= 0; bit--) {
            if (((num >>> bit) & 1) == 0) {
                if (zero[current] == 0) {
                    zero[current] = ++nodes;
                }

                current = zero[current];
            } else {
                if (one[current] == 0) {
                    one[current] = ++nodes;
                }

                current = one[current];
            }
        }
    }

    private int findMax(int num) {
        int current = 0;
        int result = 0;

        for (int bit = 29; bit >= 0; bit--) {
            if (((num >>> bit) & 1) == 0) {
                if (one[current] != 0) {
                    result |= 1 << bit;
                    current = one[current];
                } else {
                    current = zero[current];
                }
            } else {
                if (zero[current] != 0) {
                    result |= 1 << bit;
                    current = zero[current];
                } else {
                    current = one[current];
                }
            }
        }

        return result;
    }
}