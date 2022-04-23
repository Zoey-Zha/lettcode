package com.zoey.lettcode.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayDeque;

public class InOrderIterate {

    public void traversalInOrder(TreeNode root) {
        if (root == null) return;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        // while loop 条件：stack不为空 或者 root不为null,
        // root为null时表示right节点为空，需要从stack中出栈
        // 如果root不为空，则一直找该node的最左的节点（该node也是一个小值），同时要把每个node push into stack
        // 通过入栈和出栈保证了节点的跟踪
        while (!stack.isEmpty() || root!=null) {
            // 这个while循环用户找到最左边的node
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 找到最后一个后，那么其left为null，这个时候需要从stack中出栈
            // 寻找上一层的right节点
            TreeNode node = stack.poll();
            System.out.println(node.val);

            root = node.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);

        root.right.right = new TreeNode(13);

        InOrderIterate iterate = new InOrderIterate();
        iterate.traversalInOrder(root);
    }
}
