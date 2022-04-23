package com.zoey.lettcode.tree;

import java.util.LinkedList;

public class BinaryTreetoLinkedList {
    LinkedList<TreeNode> list =  new LinkedList<>();


    public void flatten(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);

        flatten(root.left);
        flatten(root.right);




    }

    public void traversalPreOder(TreeNode root) {

    }
}
