class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        Arrays.fill(ans , -1);

        int max = 0;
        for(int num : nums){
            if(set.contains(num)){
                ans[0] = num;
            }
            set.add(num);
            max = Math.max(max , num);
        }
        
        for(int i =1;i<=max;i++){
            if(!set.contains(i)){
                ans[1] = i;
                break;
            }
        }
        if(ans[1] == -1) ans[1] = max+1;
        return ans;
        
    }
}