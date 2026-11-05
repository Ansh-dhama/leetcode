class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
int i =0;
        for(int[] q : queries){
            int a = q[0];
            int b = q[1];

            int count =0;

            while(a != b){
                if(a > b){
                    a/=2;
                }else{
                    b /= 2;
                }
                count++;
            }
            ans[i++] = ++count;
        }
        return ans;
    }
}

// 2 + 1 + 0+1