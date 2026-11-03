class Solution {
 Set<Long> set;
 int ans =0;
 int k =0; 
 List<List<Integer>> list;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length+1;
 list = new ArrayList<>();
 set = new HashSet<>();
 this.k = k;
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
            set.add(getKey(gues[0] , gues[1], n));
        }

        int intialCount = dfs(0 , -1 , n);
        
        dfs2(0 , -1 , n, intialCount);

        return ans;
    }
    private int dfs(int node , int parent , int n){
        int count =0;

        for(int next : list.get(node)){
if(next == parent) continue;
            if(set.contains(getKey(node , next , n))) count++;

            count += dfs(next , node , n);
        }
        return count;
    }
    private void dfs2(int node , int parent , int  n , int count ){
        if(count >= k ) ans++;

        for(int next : list.get(node)){
           if(next == parent) continue;
            int intial = count;
            if(set.contains(getKey(node , next , n))) intial--;
            if(set.contains(getKey(next , node , n))) intial++;

            dfs2(next , node , n , intial);
        }
    }
    private long getKey(int parent , int node , int n ){
        return (long) n * parent + node;
    }
}