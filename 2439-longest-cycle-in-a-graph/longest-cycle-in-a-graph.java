class Solution {
    int count =-1;
    public int longestCycle(int[] edges) {
    int n = edges.length;
    boolean[] visit = new boolean[n];
    int[] dist = new int[n];

        for(int i =0;i<n ;i++){
            if(!visit[i]){
             solve(edges[i] ,1,visit ,dist ,edges);
            }
        }
        return count;
    }
    private void solve(int city ,int step , boolean[] visit, int[] dist , int[] list){
        if(city == -1) return;
        visit[city] = true;
        dist[city]= step;

        int next = list[city];
        if(next != -1){
           if( !visit[next]) {
                solve(next , step+1 , visit , dist , list);
            }else if (dist[next] > 0){
                count = Math.max(count , step - dist[next]+1);
            }    
        }
        dist[city] = 0;
    }
    
}