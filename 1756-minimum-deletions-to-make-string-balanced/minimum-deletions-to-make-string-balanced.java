
class Solution {
    public int minimumDeletions(String s) {

        int n = s.length();

        int[][] dp = new int[n + 1][2];

        // Base case: dp[n][0] = 0 and dp[n][1] = 0

        for (int i = n - 1; i >= 0; i--) {

            for (int prevB = 0; prevB <= 1; prevB++) {

                if (s.charAt(i) == 'b') {

                    int keep = dp[i + 1][1];

                    int delete = 1 + dp[i + 1][prevB];

                    dp[i][prevB] = Math.min(keep, delete);

                } else {

                    if (prevB == 1) {
                        dp[i][prevB] = 1 + dp[i + 1][1];
                    } else {
                        dp[i][prevB] = dp[i + 1][0];
                    }
                }
            }
        }

        return dp[0][0];
    }
}
