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
    int[] levelSum = new int[100001];
    public TreeNode replaceValueInTree(TreeNode root) {
        dfs1(root , 0);
root.val = 0;
        dfs2(root, 0);
        return root;
    }
    private void dfs1(TreeNode root , int depth){
        if(root == null) return;

        levelSum[depth] += root.val;

        dfs1(root.left, depth+1);
        dfs1(root.right , depth+1);
    }
    private void dfs2(TreeNode root , int depth){
        if(root == null) return;

        int siblingSum = 0;

        if(root.left != null) {
            siblingSum += root.left.val;
        }
        if(root.right != null){
            siblingSum += root.right.val;
        }
        if(root.left != null){
            root.left.val = levelSum[depth +1] - siblingSum;
            dfs2(root.left , depth +1);
        }
        if(root.right != null){
            root.right.val = levelSum[depth+1] - siblingSum;
            dfs2(root.right, depth+1);
        }
    }
}