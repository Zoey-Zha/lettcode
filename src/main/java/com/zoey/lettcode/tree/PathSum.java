package com.zoey.lettcode.tree;

public class PathSum {
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root,0,targetSum);
        return res;

    }

    public void dfs(TreeNode node,int accu, int targetSum) {
        if (node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            if(accu + node.val == targetSum) {
                res = true;
                return;
            }
        }
        dfs(node.left,accu + node.val,targetSum);
        dfs(node.right,accu + node.val,targetSum);
        // if（accu + node.val == targetSum) res = true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.left.left.right.right = new TreeNode(10);

        PathSum sum = new PathSum();
        System.out.println("The result is : " + sum.hasPathSum(root,22));

    }
}
