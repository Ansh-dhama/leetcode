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
    Map<Integer,Integer> map;
    int count =0;
    public int pseudoPalindromicPaths (TreeNode root) {
        map = new HashMap<>();
       solve(root);
       return count;
    }
    private void solve(TreeNode root){
        if(root == null) return;

        map.put(root.val ,  map.getOrDefault(root.val , 0)+1);

        if(root.left == null && root.right == null){
            if(isCheck()){
                count++;
            }
        }
        solve(root.left);
        solve(root.right);

        map.put(root.val , map.getOrDefault(root.val , 0)-1);
        if(map.get(root.val) ==0) map.remove(root.val);
    }
    private boolean isCheck(){
        int even =0;
        int one = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int value= entry.getValue();

            if(value % 2 == 1) one++;
            if(value % 2 == 0) even++;
        }
        return one <=1;
    }
}