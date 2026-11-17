class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        
        int n =edges.size();

        int[] indegree = new int[n];
       

        for(int i =0;i<n;i++){
            indegree[edges.get(i)]++;
        }
        Queue<Integer> queue= new ArrayDeque<>();
       List<Integer> order = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();

            int next = edges.get(curr);
            order.add(curr);
            indegree[next]--;

            if(indegree[next] == 0) {
                queue.offer(next);
            }
        }
 int[] ans = new int[n];
        boolean[] visit = new boolean[n];

        for(int i =0;i<n;i++){
            if(indegree[i] > 0 && !visit[i]){
                int curr = i;
                int count =0;
 
                while(!visit[curr]){
                    count++;
                    visit[curr] =true;
                    curr = edges.get(curr);
                }
                curr = i;
                for(int j=0;j<count;j++){
                    ans[curr] = count;
                    curr = edges.get(curr);
                }
            }
        }

        for(int i =order.size()-1;i>=0;i--){
            int curr  = order.get(i);
            if(ans[curr] == 0){
                ans[curr] = 1 + ans[edges.get(curr)];
            }
        }

        return ans;


    }
}


// first find the count of child and then add to parent