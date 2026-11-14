class Solution {

    // Set<String> set = new HashSet<>();
    public int findSubstringInWraproundString(String s) {
        
    //     for(int i =0;i<s.length();i++){
    //         solve(i , i , s);
    //     }
    //     return set.size();
    // }
    // private void solve(int start , int index , String s){
    //     if(index >= s.length()) return;

    //     if(index > start){
    //         int prev = s.charAt(index-1) -'a';
    //         int curr = s.charAt(index) -'a';

    //         if(!(curr - prev == 1 || s.charAt(index - 1) == 'z' && s.charAt(index) == 'a')) return;
    //     }
    //     set.add(s.substring(start , index+1));
    //     solve(start , index +1 , s);
    // }
        int[] dp = new int[26];
        int count = 0;
        for(int i =0;i<s.length();i++){

            if(i > 0 && (s.charAt(i) - s.charAt(i-1) == 1 || s.charAt(i-1) == 'z' && s.charAt(i) == 'a') ){
               count++;
            }else{
                count =1;
            }

            int index = s.charAt(i) - 'a';

            dp[index]  = Math.max(dp[index] ,count);
        }

        int ans =0;

        for(int num : dp){
            ans += num;
        }
        return ans;
    }
}



//