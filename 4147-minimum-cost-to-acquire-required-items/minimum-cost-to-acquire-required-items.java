class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long common = Math.min(need1 , need2);
        long both = Math.max(need1 , need2);

        long minCommon = common * costBoth + (need1 - common ) * (long) cost1 + ( need2 - common) * (long)cost2;
        long onlyBoth = both * costBoth;
        
        long onlyOneAndTwo = (long)cost1 * need1 + (long)cost2 * need2;
        return Math.min(minCommon , Math.min(onlyBoth,onlyOneAndTwo));

    }
}

// 2 * costboth