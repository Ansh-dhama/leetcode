class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        

           

               long left =0;
        long right = 1_000_000_000L;
                long ans =0;
               while(left <= right){
                long mid = left + (right - left)/2;

                if(check(mid , budget , composition , stock , cost)){
                    ans =mid;
                    left = mid+1;
                }else{
                    right = mid-1;
                }
               }

               return (int) ans; 

    }

    private boolean check(long k , int budget , List<List<Integer>> composition, List<Integer> stock, List<Integer> cost ){

        
        for(List<Integer> compos :composition){
               long n = compos.size();
               long currCost = 0;
                 
                 for(int i = 0;i<n;i++){
                     long curr = (compos.get(i) * k) - stock.get(i);

                     currCost += Math.max(0 , curr * cost.get(i));
                      
                     if(currCost > budget) break;
                   
                 }

              if(currCost <= budget) return true;
        }
        return false;
    }
    
}


// required = ( stock - composition) * cost;
