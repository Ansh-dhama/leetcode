
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
      Queue<TreeNode> queue = new ArrayDeque<>();

      queue.offer(root);
      boolean even = true;

      while(!queue.isEmpty()){
          int size = queue.size();
          int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;

          for(int i =0;i<size;i++){
            TreeNode curr = queue.poll();
             
            if(even){
                if(curr.val % 2 == 0 || prev >= curr.val) return false;
            }else{
                if(curr.val % 2 != 0 || prev <= curr.val) return false;
            }

            if(curr.left != null){
                queue.offer(curr.left);
            }
             if(curr.right != null){
                queue.offer(curr.right);
            }
            prev = curr.val;

          }
          even = !even;
      }  

      return true;      
    }
}