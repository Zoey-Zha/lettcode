package com.zoey.lettcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PostOrder {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        TreeNode curr = root;

        while(curr != null || !nodes.isEmpty()){
            while(curr != null) {
                nodes.push(curr);
                curr = curr.left;
            }
            // 最后一个左叶子，然后要看右叶子
            curr = nodes.peek();
            if (curr == null) {
                curr = nodes.poll();
                list.add(curr.val);
                curr = null;
            }
        }

        return list;
    }
}
