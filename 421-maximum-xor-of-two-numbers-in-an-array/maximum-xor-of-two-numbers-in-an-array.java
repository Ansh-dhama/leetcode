class Solution {
    static class TrieNode{
        TrieNode[] children = new TrieNode[2];
    }
    TrieNode root;
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
root = new TrieNode();
        for(int num : nums){
            insert(num);
        }
        for(int num : nums){
            ans = Math.max(ans , maxFind(num));
        }
        return ans;
    }
    private void insert(int num){
        TrieNode current = root;

        for(int i = 30 ;i>=0;i--){
            int bit = (num >> i) & 1;

            if(current.children[bit] == null){
                current.children[bit] = new TrieNode();
            }
            current = current.children[bit];
        }
    }
    private int maxFind(int num){
        TrieNode current = root;
        int result =0;

        for(int i =30;i>=0;i--){
            int bit = (num >> i) & 1;
            int opposite = bit ^ 1;
            if(current.children[opposite] != null){
               result = result | (1 << i);
               current = current.children[opposite];
            }else{
                current = current.children[bit];
            }
        }
        return result;
    }
}