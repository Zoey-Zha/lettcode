package com.zoey.lettcode.tree;

import java.util.ArrayDeque;

public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        ArrayDeque<Node> nodes = new ArrayDeque<Node>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            Node tmp = null;
            for (int i = 0; i < size; i ++) {
                Node node = nodes.poll();
                node.next = tmp;
                tmp = node;

            }
        }
       return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        PopulatingNextRightPointers pointers = new PopulatingNextRightPointers();
        pointers.connect(root);
        Node node = root.left.left;
        while (node != null) {
            System.out.println("node next = " + node.val);
            node =node.next;
        }


    }
}
