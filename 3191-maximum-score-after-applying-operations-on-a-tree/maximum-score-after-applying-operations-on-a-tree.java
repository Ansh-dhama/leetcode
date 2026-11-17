class Solution {

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {

        int n = values.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        long totalSum = 0;

        for (int val : values) {
            totalSum += val;
        }

        long minKeep = dfs(0, -1, adj, values);

        return totalSum - minKeep;
    }

    private long dfs(int node, int parent,
                     List<List<Integer>> adj, int[] values) {

        long childrenCost = 0;
        boolean isLeaf = true;

        for (int child : adj.get(node)) {

            if (child == parent) continue;

            isLeaf = false;

            childrenCost += dfs(child, node, adj, values);
        }

        if (isLeaf) {
            return values[node];
        }

        return Math.min(values[node], childrenCost);
    }
}