class NumArray {
int[] ans;
int[] arr;
int n;
    public NumArray(int[] nums) {
        n = nums.length;
        arr = nums;
        ans = new int[n * 4];
        build(arr , 0 ,0,n-1);
    }
    
    public void update(int index, int val) {
         arr[index] = val;
         updateTrace( 0 ,0,n-1 ,index , val) ;
    }
    
    public int sumRange(int left, int right) {
        return query( 0 , 0,n-1, left , right );
    }
    private void updateTrace(int index , int left , int right , int pos , int val){
        if(left == right){
            ans[index] = val;
            return; 
        }
        int mid = left + ( right -left)/2;

        if(pos <= mid){
            updateTrace(2 * index +1 , left , mid , pos , val);
        }else{
            updateTrace(2 * index +2 , mid+1 , right , pos , val);
        }
        ans[index] = ans[index *2 +1] + ans[2 * index +2];
        
        }
    private int query(int index , int left , int right , int l , int r){
       if (right < l || left > r) {
    return 0;
}
        if(l <= left && right <= r){
            return ans[index];
        }
        int mid = left + (right - left)/2;

        int lh = query(2 * index + 1 , left , mid , l , r);
        int rh = query(2 * index + 2 , mid+1 ,right , l , r);

        return lh + rh;
    }
    private void build(int[] nums , int index , int left , int right){
        if(left == right){
            ans[index] = nums[left];
            return;
        }
        int mid = left + ( right - left)/2;
        build(nums , 2 * index +1 , left , mid);
        build(nums , 2 * index +2 , mid +1 ,right);

        ans[index] = ans[2 * index + 1] + ans[2 * index + 2];
    }
}
