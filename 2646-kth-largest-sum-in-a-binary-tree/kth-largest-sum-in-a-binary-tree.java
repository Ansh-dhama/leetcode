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
    public long kthLargestLevelSum(TreeNode root, int k) {
        

        Queue<TreeNode> queue = new ArrayDeque<>();
List<Long> list = new ArrayList<>();
queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
long currSum =0;
            for(int i =0;i<size;i++){
                TreeNode curr = queue.poll();

                currSum +=(long) curr.val;

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);

            }
            list.add(currSum);
        }
        if(list.size() < k) return -1;
        Collections.sort(list);
        return list.get(list.size() - k);
    }
}