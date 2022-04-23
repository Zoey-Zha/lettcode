package com.zoey.lettcode.tree;

import java.util.ArrayDeque;

public class SymmetricTree {
    boolean res = true;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        //root.right.left = new TreeNode(4);
        root.right.left = new TreeNode(3);
        // System.out.println("the result is: " + isSymmetric(root));
        SymmetricTree tree = new SymmetricTree();
        tree.dfs(root.left,root.right);
        System.out.println("the result is: " + tree.res);

    }

    public  boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        dfs(root.left,root.right);
        return res;
    }

    // 只对当前node的当前val做判断，不对下层做判断
    // 刚开始对下层也做了判断，导致问题复杂度大幅提升
    public void dfs(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return;
        if ((node1 == null && node2 !=null) || (node1 != null && node2 == null)) {
            res = false;
            return;
        }
        else if (node1.val == node2.val) {
            dfs(node1.left, node2.right);
            dfs(node1.right,node2.left);
        }
        else {
            res = false;
            return;
        }
    }
}
