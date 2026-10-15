class Solution {
    public int sumCounts(List<Integer> nums) {
        int answer =0;
     HashSet<Integer> set = new HashSet<>();
List<Integer> result = new ArrayList<>();
     for(int i=0;i<nums.size();i++){
        // result.add(0);
        for(int j =i;j<nums.size();j++){
            set.add(nums.get(j));
            result.add(set.size());

        }
     set.clear();
     }   

     for(int num : result){
        answer += num *num;
     }
     return answer;


    }
}