class Solution {
    class Trie{
       Trie[] children = new Trie[26];
       boolean endOfWord;
    }
    Trie root;


    public int numMatchingSubseq(String s, String[] words) {
        root = new Trie();

        build(s);
        int count =0;
        for(String str : words){
            if(serach(str)){
                count++;
            }
        }
        return count;
    }



    private void build(String s) {
     int n = s.length();

     Trie[] node = new Trie[n+1];
      
     for(int i =0;i<n+1;i++){
        node[i] = new Trie();
     }
     int[] next = new int[26];

     Arrays.fill(next , -1);
     
    for(int i =n ;i>=0;i--){

        if(i < n ){
            int index = s.charAt(i) - 'a';
            next[index] = i;
        }

        for(int j = 0;j<26;j++){
            if(next[j] != -1){
              node[i].children[j] = node[next[j] +1];
            }
        }
    }
    root = node[0];
}




    private boolean serach(String s ){
        
        Trie curr = root;
        for(char ch : s.toCharArray()){
            int index = ch - 'a';

            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }
}