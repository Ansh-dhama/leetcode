class Solution {

    long[][] dp;
    long[] cost;
    int n, x;

    static final long INF = Long.MAX_VALUE / 4;

    public long minOperations(int[] nums, int x, int k) {

        this.n = nums.length;
        this.x = x;

        cost = getWindowCosts(nums, x);
        dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, k);
    }

    private long solve(int i, int k) {
           if(k == 0) return 0;
       if (i + (long) k * x > n) {
            return INF;
        }

   if(dp[i][k] != -1)return dp[i][k];

       long take = cost[i] + solve(i +x ,k-1);
       long notTake = solve(i +1, k);

       return dp[i][k] = Math.min(take , notTake);
    }
    private long[] getWindowCosts(int[] nums, int x) {

        int n = nums.length;

        long[] result = new long[nums.length - x+1];
        
        MediumMap map =new MediumMap();

        for(int i =0;i<x;i++){
            map.add(nums[i]);
        }
        result[0] = map.getCost();

        for(int i =x;i<n;i++){
           
           map.remove(nums[i-x]);
           map.add(nums[i]);

           result[i-x+1] = map.getCost();
        }
        return result;
    }

    static class MediumMap{
        TreeMap<Integer,Integer> low = new TreeMap<>();
        TreeMap<Integer,Integer> high = new TreeMap<>();

        int lowSize = 0;
        int highSize = 0;

        long lowSum = 0;
        long highSum = 0;
        

        void add(int a){
            if(low.isEmpty() || low.lastKey() >= a){
                addTo(low , a);
                lowSum += a;
                lowSize ++;
            }else{
                addTo(high , a);
                highSum += a;
                highSize++;
            }
            rebalance();
        }
        private void addTo(TreeMap<Integer,Integer> map , int val){
              map.put(val , map.getOrDefault(val , 0)+1);
        }
        private long getCost(){
            long medium = low.lastKey();

            return medium * lowSize - lowSum + highSum  - medium * highSize;
        }
private void remove(int val){
    if(low.containsKey(val)){
        removeFrom(low , val);
        lowSum -= val;
        lowSize--;
    }else if(high.containsKey(val)){
        removeFrom(high , val);
        highSum -= val;
    highSize--;
    }
    rebalance();
}
        public void rebalance(){
            int target = (lowSize + highSize + 1)/2;

            while(lowSize > target){
                int val = low.lastKey();

                removeFrom(low, val);
                lowSize--;
                lowSum -= val;


                addTo(high  , val);
                highSum += val;
                highSize++;
            }
            while(lowSize < target ){
                int val = high.firstKey();

                removeFrom(high , val);
                highSize--;
                highSum -= val;

                addTo(low , val);
                lowSum += val;
                lowSize++;
            }
        }
        public void removeFrom(TreeMap<Integer, Integer> map , int val){
            int count = map.get(val);

            if(count == 1){
                map.remove(val);
            }else{
                map.put(val , map.getOrDefault(val,0)-1);
            }
        }

    }
}
