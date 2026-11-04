class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
       int[] index = new int[s2.length()+1];
       int[] count = new int[s2.length()+1];
       Arrays.fill(index , -1);
  int k =0;
 int total =0;
       for(int i =0;i<n1;i++){
          for(int j =0;j<s1.length();j++){
              if(s1.charAt(j) == s2.charAt(k)){
                   k++;
                   if(k==s2.length()){
                    total++;
                    k = 0;
                   }
              }
          }
          if(index[k] != -1){
             int prevIndex = index[k];
             int prevCount = count [k];

             int cycleLen = i - prevIndex;
             int cycleCount = total - prevCount;

             int cycles = n1 - i -1;
             int remain = cycles / cycleLen;
             total += (remain * cycleCount);
             i += remain * cycleLen;
          }else{
            index[k] = i;
            count[k] = total;
          }
       }
       return total / n2;
    }
}

// abc abc abc abc

// abab  