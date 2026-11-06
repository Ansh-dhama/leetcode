class Solution {
    int count =0;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
           List<List<Integer>> list = new ArrayList<>();

           for(int i =0;i<n;i++){
              list.add(new ArrayList<>());
           }
           for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            list.get(from).add(to);
            list.get(to).add(from);
           }

           boolean[] visit =new boolean[n];
           for(int num :restricted){
            visit[num] = true;
           }
           solve(0 , -1 , list , visit);

           return count + 1;
    }
    private void solve(int city , int parent , List<List<Integer>> list , boolean[] visit){
        visit[city] = true;

        for(int next : list.get(city)){
            if(next == parent) continue;

            if(!visit[next]){
              count++;
              solve(next , city , list , visit);
            }
        }
    }
}