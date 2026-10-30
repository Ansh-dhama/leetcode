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
    int index = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return build(traversal , 0);
    }
    private TreeNode build(String traversal  , int depth){
        int j = index;
        int count =0;
        
        while(j < traversal.length() && traversal.charAt(j) == '-'){
            count++;
            j++;
        }
        if(count != depth) return null;

        index = j;
        int num = 0;

        while(index < traversal.length() && Character.isDigit(traversal.charAt(index)) ){
            num = num * 10 + (traversal.charAt(index) - '0');
            index++;
        }

        TreeNode root = new TreeNode(num);
        root.left = build(traversal , depth + 1 );
        root.right = build(traversal , depth + 1);

        return root;
    }
}