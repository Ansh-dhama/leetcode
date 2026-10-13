class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
int operation =0;
int ball =0;
       for(int i =0;i<n;i++){
         answer[i] += operation;
        
         if(boxes.charAt(i) == '1'){
            ball++;
         }
         
       operation += ball ;
       }
       operation =0;
        ball =0;
       for(int i =n-1;i>=0;i--){
         answer[i] += operation;
         if(boxes.charAt(i) == '1'){
            ball++;
         }    
       operation += ball ;
       }
       return answer;
    }
}