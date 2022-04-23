package com.zoey.lettcode.tree;

import java.util.ArrayDeque;

public class BSTIterator {

    ArrayDeque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
    }

    public int next() {
//        try {
//            TreeNode node = stack.poll();
//        } catch (NullPointerException e) {
//            System.out.println(e.getMessage());
//        }
        TreeNode node = stack.poll();
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        stack.push(root);
        traversal(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);

        BSTIterator iterator = new BSTIterator(root);
        // iterator.traversal(root);
        while(iterator.hasNext()) {
            System.out.println("iterator: " + iterator.next());
        }
    }
}
