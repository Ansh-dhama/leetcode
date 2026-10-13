class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;
        int select =0;
        int ans =0;
        for(int i = n-1;i>=0;i--){
            int newSum = satisfaction[i] + select;
            
            if(newSum < 0 ) break;
            select  = newSum;
            ans += select;
        }
        return ans;
    }
}