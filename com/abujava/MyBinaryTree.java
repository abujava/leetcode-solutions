package com.abujava;

/**
 * This class is not documented :(
 *
 * @author Muhammad Muminov
 * @since 8/13/2023
 */
public class MyBinaryTree {
    private Node root;

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node current = root;
        while (current.value != value) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = new Node(value);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new Node(value);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyBinaryTree{" +
                "root=" + root +
                '}';
    }
}
