package com.alex.nikitin;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private static class Node {
        private int value;

        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }

    }

    private Node root;

    public void add(int v) {
        root = addUtil(root, v);
    }

    private Node addUtil(Node node, int v) {
        if (node == null) {
            return new Node(v);
        }
        if (v < node.value) {
            node.left = addUtil(node.left, v);
        } else {
            node.right = addUtil(node.right, v);
        }

        return node;
    }

    public boolean containsValue(int v) {
        return containsUtil(root, v);
    }

    private boolean containsUtil(Node node, int v) {
        if (node == null) {
            return false;
        }

        if (node.value == v) {
            return true;
        }

        if (v < node.value) {
            return containsUtil(node.left, v);
        } else {
            return containsUtil(node.right, v);
        }
    }

    public void delete(int value) {
        root = deleteUtil(root, value);
    }

    private Node deleteUtil(Node node, int v) {
        if (node == null) {
            return null;
        }

        if (node.value == v) {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            int smallestValue = findSmallest(node.right);
            node.value = smallestValue;
            node.right = deleteUtil(node.right, smallestValue);
        } else if (v < node.value) {
            node.left = deleteUtil(node.left, v);
        } else {
            node.right = deleteUtil(node.right, v);
        }
        return node;
    }

    private int findSmallest(Node node) {
        if (node.left == null) {
            return node.value;
        } else {
            return findSmallest(node.left);
        }
    }

    public void traverseInOrder() {
        traverseInOrderUtil(root);
    }

    private void traverseInOrderUtil(Node node) {
        if (node != null) {
            traverseInOrderUtil(node.left);
            System.out.println(node.value);
            traverseInOrderUtil(node.right);
        }
    }

    public void traversePreOrder() {
        traversePreOrderUtil(root);
    }

    private void traversePreOrderUtil(Node node) {
        if (node != null) {
            System.out.println(node.value);
            traversePreOrderUtil(node.left);
            traversePreOrderUtil(node.right);
        }
    }

    public void traversePostOrder() {
        traversePostOrderUtil(root);
    }

    private void traversePostOrderUtil(Node node) {
        if (node != null) {
            traversePreOrderUtil(node.left);
            traversePreOrderUtil(node.right);
            System.out.println(node.value);
        }
    }

    public void traverseLevelOrder() {
        Queue<Node> nodes = new LinkedList<>();

        if (root != null) {
            nodes.add(root);
        }

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();

            System.out.println(node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.add(10);
        binarySearchTree.add(5);
        binarySearchTree.add(15);
        binarySearchTree.add(7);
        binarySearchTree.add(1);
        binarySearchTree.add(6);
        binarySearchTree.add(10);
        binarySearchTree.add(15);
        binarySearchTree.delete(15);
        binarySearchTree.delete(7);

        binarySearchTree.traverseInOrder();
    }

}
