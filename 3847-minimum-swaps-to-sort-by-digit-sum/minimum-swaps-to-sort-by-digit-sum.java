import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            result.add(num);
        }

        return swap(result);
    }

    private static int sum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    private static int swap(List<Integer> result) {
        List<Integer> sorted = new ArrayList<>(result);

        sorted.sort((a, b) -> {
            int comparison = Integer.compare(sum(a), sum(b));

            return comparison != 0
                    ? comparison
                    : Integer.compare(a, b);
        });

        Map<Integer, Integer> position = new HashMap<>();

        for (int i = 0; i < result.size(); i++) {
            position.put(result.get(i), i);
        }

        int swaps = 0;

        for (int left = 0; left < result.size(); left++) {
            int current = result.get(left);
            int required = sorted.get(left);

            if (current == required) {
                continue;
            }

            int right = position.get(required);

            Collections.swap(result, left, right);

            position.put(required, left);
            position.put(current, right);

            swaps++;
        }

        return swaps;
    }
}