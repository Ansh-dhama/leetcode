class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        PriorityQueue<long[]> queue = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
         
         long best =0;
         long ans =0;
         Arrays.sort(rides,(a,b)->a[0]-b[0]);
         for(int[] r : rides){
            int start = r[0];
            int end = r[1];
            int tip = r[2];

            while(!queue.isEmpty() && queue.peek()[0] <= start){
                long[] curr = queue.poll();
                best = Math.max(best , curr[1]);
            }

            long total = best + (end - start + tip);
            queue.offer(new long[]{end , total});
            ans = Math.max(ans , total);
         }
return ans;
    }
}