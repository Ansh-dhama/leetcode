import java.util.*;

class Solution {
    public int findShortestCycle(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
int ans = Integer.MAX_VALUE;
       for(int i =0;i<n;i++){
          int[] dist = new int[n];
          Arrays.fill(dist , -1);
          int[] parent = new int[n];
          Arrays.fill(parent ,-1);


        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(i) ;
dist[i] =0;
        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int next : graph.get(curr)){
                if(dist[next] == -1){
                    dist[next] = dist[curr]+1;
                    parent[next] =curr;
                    queue.offer(next);
                }else if(parent[curr] != next){
                    ans = Math.min(ans , dist[curr] +dist[next]+1);
                }
            }
        }       
     }
  return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}