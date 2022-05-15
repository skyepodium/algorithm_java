class Solution {
    int d = 0;
    int res = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);

        return res;
    }

    public void dfs(TreeNode node, int depth) {
        if(node == null) return;

        if(depth == this.d) this.res += node.val;

        if(depth > this.d) {
            this.res = 0;
            this.d = depth;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}


