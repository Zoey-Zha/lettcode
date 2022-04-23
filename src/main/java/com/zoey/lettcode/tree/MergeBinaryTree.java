package com.zoey.lettcode.tree;

public class MergeBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;
        dfs(root1.left,root2.left,root1,root2,0);
        dfs(root1.right,root2.right,root1,root2,1);
        return root1;

    }

    /**
     *
     * @param node1
     * @param node2
     * @param root1  parent of node1
     * @param root2  parent of node2
     * @param flag flag == 0, left ; flag == 1, right
     */
    public void dfs(TreeNode node1, TreeNode node2, TreeNode root1, TreeNode root2, int flag) {

        if (node2 == null) return;

        else if (node1 == null) {
            if (flag == 0)
               root1.left = node2;
            else root1.right = node2;
            return;
        }
        else {
            node1.val += node2.val;
            dfs(node1.left,node2.left,node1,node2,0);
            dfs(node1.right,node2.right,node1,node2,1);
        }

    }
}
