class Solution {
    public int beautySum(String s) {
       int count =0;
int n = s.length();
       for(int i =0;i<n;i++){
        int[] freq = new int[26];

        for(int j =i;j<n;j++){
             freq[s.charAt(j) - 'a']++;
             
             int max = 0;
             int min= Integer.MAX_VALUE;

             for(int index :freq){
              
                if(index > 0){
                    max = Math.max(index , max);
                    min= Math.min(index,min);
                }
             }
             count += max - min;
        }
       }
    return count;
    }

}