class Solution {
    public String maxSumOfSquares(int num, int sum) {
        
        StringBuilder str = new StringBuilder();
     
        if(sum > 9 * num) return ""; 

        for(int i =1;i<=num;i++){
            int temp = (sum < 9 )? sum : 9;
            str.append( (char)('0' + temp)); 
            sum -= temp;
        }
        return str.toString();
    }
}