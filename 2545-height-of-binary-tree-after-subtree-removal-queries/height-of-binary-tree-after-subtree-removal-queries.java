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
    Map<TreeNode,Integer> height = new HashMap<>();
    Map<Integer,Integer> answer = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
          calculateHeight(root);
          calculate(root , 0, -1);
          int[] ans = new int[queries.length];
          for(int i =0;i<queries.length;i++){
            ans[i] = answer.get(queries[i]);
          }
          return ans;
    }
    private int calculateHeight(TreeNode root){
        if(root == null) return -1;

        int h = 1 + Math.max(calculateHeight(root.left) , calculateHeight(root.right));

        height.put(root ,h );

        return h;
    }
    private int height(TreeNode root){
        return root == null ? -1 : height.get(root);
    }
    private void calculate(TreeNode root , int depth , int outSide){

        if(root == null) return;

        answer.put(root.val , outSide);

        calculate(root.left , depth +1 , Math.max(outSide , depth +1 + height(root.right)));

        calculate(root.right , depth +1 , Math.max(outSide , depth +1 + height(root.left)));

    }
}