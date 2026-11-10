class Solution {
    
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
         List<List<int[]>> list = new ArrayList<>();
int n = passingFees.length;
         for(int i =0;i < n;i++){
            list.add(new ArrayList<>());
         }    
         for(int[] e : edges){
            int form = e[0];
            int to = e[1];
            int time = e[2];

            list.get(form).add(new int[]{to , time});
            list.get(to).add(new int[]{form , time});
         }

         PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
              if(a[2] != b[2]){
                return Integer.compare(a[2],b[2]);
              }
              return Integer.compare(a[1],b[1]);
         });

         queue.offer(new int[]{0,0 , passingFees[0]});

         int target = n-1;
int[][] dist = new int[n][maxTime+1];
for(int[] row : dist){
Arrays.fill(row , Integer.MAX_VALUE);

}
dist[0][0]= passingFees[0];
         while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0];
            int time = curr[1];
            int fees = curr[2];
           
           if(fees > dist[node][time]) continue;

            for(int[] ne : list.get(node)){
                int next = ne[0];
                int newTime = ne[1] + time;
            
                if(newTime > maxTime) continue;
               int newCost = fees + passingFees[next];
                if(newCost < dist[next][newTime]){
                    dist[next][newTime] = newCost;
                    queue.offer(new int[]{next ,newTime ,newCost});
                }
            }
         }

         int ans = Integer.MAX_VALUE;

         for(int t =0; t<= maxTime; t++){
      ans = Math.min(dist[target][t], ans);
         }
         return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}