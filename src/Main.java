import java.util.ArrayList;

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // 1. exception
        if(root == null) return res;

        // 2. inorder
        inOrder(root);

        return res;
    }

    public void inOrder(TreeNode node) {
        if(node == null) return;

        inOrder(node.left);
        res.add(node.val);
        inOrder(node.right);
    }
}