package com.zoey.lettcode.tree;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = bfs(root);
        for(List<Integer> list: res) {
            System.out.println(list);
        }


    }

    public static List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            int sizeOfQ = nodes.size();
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int i =0; i < sizeOfQ; i++) {
               TreeNode node =  nodes.poll();
               list1.add(node.val);
               if (node.left!=null) nodes.add(node.left);
               if (node.right!=null) nodes.add(node.right);
            }
            list.add(list1);
        }

        return list;
    }
}
