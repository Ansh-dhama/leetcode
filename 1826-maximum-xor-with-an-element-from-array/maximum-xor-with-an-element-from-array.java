class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[2];
    }
    TrieNode root;
    public int[] maximizeXor(int[] nums, int[][] queries) {
         
         Arrays.sort(nums);
        
        int[][] q = new int[queries.length][3]; 
int k = 0; 

for (int[] query : queries) {
    int x = query[0];
    int m = query[1];
        q[k] = new int[]{x, m, k}; 
    k++; 
}
Arrays.sort(q, (a, b) -> Integer.compare(a[1], b[1]));

 int[] ans = new int[queries.length];
 root = new TrieNode();
         int i = 0;
         for(int[] queue : q     ){
            int x = queue[0];
            int m  = queue[1];
            int index = queue[2];
            
            while(i < nums.length && nums[i] <= m){
                insert(nums[i]);
                i++;
            }
ans[index] = (i == 0) ? -1 : findMax(x);
         }
         return ans;

    }
    public void insert(int num ){
        TrieNode current = root;

        for(int i = 30;i>=0;i--){
            int bit = (num >> i) & 1;

            if(current.children[bit] ==null){
                current.children[bit] = new TrieNode();
            }
            current = current.children[bit];
        }
    }
    public int findMax(int num ){
        int result =0;
        TrieNode current = root;

        for(int i =30;i>=0;i--){
            int bit = (num >> i )&1;
            int oppo= bit ^ 1;

            if(current.children[oppo] != null){
                result |= (1 << i );
                current = current.children[oppo];
            }else{
                current = current.children[bit];
            }

        }
        return result;
    }
}