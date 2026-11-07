class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();

        int[][] pos = new int[26][2];
int ans =0;
        for(int i =0;i<26;i++){
            pos[i][0] = -1;
            pos[i][1] = -1;
        }
        for(int i =0;i<n;i++){
            int index = s.charAt(i) - 'A';

            int prev2 = pos[index][0];
            int prev = pos[index][1];
            ans += (i - prev) * (prev - prev2);
            pos[index][0] = prev;
            pos[index][1] = i;
        }

        for(int i =0;i<26;i++ ){

            int prev2 = pos[i][0];
            int prev = pos[i][1];

            ans += (n - prev) * (prev - prev2);
        }

        return ans;
    }
}