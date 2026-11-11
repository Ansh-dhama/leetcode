class Solution {
    HashMap<String , Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
      
        int ans = 0;
        // for(int i=0;i<needs.size();i++){
        //     ans += ( needs.get(i) * price.get(i));
        // }

        // for(int i =0;i<special.size();i++){
        //      List<Integer> curr = special.get(i);

        //       int currP = curr.get(n);
        //      for(int j =0;j<needs.size();j++){
        //         int left = needs.get(j) - curr.get(j);
        //         currP = currP +  (left < 0 ? Integer.MAX_VALUE : left * price.get(j));
        //      }
             
        //      ans = Math.min(currP , ans);
        // }
        return solve(price , special , needs);

    }
    private int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
String key = needs.toString();

 if(map.containsKey(key)) return map.get(key);

        int minCost =0;

        for(int i=0;i<needs.size();i++){
            minCost += needs.get(i) * price.get(i);
        }

        for(int i =0;i<special.size();i++){

            List<Integer> remain= new ArrayList<>();
            boolean valid = true;
           for(int j =0;j<needs.size();j++){
                
                int left = needs.get(j) - special.get(i).get(j);
                if(left < 0){
                    valid = false;
                    break;
                }
                remain.add(left);
            }
            if(valid){
                int offerCost = special.get(i).get(needs.size());

                int totalCost = offerCost
                              + solve(price, special, remain);

                minCost = Math.min(minCost, totalCost);
            }
        }

        map.put(key , minCost);

        return minCost;
    }
}
//case 1 take special case 1 + more need 
// case 2 without special