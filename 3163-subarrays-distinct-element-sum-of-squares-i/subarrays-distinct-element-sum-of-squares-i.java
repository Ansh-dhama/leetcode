class Solution {
    public int sumCounts(List<Integer> nums) {
        int answer = 0;
        int n = nums.size();
        int[] seen = new int[101];

        for (int i = 0; i < n; i++) {
            int distinct = 0;
            int mark = i + 1;

            for (int j = i; j < n; j++) {
                int value = nums.get(j);

                if (seen[value] != mark) {
                    seen[value] = mark;
                    distinct++;
                }

                answer += distinct * distinct;
            }
        }

        return answer;
    }
}