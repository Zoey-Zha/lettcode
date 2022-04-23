package com.zoey.lettcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    public void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Integer> list = new ArrayList<>();
        PreOrder preOrder = new PreOrder();
        preOrder.preOrder(root,list);

        System.out.println("list = " + list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        // List<Integer> list1 = new ArrayList<>();

        if (root == null) return list;

        // 测试list.addAll(), 这里可以把另外一个list完整的加进去。
        // list.addAll(list1);
        preOrder(root,list);
        return list;
    }

    // 使用iterate方法 实现前序遍历，主要是利用stack,及让node.right先入栈
    public List<Integer> preOrderIte(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        // stack 栈结构
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.push(root);

        // 开始遍历，遍历条件：栈不为空
        while(!treeNodes.isEmpty()) {
           TreeNode node =  treeNodes.poll();
           list.add(node.val);
           // 先从右边开始入栈，那么right nodes 则会最后出来
           if (node.right != null) {
               treeNodes.push(node.right);
           }
           if (node.left != null) {
               treeNodes.push(node.left);
           }
        }
        return list;
    }
}
