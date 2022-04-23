package com.zoey.lettcode.tree;

//class Node {
//    int key;
//    Node left, right;
//
//    public Node(int item) {
//        key = item;
//        left = right = null;
//    }
//}
public class BinaryTree {
    Node root;

    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    // Traverse Inorder
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.val);
            traverseInOrder(node.right);
        }
    }

    // Traverse Postorder
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.val);
        }
    }

    // Traverse Preorder
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.val);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // Traverse Preorder
    public int getMax(Node node) {
        int max =0;
        if (node != null) {
            getMax(node.left);
            max ++;
            getMax(node.right);
        }
        return max;
    }

    public int leftDepth (Node node) {
        if(node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        int n = 0;
        // int m = 0;
        if (node != null) {
            n = leftDepth(node.left) + leftDepth(node.right);
            n ++;
        }
        return n;
    }
    public int rightDepth (Node node) {
        if (node == null) return -1;
        int n = 0;
        // int m = 0;
        if (node != null) {
            n = rightDepth(node.right) + 1;
        }
        return n;
    }
    public int depthOfBinaryTree(Node node) {
        return leftDepth(node) + rightDepth(node);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
//        tree.root.left.right.left = new Node(6);
//        tree.root.left.right.left.left = new Node(9);
//        tree.root.left.left.left = new Node(8);
//        tree.root.left.left.right = new Node(10);
//        tree.root.left.left.right.left = new Node(11);



//        System.out.print("Pre order Traversal: ");
//        tree.traversePreOrder(tree.root);
//        System.out.print("\nIn order Traversal: ");
//        tree.traverseInOrder(tree.root);
//        System.out.print("\nPost order Traversal: ");
//        tree.traversePostOrder(tree.root);
        System.out.println("the left depth of a binary tree: " + tree.leftDepth(tree.root.left));
        //System.out.println("the right depth of a binary tree: " + tree.rightDepth(tree.root.left));
        //System.out.println("\nthe depth of a binary tree: " + tree.depthOfBinaryTree(tree.root.left));
    }
}

