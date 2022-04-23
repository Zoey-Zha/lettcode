package com.zoey.lettcode.tree;

import java.util.ArrayDeque;

public class BSTIteratorByLoop {
    ArrayDeque<TreeNode> stack;
    TreeNode current;

    public BSTIteratorByLoop(TreeNode root) {
        current = root;
        stack = new ArrayDeque<>();
    }

    public int next() {
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
        TreeNode node = stack.poll();
        current = node.right;

        return node.val;
    }

    public boolean hasNext(){
        return !(current == null) || !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);

        BSTIteratorByLoop loop = new BSTIteratorByLoop(root);

        while (loop.hasNext()) {
            System.out.println("loop = " + loop.next());
        }

    }
}
