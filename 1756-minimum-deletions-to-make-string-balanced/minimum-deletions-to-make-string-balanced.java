class Solution {
    Integer[][]  memo;
    public int minimumDeletions(String s) {
        int n =s.length();
        memo = new Integer[n][2];
        return solve(s , 0 , 0);
    }
    private int solve(String s , int index , int prevB){
        if(s.length() <= index) return 0;
if(memo[index][prevB] != null) return memo[index][prevB];

        if(s.charAt(index)=='b'){
            int keep  = solve(s , index +1 , 1);
            int deleteB = 1 + solve(s,index+1 , prevB);

            return memo[index][prevB] = Math.min(keep , deleteB);
        }
        if(prevB == 1){
           return memo[index][prevB] = 1 +  solve(s, index + 1 , 1);
        }

        return memo[index][prevB] = solve(s, index +1 , 0);
    }
}