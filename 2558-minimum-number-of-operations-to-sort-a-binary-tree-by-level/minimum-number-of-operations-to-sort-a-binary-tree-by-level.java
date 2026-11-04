
class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            int[] arr = new int[size];
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                arr[i] = curr.val;
                map.put(curr.val, i);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            for (int i = 0; i < size; i++) {
                if (arr[i] != sorted[i]) {
                    int ind = map.get(sorted[i]);

                    int temp = arr[i];
                    arr[i] = arr[ind];
                    arr[ind] = temp;

                    map.put(arr[i], i);
                    map.put(arr[ind], ind);

                    count++;
                }
            }
        }

        return count;
    }
}
