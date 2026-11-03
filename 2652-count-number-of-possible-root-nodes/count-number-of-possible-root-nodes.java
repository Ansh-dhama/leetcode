class Solution {
    Set<Long> set;
    List<List<Integer>> list;
   int k;
   int ans =0;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        set = new HashSet<>();
        int n = edges.length +1;
        this.k = k;
        list = new ArrayList<>();

        for(int i =0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            list.get(from).add(to);
            list.get(to).add(from);
        }

        for(int[] gues : guesses){
            set.add(getKey(gues[0] , gues[1] ,n));
        }
        
        int intialcount = dfs(0 ,-1,n );

        dfs2(0,-1 , intialcount , n);
        return ans;

    }
    private int dfs(int node , int parent , int n){
         int count =0;

         for(int next : list.get(node)){
            if(next == parent) continue;

            if(set.contains(getKey(node, next, n))) count++;

            count += dfs(next , node , n);
         }
         return count;
    }
    private void dfs2(int node , int parent , int count , int n){
        if(count >= k) ans++;

        for(int next : list.get(node)){
            if(next == parent) continue;
            int intial  = count;

            if(set.contains(getKey(node  , next, n))) intial--;
            if(set.contains(getKey( next  , node, n))) intial++;

            dfs2(next , node , intial , n);
        }
        
    }
   private long getKey(int u, int v, int n) {
    return (long) u * n + v;
}
}