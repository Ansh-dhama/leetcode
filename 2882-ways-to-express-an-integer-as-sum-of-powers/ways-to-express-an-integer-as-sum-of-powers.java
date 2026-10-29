class Solution {
    List<Integer> list = new ArrayList<>();
Integer[][] memo;
int MOD = 1000_000_007;
    public int numberOfWays(int n, int x) {
       
      for(int i = 1;i<=n;i++){
        long power = (long) Math.pow(i , x);

        if(power > n) break;

        list.add((int) power);
      }
      memo = new Integer[list.size()][n+1];

      return solve(0 , n);
    }
    private int solve(int index , int target){
        if(target < 0) return 0;
        if(index == list.size()) return target == 0 ? 1 : 0;
        if(target == 0) return 1;
        if(memo[index][target] != null) return memo[index][target];
        int notTake = solve(index +1 , target);

        int take = 0;

        if(list.get(index) <= target){
            take += solve(index + 1 , target - list.get(index));
        }

        return memo[index][target] =  (notTake + take) % MOD;
    }
}