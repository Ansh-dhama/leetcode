class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num * 9) return "";
        StringBuilder str = new StringBuilder();

        for(int i =0;i < num ; i++){
            int cur = (sum > 9) ? 9 : sum;
            str.append((char) ( '0' + cur ));

            sum -= cur;
        }
        return str.toString();
    }
}