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
    public TreeNode createBinaryTree(int[][] descriptions) {
       HashMap<Integer,TreeNode> parent = new HashMap<>();
       HashSet<Integer> set = new HashSet<>();

       for(int[] desc : descriptions){
          int node = desc[0];
          int child = desc[1];
          int left =desc[2];
          parent.putIfAbsent(node, new TreeNode(node));
          parent.putIfAbsent(child, new TreeNode(child));

         
          if(left == 1){
            parent.get(node).left = parent.get(child);
          }else{
            parent.get(node).right= parent.get(child);
          }

          set.add(child);
       }
       for(int[] desc : descriptions){
          if(!set.contains(desc[0])){
            return parent.get(desc[0]);
          }
       }
       return null;
    }
} 