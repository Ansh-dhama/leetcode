class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1<<10];

        count[0] =1;
        int mask =0;
long ans =0;
        for(char ch : word.toCharArray()){
            int index = (1 << (ch - 'a'));
              mask ^= index;

            ans +=count[mask];

            for(int i =0;i<10;i++){
                int newMask = mask ^ (1 << i);
                ans += count[newMask];
            } 
            count[mask]++;
        }

        return ans;
    }
}