class Solution {
    public String removeDuplicateLetters(String s) {
      int[] last = new int[26];

      for(int i =0;i<s.length();i++){
        char ch = s.charAt(i);
        int index = ch - 'a';
        last[index] = i;
      }

       boolean[] visit = new boolean[26];
        StringBuilder str = new StringBuilder();

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            int index = ch - 'a';

            if(visit[index]) continue;

            while(!str.isEmpty() && ch < str.charAt(str.length()-1) && last[str.charAt(str.length()-1) - 'a'] > i){
                visit[str.charAt(str.length()-1) - 'a']  = false;
str.deleteCharAt(str.length()-1);
            }

            str.append(ch);
            visit[index] = true;
        }
        return str.toString();
    }
}