class Solution {
    int ans =0;
     int[] prefix;
     Integer[][] memo;
    public int stoneGameVII(int[] stones) {
        prefix = new int[stones.length+1];
        memo = new Integer[stones.length][stones.length];

        for (int i = 0; i < stones.length; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        return solve(0,stones,stones.length-1); 
    }
    private int solve(int left , int[] stones , int right){
    if(left >= right) return 0;
    if(memo[left][right] != null) return memo[left][right];
        int TakeL =prefix[right+1] - prefix[left+1];
int option1 = TakeL - solve(left+1 , stones , right);
        
        int TakeR =  prefix[right] - prefix[left]; 
          
        
      
        int option2 = TakeR - solve(left, stones , right -1);
        return memo[left][right] =  Math.max(option1 , option2);
    }
}