class Solution {
    Trie root;
    List<List<String>> ans;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Trie();

        for(String curr : products){
            insert(curr);
        }
ans = new ArrayList<>();
StringBuilder st = new StringBuilder();
        for(char ch : searchWord.toCharArray()){
st.append(ch);
        ans.add(search(st.toString(), root));
        }

        return ans;
    }
    public List<String> search(String word , Trie root){
        Trie current = root;
List<String> suggestions = new ArrayList<>();
        for(char ch : word.toCharArray()){
            int index = ch -'a';

            if(current.children[index] == null) return suggestions ;

            current = current.children[index];
        }
        addWord(current , suggestions);
       return suggestions;
    }
    public void addWord(Trie current, List<String> suggestions){
        
        if(suggestions.size() == 3) return ;

        if(current.endOfWord) suggestions.add(current.word);

        for(int i =0;i<26 && suggestions.size() < 3 ;i++){
            if(current.children[i] != null){
                addWord(current.children[i] , suggestions);
            }
        }
     
    }
    public void insert(String word){
        Trie current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null) {
                current.children[index] = new Trie();
            }
            current = current.children[index];
        }
        current.endOfWord = true;
        current.word = word;
    }
    class Trie{
        Trie[] children;
        boolean endOfWord;
        String word;
        Trie(){
            children = new Trie[26];
            endOfWord = false;
            word = null;
        }
    }
}