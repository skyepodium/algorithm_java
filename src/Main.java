class Solution {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        go(root, false);

        return res;
    }

    public void go(TreeNode node, Boolean isLeft) {
        if(node == null) return;

        if(node.left == null && node.right == null && isLeft) {
            res += node.val;
        }

        go(node.left, true);
        go(node.right, false);
    }
}