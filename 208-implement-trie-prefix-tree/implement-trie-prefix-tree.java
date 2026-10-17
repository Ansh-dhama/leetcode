class Trie {
TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
         for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.endOfWord;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String text) {
        TrieNode current = root;

        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';

            current = current.children[index];

            if (current == null) {
                return null;
            }
        }

        return current;
    }
    static class  TrieNode{
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