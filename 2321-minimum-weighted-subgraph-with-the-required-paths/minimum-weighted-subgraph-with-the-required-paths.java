class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> list = new ArrayList<>();
        List<List<int[]>> reverse = new ArrayList<>();
        for(int i =0;i<n;i++){
            list.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int wei = edge[2];
            list.get(from).add(new int[]{to ,wei});
            reverse.get(to).add(new int[]{from , wei});
        }
        long[] dist1 = solve(src1 , list , n);
        long[] dist2 = solve(src2 , list , n);
        long[] dist3 = solve(dest , reverse , n);

long ans = Long.MAX_VALUE;
        for(int i =0;i<n;i++){
            if(dist1[i] == Long.MAX_VALUE || dist2[i] == Long.MAX_VALUE || dist3[i] == Long.MAX_VALUE) continue;

            long curr = dist1[i]  + dist2[i] + dist3[i];

            ans = Math.min(curr , ans);
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }
    private long[] solve(int src , List<List<int[]>> list , int n ){
        long[] dist = new long[n];
        Arrays.fill(dist , Long.MAX_VALUE);

        PriorityQueue<long[]> queue = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        queue.offer(new long[]{src , 0});
        dist[src] = 0;

        while(!queue.isEmpty()){
            long[] curr = queue.poll();
            int node = (int) curr[0];
            long wei = curr[1];
           if(dist[node] < wei) continue;
            for(int[] next : list.get(node)){
                int nextN = next[0];
                long nextW = next[1];

                long newWei = nextW + wei;
 
                if(newWei < dist[nextN]){
                    dist[nextN] = newWei;
                    queue.offer(new long[]{nextN , newWei});
                }
            }
        }
        return dist;
    }
}