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
    public int minimumOperations(TreeNode root) {
        

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
       int count =0;
        while(!queue.isEmpty()){
            int size = queue.size();
       List<Integer> list = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode curr = queue.poll();
                 list.add(curr.val);
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null ){
                    queue.offer(curr.right);
                }
            }
            count += checkSwap(list);
        }
        //7 ,6, 8, 5 , 7,6,8,5

        return count;
    }
    private int checkSwap(List<Integer> list){
        int swap =0;
       Map<Integer,Integer> map = new HashMap<>();

       for(int i =0;i<list.size();i++){
        map.put(list.get(i) , i);
       }
       List<Integer> list2 = new ArrayList<>(list);

       Collections.sort(list2);

       for(int i =0;i<list2.size();i++){
          if(!list2.get(i).equals(list.get(i))){
             
             int ind = map.get(list2.get(i));

             int temp = list.get(ind);
             list.set(ind , list.get(i));
             list.set(i , temp);

             map.put(temp , i);
             map.put(list.get(ind) , ind);

             swap++;
          }
       }
         
        return swap;
    }
}