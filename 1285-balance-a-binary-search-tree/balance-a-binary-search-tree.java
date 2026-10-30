class Solution {

    public TreeNode balanceBST(TreeNode root) {

        List<TreeNode> nodes = new ArrayList<>();

        inorder(root, nodes);

        return build(nodes, 0, nodes.size() - 1);
    }

    private void inorder(TreeNode root, List<TreeNode> nodes) {

        if (root == null) {
            return;
        }

        inorder(root.left, nodes);

        nodes.add(root);

        inorder(root.right, nodes);
    }

    private TreeNode build(List<TreeNode> nodes, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = nodes.get(mid);

        root.left = build(nodes, left, mid - 1);
        root.right = build(nodes, mid + 1, right);

        return root;
    }
}