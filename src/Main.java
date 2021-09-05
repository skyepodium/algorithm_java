class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        // 1. exception
        if(root == null) return res;

        // 2. postOrder
        postOrder(root);

        return res;
    }

    public void postOrder(TreeNode node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        res.add(node.val);

    }
}