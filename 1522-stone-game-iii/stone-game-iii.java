class Solution {
    Integer[] memo;
    public String stoneGameIII(int[] stoneValue) {
        memo = new Integer[stoneValue.length];
        int diff = solve(0 , stoneValue);
System.out.println(diff);
        if(diff < 0) return "Bob";
        else if(diff == 0)return "Tie";
        else return "Alice";
    }
    private int solve(int index , int[] stoneValues){
        if(index >= stoneValues.length) return 0;
if(memo[index] != null )return memo[index];
        int sum =0;
        int diff= Integer.MIN_VALUE;
        for(int i =1;i<=3;i++){
            if(index + i > stoneValues.length) break;
            sum += stoneValues[index + i -1];

            int oppo = solve(index + i, stoneValues);

            diff = Math.max(diff ,sum - oppo); 
        }
        return memo[index] = diff;
    }
}