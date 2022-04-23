package com.zoey.lettcode.tree;

import java.util.ArrayDeque;

public class KthSmallest {

    // 使用递归的方法
    public int kthSmallest1(TreeNode root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (k == 1) {
            System.out.println(root.val);
            return root.val;
        }

        int left = kthSmallest1(root.left, k);
        // k = k - 1;
        System.out.println("node = " + root.val + ", k = " + k);
        int right = kthSmallest1(root.right, k-1);

        return Math.max(left, right);
    }

    public int kthSmallest(TreeNode root, int k) {

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        int count = 0;
        while (current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.poll();
            count ++;
            if (count == k) {
                current = node;
                break;
            }
            current = node.right;
        }
        return current.val;
    }

    public static void main(String[] args) {
        KthSmallest smallest = new KthSmallest();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        int res = smallest.kthSmallest1(root,3);
        System.out.println("The 3 smallest = " + res);
    }
}
