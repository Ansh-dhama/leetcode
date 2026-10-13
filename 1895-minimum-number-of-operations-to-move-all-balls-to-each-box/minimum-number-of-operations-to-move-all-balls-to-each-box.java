class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        for (int destination = 0; destination < n; destination++) {
            for (int source = 0; source < n; source++) {
                if (boxes.charAt(source) == '1') {
                    answer[destination] +=
                        Math.abs(destination - source);
                }
            }
        }

        return answer;
    }
}