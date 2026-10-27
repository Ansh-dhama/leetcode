class Solution {
    Integer[] memo;
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
     int n = energy.length;
     memo = new Integer[n];
        for(int i = 0;i<n;i++){
            max = Math.max(max , solve(energy,k,i));
        }
       return max;
    }
    private int solve(int[] energy , int k  , int index){
        
        if(index >= energy.length) return 0;
        if(memo[index] != null) return memo[index];
        return memo[index] = energy[index] + solve(energy , k ,index + k  );
       
    }
}