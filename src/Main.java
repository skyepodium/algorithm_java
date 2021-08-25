class Solution {
    int res = 0;
    public int maxDepth(TreeNode root) {
        // 1. exception
        if(root == null) return 0;

        // 2. dfs
        dfs(root, 1);

        return res;
    }

    public void dfs(TreeNode root, int cnt) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            res = Math.max(res, cnt);
        }

        dfs(root.left, cnt + 1);
        dfs(root.right, cnt + 1);

    }
}