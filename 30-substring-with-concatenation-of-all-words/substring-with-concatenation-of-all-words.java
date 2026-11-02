class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String , Integer> freq = new HashMap<>();
    
        for(String curr : words){
            freq.put(curr , freq.getOrDefault(curr,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        int windowSize = words.length * words[0].length();
        int wordSize =  words[0].length();
        
        for(int offset =0;offset< wordSize;offset++){
            int left = offset;

            int count =0;
 Map<String, Integer> currMap = new HashMap<>();

            for(int i =offset;i + wordSize<= s.length();i+= wordSize){
                 String curr = s.substring(i , i+wordSize);

                 if(!freq.containsKey(curr)){
                    currMap.clear();
                    left = i + wordSize;
                    count =0;
                    continue;
                 }

                 currMap.put(curr , currMap.getOrDefault(curr , 0)+1);

                 count++;

                 while(currMap.get(curr) > freq.get(curr)){
                    String l = s.substring(left , left+wordSize);
                    currMap.put(l , currMap.getOrDefault(l,0)-1);
                    left += wordSize;
                    count--;
                 }

                 if(count == words.length){
                    list.add(left);
                    String leftWord = s.substring(left,left + wordSize);
                    currMap.put(leftWord , currMap.get(leftWord)-1);
                    left += wordSize;
                    count--;
                 }
            }
        }
        return list;
    }
}