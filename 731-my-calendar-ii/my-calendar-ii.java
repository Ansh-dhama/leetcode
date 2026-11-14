class MyCalendarTwo {
    class Node{
        Node left,right;
        int max = 0;
        int lazy = 0;
    }
     private static final int MIN = 0;
    private static final int MAX = 1_000_000_000;
      Node root;
    public MyCalendarTwo() {
      root = new Node();
    }
    
    public boolean book(int startTime, int endTime) {
        int left = startTime;
        int right = endTime - 1;

      
        if (query(root, MIN, MAX, left, right) >= 2) {
            return false;
        }
        update(root, MIN, MAX, left, right);

        return true;
    }
    private int query(Node node , int left , int right , int l , int r){
        if(node == null || left > r || right < l) return 0;

        if(l <= left && right <= r){
            return node.max;
        }
        push(node);
        
        int mid = left + (right - left)/2;

        int lh = query(node.left , left , mid , l , r);
        int rh = query(node.right , mid+1 , right , l ,r);

        return Math.max(lh, rh);
    }
    private void  update(Node node , int left , int right, int  l , int r){
      if(node == null || left > r || right < l) return;

        if(l <= left && right <= r){
            node.max++;
            node.lazy++;
            return ;
        }
        push(node);
        
        int mid = left + (right - left)/2;
         if(l <= mid){
 update(node.left , left , mid , l , r);
         }
        if(r > mid){
   update(node.right , mid+1 , right , l ,r);
        }
         node.max = Math.max(node.left.max , node.right.max);
    }
    private void push(Node node){
        if(node.left ==  null) node.left = new Node();
        if(node.right == null ) node.right = new Node();

        if(node.lazy != 0){
            node.left.max += node.lazy;
            node.left.lazy += node.lazy;

            node.right.max += node.lazy;
            node.right.lazy += node.lazy;

            node.lazy = 0;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */