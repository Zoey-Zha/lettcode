package com.zoey.lettcode.tree;

public class InvertBinaryTree {
    public void dfs(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return;


        dfs(node1.left, node2.right);
        dfs(node1.right,node2.left);
    }
}
