class Solution {
    List<List<Integer>> graph;
    int[] freq;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {   
        graph = new ArrayList<>();
        freq = new int[n];

        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int from = e[0];
            int to  = e[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int[] trip : trips){
            int from = trip[0];
            int to = trip[1];

            countPath(from , -1 , to);
        }
        
        long[] result = solve(0 , -1 , price);

        return (int) Math.min(result[0] , result[1]);

    }
    private boolean countPath(int u , int parent , int target){
        if(u == target) {
            freq[u]++;
            return true;
        }
        for(int v : graph.get(u)){
  if(v == parent) continue;
            if(countPath(v , u, target)){
                freq[u]++;
                return true;
            }
        }
        return false;
    }
    private long[] solve(int node , int parent , int[] price){
        
        long half = (long) (freq[node] * price[node]) / 2;
        long notHalf = (long) (freq[node] * price[node]);

        for(int v : graph.get(node)){
            if(v == parent) continue;

            long[] next= (solve(v , node , price));
            notHalf += Math.min(next[0] , next[1]);
            half += next[0];
        }
     return new long[]{notHalf,half};
    }
}