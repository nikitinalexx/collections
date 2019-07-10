package com.alex.nikitin.collections;

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

        if (loadFactor > 1) {
            int result = node.left.value.compareTo(value);
            if (result > 0) {
                return rightRotate(node);
            } else if (result < 0) {
                node = leftRotate(node);
                return rightRotate(node);
            }
        } else if (loadFactor < -1) {
            int result = node.right.value.compareTo(value);
            if (result > 0) {
                node = rightRotate(node);
                return leftRotate(node);
            } else if (result < 0) {
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node<T> rightRotate(Node<T> z) {
        Node<T> y = z.left;

        z.left = y.right;
        y.right = z;

        return y;
    }

    private Node<T> leftRotate(Node<T> z) {
        Node<T> y = z.right;

        z.right = y.left;
        y.left = z;

        return y;
    }

    public void traverse() {
        traverseUtil(root);
    }

    private void traverseUtil(Node<T> node) {
        if (node != null) {
            if (node.left != null) {
                System.out.println("Left (");
            }
            traverseUtil(node.left);
            if (node.left != null) {
                System.out.println(")");
            }
            System.out.println(node.value);
            if (node.right != null) {
                System.out.println("Right (");
            }
            traverseUtil(node.right);
            if (node.right != null) {
                System.out.println(")");
            }
        }
    }

    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        for (int i = 1; i <= 11; i++) {
            avlTree.insert(i);
        }
        avlTree.traverse();
    }
}
