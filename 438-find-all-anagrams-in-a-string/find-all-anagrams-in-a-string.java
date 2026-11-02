class Solution {
    // public List<Integer> findAnagrams(String s, String p) {
    //    Map<Character , Integer> map = new HashMap<>();

    //     int left =0;
    //     List<Integer> ans = new ArrayList<>();
        
    //     for(char ch : p.toCharArray()){
    //        map.put(ch , map.getOrDefault(ch , 0)+1);
    //     }
    //     int n = p.length();

    //     for(int i =0;i<p.length();i++){
    //         int left =i;
    //         Map<Character , Integer> curr = new HashMap<>();
    //         int count =0;
    //         for(int right = i;right + p<= s.length;right++){
    //                 String st = s.substring(right , right + n);

    //                 for(char next : st.toCharArray()){
    //                     if(!map.containsKey(next)){
    //                         count =0;
    //                         curr.clear();
    //                         left = right + n;
    //                         continue;
    //                     }
                       
    //                 }

    //                 for(char next : st.toCharArray()){
    //                   curr.put(next , curr.getOrDefault(curr ,0)+1);
    //                      count++;

    //                      while(curr.get(next) > map.get(next)){
    //                          char  = s.charAt(i)
    //                      }
    //                 }

                    
                   

    //         }
    //     }

        
    // }

    public List<Integer> findAnagrams(String s, String p) {
    Map<Character , Integer> map = new HashMap<>();

        int left =0;
        List<Integer> ans = new ArrayList<>();
        
        for(char ch : p.toCharArray()){
           map.put(ch , map.getOrDefault(ch , 0)+1);
        }
        int n = p.length();
        Map<Character , Integer> curr = new HashMap<>();
        int count = 0;
        for(int right = 0;right  < s.length();right++){
            char ch = s.charAt(right);

            if(!map.containsKey(ch)){
                left = right+1;
                count = 0;
                curr.clear();
                continue;
            }
            curr.put(ch , curr.getOrDefault(ch , 0)+1);
            count++;
            
            while(curr.get(ch) > map.get(ch)){
                char lc = s.charAt(left);
                curr.put(lc , curr.getOrDefault(lc , 0)- 1);
                if(curr.get(lc) == 0) curr.remove(lc);
                left++;
                count--;
            }
            if(count == n){
                ans.add(left);
                char lc = s.charAt(left);
                curr.put(lc , curr.getOrDefault(lc,0)-1);
                count--;
                left++;
            }
        }
        return ans;
    } 
}