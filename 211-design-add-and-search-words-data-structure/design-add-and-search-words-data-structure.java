class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie current = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null){
                current.children[index] = new Trie();
            }
            current = current.children[index];
        }
        current.endOfWord  = true;
    }
    
    public boolean search(String word) {
       return  serachWord(word , 0 , root);
    }
    private boolean serachWord(String word , int index, Trie current){
       
       for(int i = index ; i< word.length();i++){
        char ch = word.charAt(i);
          if(ch == '.'){
             for(Trie child : current.children ){
                  if(child != null && serachWord(word , i+1 , child)){
                    return true;
                  }
             }
             return false;
          }

        int in = ch - 'a';

          if(current.children[in] == null){
            return false;
          }
          current = current.children[in];
       }
       return current.endOfWord;
    }
    class Trie{
        Trie[] children;
        boolean endOfWord;

        Trie(){
            children = new Trie[26];
            endOfWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */