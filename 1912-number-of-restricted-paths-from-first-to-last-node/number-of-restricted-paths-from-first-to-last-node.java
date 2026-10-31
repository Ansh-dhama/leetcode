class Solution {
    int n;
    Integer[] memo;
    int MOD = 1_000_000_007;
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<int[]>> list  = new ArrayList<>();
       for(int i =0;i<=n;i++){
       list.add(new ArrayList<>());
       }
        for(int[] edge :edges){
            int from = edge[0];
            int to = edge[1];
            int wei = edge[2];
            list.get(from).add(new int[]{to ,wei});
            list.get(to).add(new int[]{from ,wei});
        }

        int[] dist = new int[n+1];

    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.fill(dist ,Integer.MAX_VALUE);
queue.offer(new int[]{n , 0});
dist[n]=0;
       
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0];
            int wei = curr[1];
            if(wei > dist[node]) continue;
            for(int[] next : list.get(node)){
                int newDist = wei + next[1];
                int newNode = next[0];

                if(newDist < dist[newNode]){
                    dist[newNode] = newDist;
                    queue.offer(new int[]{newNode ,newDist });
                }
            }
        }
        this.n = n;
        memo = new Integer[n+1];
       return  dfs(1,list , dist);    
    }
    private int dfs(int city , List<List<int[]>> list , int[] dist){
        if(city == n) return 1;
        if(memo[city]!= null) return memo[city];
         long ways =0;
        for(int[] next : list.get(city)){
            if(dist[city] > dist[next[0]]){
               ways = (ways + dfs(next[0], list, dist)) % MOD;
            }
        }
        return memo[city] = (int)ways;
    }
}