package com.zoey.lettcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class InOrder {
    // Recursion
    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left,list);
        // process 在left和right中间
        list.add(node.val);
        inOrder(node.right,list);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Integer> list = new ArrayList<>();
        InOrder inO = new InOrder();
        inO.inOrder(root,list);

        System.out.println("list = " + list);
    }

    // 使用iterate方法 实现前序遍历，主要是利用stack,及让node.right先入栈
    public List<Integer> preOrderIte(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        // stack 栈结构
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        // treeNodes.push(root);
        TreeNode current = root;

        while(current!=null || !treeNodes.isEmpty()){
            // 通过while循环，找到所有left leaves,
            // 判断条件是直到current == null, 也就是最后一个左left tree node
            while(current!=null){
                treeNodes.add(current);
                current = current.left;
            }
            // 然后从栈中去top元算，相当于left, root都处理过了，接下来处理right
            // current 指向current.right,也就可以想象为root,下一次循环再次查找所有lefts
            //current = treeNodes.pop();
            current = treeNodes.poll();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }
}
