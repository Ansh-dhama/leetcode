class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        char minimum = s.charAt(0);
        char maximum = s.charAt(0);

        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);

            if (s.charAt(i - 1) > ch) {
                sorted = false;
            }

            minimum = (char) Math.min(minimum, ch);
            maximum = (char) Math.max(maximum, ch);
        }

        if (sorted) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }
        if (s.charAt(0) == minimum
                || s.charAt(n - 1) == maximum) {
            return 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == minimum
                    || s.charAt(i) == maximum) {
                return 2;
            }
        }

        return 3;
    }
}