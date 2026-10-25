/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,Integer> height = new HashMap<>();
    Map<Integer,Integer> answer = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        calculateHeight(root);
calculate(root , 0 ,-1);
int n = queries.length;
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = answer.get(queries[i]);
        }
        return ans;
    }
    private int calculateHeight(TreeNode root ){
        if(root == null) return -1;
        int h = 1 + Math.max(calculateHeight(root.left) , 
            calculateHeight(root.right)
        );

        height.put(root.val , h);
        return h;
    } 
     private int height(TreeNode node) {
        return node == null ? -1 : height.get(node.val);
    }
    private void calculate(TreeNode root , int depth , int outSideHeight){
        if(root == null) return ;

        answer.put(root.val , outSideHeight);
        
        calculate(root.left , depth +1 ,Math.max(outSideHeight , depth + 1 + height(root.right) ) );
        calculate(root.right , depth +1 , Math.max(outSideHeight , depth +1 + height(root.left) ) );


    }
}