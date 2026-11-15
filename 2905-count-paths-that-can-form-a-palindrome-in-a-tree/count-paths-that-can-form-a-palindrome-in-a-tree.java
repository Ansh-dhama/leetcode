class Solution {
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = s.length();

        List<List<Integer>> tree = new ArrayList<>();
        for(int i =0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int i =1;i<n;i++){
            tree.get(parent.get(i)).add(i);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] mask = new int[n];

        while(!stack.isEmpty()){
            int curr = stack.pop();
            
            for(int child : tree.get(curr)){

                int bit = 1 << (s.charAt(child)- 'a');

                mask[child] = mask[curr] ^ bit;

                stack.push(child);
            }
        }

        HashMap<Integer , Long > freq = new HashMap<>();
long ans =0;
        for(int m : mask){

            ans += freq.getOrDefault(m , 0L );

            for(int i =0;i<26;i++){
                 int newMask = m ^ (1 << i);
                 

                 ans += freq.getOrDefault(newMask , 0L); 
            }
            freq.put( m , freq.getOrDefault(m , 0L )+1);
        }
        return ans;

    }
}