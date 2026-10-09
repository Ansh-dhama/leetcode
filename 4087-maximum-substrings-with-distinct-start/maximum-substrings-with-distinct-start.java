class Solution {
    public int maxDistinct(String s) {
        int[] freq = new int[26];
int count =0;
        for(int i =0;i<s.length();i++){
          if(freq[s.charAt(i) - 'a'] == 0){
            count++;
          }
          freq[s.charAt(i) - 'a']++;
        }
        return count;
    }
}