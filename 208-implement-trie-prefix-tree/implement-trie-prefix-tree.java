class Trie {
TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int index = ch -'a';

            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.endOfWord = true;
    }
    
    public boolean search(String word) {
         TrieNode current = root;
        for(char ch : word.toCharArray()){
            int index = ch -'a';

            if(current.children[index] == null){
               return false;
            }
            current = current.children[index];
        }
        return current.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return true;

    }
    class TrieNode{
        TrieNode[] children;
        boolean endOfWord;


        TrieNode(){
            children = new TrieNode[26];
            endOfWord = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */