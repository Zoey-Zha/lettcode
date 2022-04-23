package com.zoey.lettcode.tree;

public class CountUnivalueSubtrees {

    int sum = 0;
    public int countUnivalSubtrees(TreeNode root) {


        return 0;
    }

        public int dfs(TreeNode node) {
            if (node == null) return 0;
            if (node.left == null && node.right == null) {
                sum += 1;
                return node.val;
            } else if (node.left == null && node.right != null) {
                int right = dfs(node.right);
                sum += 1;
                return right;
            } else if (node.right == null && node.left != null) {
                sum += 1;
                return dfs(node.left);
            } else {
                int left = dfs(node.left);
                int right = dfs(node.right);

                if (left == node.val && right == node.val) {
                    sum += 1;
                    return node.val;
                } else return 0;
            }
        }
}
