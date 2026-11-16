class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int ans =0;

        if(x > y){
            
            String curr = removePattern(s , 'a' , 'b');

            int remain = (s.length() - curr.length()) /2;
            
            ans += (remain * x);

            String second = removePattern(curr , 'b' , 'a');

            int remain2  = (curr.length() - second.length())/2;

            ans += (remain2 * y); 
        }else{
            String curr = removePattern(s , 'b' , 'a');

            int remain = (s.length() - curr.length()) /2;
            
            ans += (remain * y);

            String second = removePattern(curr , 'a' , 'b');

            int remain2  = (curr.length() - second.length())/2;

            ans += (remain2 * x); 
        }
        return ans;
    }
    private String removePattern(String s , char first , char second){
        StringBuilder stack = new StringBuilder();
        for(char ch : s.toCharArray()){

            if( !stack.isEmpty() && stack.charAt(stack.length() - 1) == first && ch == second){
                 stack.deleteCharAt(stack.length()-1);
            }else{
                stack.append(ch);
            }
        }
        return stack.toString();
    }
}
// c  d b c b b a a a b a b 