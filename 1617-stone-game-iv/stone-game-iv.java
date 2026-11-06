class Solution {
    Boolean[] memo;
    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n+1];
        return solve(n);
    }
    private boolean solve(int n){
        if(n==0) return false;
        if(memo[n] != null) return memo[n];
        for(int i =1;i * i <=n;i++){
            int remain = n - i * i;

            if(!solve(remain)) return memo[n] = true;
        }
        return memo[n] = false;
    }
}

// 5 

// 1 -> 4 -> 4 ->  0
// 4-> 1 -> 0;

//2 -