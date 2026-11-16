class Solution {
    public String digitSum(String s, int k) {
          
          String curr = s;     
          while(curr.length() > k){
              StringBuilder str = new StringBuilder();
               for(int i = 0;i<curr.length();i+=k){
                   String c = curr.substring(i,Math.min(i+k,curr.length()));
                   long value = solve(c);
                   str.append(value);
               }
         
               curr = str.toString();
               if(curr.length() == k) return curr;
          }

          return curr;
    }
    private long solve(String s ){
        
        long ans =0;

        for (int i = 0; i < s.length(); i++) {
            ans += s.charAt(i) - '0';
        }

        return ans;
    }
}