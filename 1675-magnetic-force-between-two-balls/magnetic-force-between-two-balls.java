class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left =0;
        int ans= 0;
        int right = position[position.length -1] - position[0];
        while(left<= right){
            int mid = left + (right- left) /2;

            if(isValid(position , m , mid)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
    private boolean isValid(int[] position , int m , int mid){
        int count =1;
          int lastPosition = position[0];
        for(int i =1;i<position.length;i++){
            
            if( position[i]  - lastPosition >= mid){
                count++;
                lastPosition = position[i];
            }

            if(count == m) return true;
            
        }
        return count >= m;
    }
}