package com.alex.nikitin;

public class AvlTree<T extends Comparable<T>> {
    private static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value) {
            this.value = value;
        }


    }

    private Node<T> root;

    public void insert(T value) {
        if (value == null) {
            throw new NullPointerException();
        }

        root = insertUtil(root, value);
    }

    private int getNodeHeight(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getNodeHeight(node.left), getNodeHeight(node.right));
        }
    }

    private Node<T> insertUtil(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        int compare = value.compareTo(node.value);
        if (compare < 0) {
            node.left = insertUtil(node.left, value);
        } else if (compare > 0) {
            node.right = insertUtil(node.right, value);
        } else {
            return node;
        }

        int loadFactor = getNodeHeight(node.left) - getNodeHeight(node.right);

        if (loadFactor > 2 && node.left.value.compareTo(value) > 0) {
            return leftLeftCase(node);
        }

    }

    private Node<T> leftLeftCase(Node<T> z) {
        Node<T> y = z.left;

        z.left = y.right;
        y.right = z;


        return y;
    }
}
