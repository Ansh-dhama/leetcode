class Solution {
    List<List<Integer>> tree =new ArrayList<>();
int ans = 0;
long max =0;
int n;
    public int countHighestScoreNodes(int[] parents) {
         n =parents.length;

          for(int i =0;i<n;i++){
            tree.add(new ArrayList<>());
          }    
          for(int i= 1;i<n;i++){
            tree.get(parents[i]).add(i);
          }

          dfs(0);

          return ans;
    }

    private int dfs(int node){
        int subTree = 1;
        long score = 1;

        for(int child : tree.get(node)){
            int childSize = dfs(child);

            subTree += childSize;
            score *= childSize;
        }

        int remain = n - subTree;

        if(remain > 0){
            score *= remain;
        }

        if(score > max){
            max = score;
            ans =1;
        }else if(max == score){
            ans++;
        }
        return subTree;
    }
}