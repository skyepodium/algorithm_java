public class TreeNode {
   int val;
    TreeNode left;
   TreeNode right;
  TreeNode() {}
     TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
        this.right = right;
     }
}

class Solution {
    private int res;

    public Solution() {
        this.res = Integer.MIN_VALUE;
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return this.res;
    }

    public int dfs(TreeNode node) {
        if(node == null) return 0;

        int l = Math.max(0, dfs(node.left));
        int r = Math.max(0, dfs(node.right));

        this.res = Math.max(this.res, l + r + node.val);

        return Math.max(l, r) + node.val;
    }
}