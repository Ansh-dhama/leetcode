class Solution {
    Integer[][] memo;
    int[][] freq;
    int MOD = 1000_000_007;
    public int numWays(String[] words, String target) {
        int n = target.length();
        int m = words[0].length();
        freq = new int[m][26];
    
        for(String word : words){
            for(int j =0;j<word.length();j++){
                freq[j][word.charAt(j) - 'a']++;
            }
        }
        memo = new Integer[m][n];
        return solve(0 , 0 , words,target);
    }
    private int solve( int j , int k , String[] words , String target ){
         if(k == target.length()) return 1;
         if(j >= words[0].length()) return 0;
         if(memo[j][k] != null) return memo[j][k];

         long notTake =  solve(j+1 , k , words , target  );
         long count = freq[j][target.charAt(k) -'a'];
         long take  = (long) count *  solve(j +1 , k+1 , words,target );
         
         return memo[j][k] = (int) ((take + notTake) % MOD);
    }

   
}