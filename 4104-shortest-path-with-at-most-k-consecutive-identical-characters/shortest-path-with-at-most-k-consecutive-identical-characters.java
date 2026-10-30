class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        

        List<List<int[]>> list = new ArrayList<>();


        for(int i =0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int from =e[0];
            int to = e[1];
            int wei = e[2];
           list.get(from).add(new int[]{to, wei});
        }

 long[][] dist = new long[n][k + 1];

        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }


        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)-> a.wei - b.wei);
        queue.offer(new Pair(0 , 0  , 1));
         dist[0][1] = 0;
        while(!queue.isEmpty()){
             Pair curr = queue.poll();
             int node = curr.node;
             int wei = curr.wei;
             int consec = curr.consec;
             if (wei != dist[node][consec]) {
                continue;
            }
            if (node == n - 1) {
                return (int) wei;
            }

             for(int[] next : list.get(node)){
                int nextN = next[0];
                int nextWei = next[1];
                int step = consec;
                char lastCh = labels.charAt(node);
                if(lastCh == labels.charAt(nextN)){
                   step++;
                }else{
                    step = 1;
                }
                if(step > k) continue;

                int newDist = nextWei+ wei;

                if(newDist < dist[nextN][step]){
                    dist[nextN][step] = newDist;
                    queue.offer(new Pair(nextN , newDist , step));
                }
             }
        }

        return -1;
    }
    class Pair{
        int node;
        int wei;
        int consec;

        Pair(int node , int wei, int consec){
            this.node = node;
            this.wei = wei;
            this.consec = consec;
        }
    }
}