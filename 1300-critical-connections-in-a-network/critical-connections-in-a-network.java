class Solution {
    private int timer =0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> list = new ArrayList<>();
         
        for(int i =0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(List<Integer> next:connections ){
            int from = next.get(0);
            int to = next.get(1);

            list.get(from).add(to);
            list.get(to).add(from);
        }
        int[] discover = new int[n];
        Arrays.fill(discover , -1);
        int[] low = new int[n];

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(discover[i] == -1){
                bridge(
                    i , 
                    -1,
                    discover ,
                    low ,
                    list , 
                    ans
                );
            }
        }
        return ans;
    }
    private void bridge(int node , int parent ,int[] discover ,int[] low , List<List<Integer>> list , List<List<Integer>> ans){
        discover[node] = timer;
        low[node]= timer;
        timer++;

        for(int next : list.get(node)){
            if(next == parent) continue;
            if(discover[next]==-1){
                bridge(next , node , discover , low , list , ans);

                low[node] = Math.min(low[node] , low[next]);

                if(low[next] > discover[node]){
                    ans.add(Arrays.asList(node , next));
                }
            }
             else {
             
                low[node] = Math.min(
                    low[node],
                    discover[next]
                );
            }
        }
    }
}