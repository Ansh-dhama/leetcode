class Solution {
    public int largestVariance(String s) {

      int ans =0;
      for(char ch1 = 'a' ;ch1<='z';ch1++){
        for(char ch2 = 'a'; ch2<= 'z'; ch2++){
           int minor =0;
           int major =0;
           int remain = 0;

           for(char ch3 :s.toCharArray()){
               if(ch3 == ch2){
                 remain++;
               }
           }

           for(char ch3 : s.toCharArray()){
              if(ch3 == ch1  ) major++;

              if(ch3 == ch2) {
                minor++;
                remain--;
              }

              if(minor > 0) {
                ans = Math.max(ans , major - minor);
              }

              if(minor > major && remain > 0){
                 minor =0;
                 major =0;
              }
           }
        }
    }
    return ans;
    }
}