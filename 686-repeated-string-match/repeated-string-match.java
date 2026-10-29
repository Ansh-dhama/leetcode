class Solution {
   
    public int repeatedStringMatch(String a, String b) {
      StringBuilder str = new StringBuilder();

      str.append(a);
      int count =1 ;
      while(str.length() < b.length()){
        str.append(a);
        count++;
      }   
      if(str.indexOf(b) != -1 ){
        return count;
      }

      str.append(a);

      if(str.indexOf(b) != -1) return count +1;
       
       return -1;
    }
}