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
    int maxPath =0;
    public int longestUnivaluePath(TreeNode root) {
         solve(root);
      return maxPath;
    }
    public int solve(TreeNode root){
        if(root == null )return 0;
        int lh = solve(root.left);
        int rh = solve(root.right);
        int leftP= 0;
        int rightP =0;
        
        if(root.left != null && root.val == root.left.val){
           leftP = lh + 1;
        }
        if(root.right != null && root.val == root.right.val){
           rightP = rh +1;
        }
 maxPath = Math.max(leftP + rightP , maxPath);
        return Math.max(leftP , rightP);
    }
}