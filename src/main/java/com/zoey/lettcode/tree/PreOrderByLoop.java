package com.zoey.lettcode.tree;

import java.util.ArrayDeque;

public class PreOrderByLoop {
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();

    public void traversalPre(TreeNode root) {
        if (root == null) return;
        // 涉及到linkedlist, 一般都需要一个dummy来辅助
        TreeNode current = new TreeNode(0);
        // 先把root放进去，以保证第一个元素访问
        stack.push(root);
        while (!stack.isEmpty()) {
            // poll()
            TreeNode node = stack.poll();

            if (node.left == null && node.right!=null) {
                stack.push(node.right);
            }
            else if (node.right == null && node.left!=null) {
                stack.push(node.left);
            }
            else if (node.right != null && node.left != null) {
                stack.push(node.right);
                stack.push(node.left);
            }
            current.right = node;
            current = node;
            node.left = null;
        }
    }

    public static void main(String[] args) {
        PreOrderByLoop preOrder = new PreOrderByLoop();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        preOrder.traversalPre(root);
        TreeNode test = root;
        while(test!=null) {
            System.out.println("LinkedList = " + test.val);
            test = test.right;
        }

    }
}
