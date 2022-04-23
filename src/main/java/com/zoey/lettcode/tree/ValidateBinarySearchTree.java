package com.zoey.lettcode.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayDeque;
import java.util.Hashtable;

public class ValidateBinarySearchTree {


    // 递归 + 分而治之的想法，其实更是top-down
    // 重要的分析递归函数的参数，Base case, 递归体及返回值
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // return helper(root, Integer.MIN_VALUE-1, Integer.MAX_VALUE+1);
    }

    public boolean helper(TreeNode node, long left, long right) {
        // Base case, 有两个，1.到底部了；2.遇到false node,如果这两个条件都不满足，继续向下
        if (node == null) return true;
        if (node.val <= left || node.val >= right) return false;

        // 重点理解这里的参数，对于left node, 小于parent.val且大于parent的left参数
        // 这里是难点
        boolean leftRes = helper(node.left, left, node.val);
        boolean rightRes = helper(node.right, node.val,right);

        return leftRes&&rightRes;
    }

    // # 使用中序遍历
    ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
    public boolean isValidBST_Ite(TreeNode root) {
        TreeNode current = root;
        TreeNode pre = null;
        while(current!=null || !stack.isEmpty()) {
            while(current!=null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.poll();
            // 下面这种写法没有考虑到peek为null的情况
            // if (node.val > stack.peek().val) return false;

            // 那么我们加上stack.peek()判空呢，[5,1,4,null,null,3,6] case测试不通过
            // if (stack.peek()!=null && node.val > stack.peek().val) return false;
            // 加上pre辅助变量
            if (pre!=null && node.val < pre.val) return false;
            pre = node;
            current = node.right;
        }
        return true;

    }


    public boolean isValidBST_Old(TreeNode root) {
        if(root == null) return true;

        // 刚开始递归想法：要把left node和 right node，以及左右子树是否valid的结果传过来，可以回传这样的也不好整
        // 那么另外一种想法就是把node.val 放到方法的参数中，这是一个重要的思想？好几次都是这样了
        // 另外Search tree好像都涉及到区分左右子树的参数，比如这里就加上了flag以标示左还是右
        boolean leftTree = dp(root.left,root.val,0);
        boolean rightTree = dp(root.right,root.val,1);

        return leftTree&&rightTree;
    }
    /**
     *
     * @param node
     * @param value
     * @param flag flag == 0,left tree; flag == 1, right tree.
     * @return
     */
    public boolean dp(TreeNode node, int value, int flag) {
        if (node == null) return true;

        if (flag == 0 && node.val < value)
            return true;
        else if (flag == 1 && node.val > value)
            return true;
        else
            return false;
    }

    public boolean f(TreeNode node, int val, int flag) {
        if (node == null) return true;

        // 返回left,最大值
        boolean leftTree = f(node.left,node.val,0);

        // 返回right最小值，判断
        boolean rightTree = f(node.right,node.val,1);

        // 左边小于父节点
        if (flag == 0 && node.val < val)
            return true;
        else if (flag == 1 && node.val > val)
            return true;
        else
            return false;
    }





    public static void main(String[] args) {
        // Test cases
        // [5,4,6,null,null,3,7]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
        System.out.println("Is this tree Binary search tree: " + tree.isValidBST(root));
    }
}
