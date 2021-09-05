import java.util.ArrayList;

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // 1. exception
        if(root == null) return res;

        // 2. preOrder
        preOrder(root);

        return res;
    }

    public void preOrder(TreeNode node) {
        if(node == null) return;

        res.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}