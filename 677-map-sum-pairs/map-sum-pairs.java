class MapSum {
       Map<String , Integer> map;
       Trie root;
    public MapSum() {
        root = new Trie();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int prev = map.getOrDefault(key,0);
        int diff = val - prev;
        map.put(key , val);
       
        Trie current = root;
        for(char ch : key.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null){
                current.children[index] = new Trie();
            }
            current = current.children[index];

            current.sum += diff;
        }
    }
    
    public int sum(String prefix) {
        Trie current = root;

        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null){
                return 0;
            }
            current = current.children[index];
        }
        return current.sum;
    }
    class Trie{
        Trie[] children;
        int sum ;

        Trie(){
            children = new Trie[26];
            sum =0;
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */