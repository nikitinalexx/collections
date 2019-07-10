package com.alex.nikitin.collections;

import java.util.ArrayList;
import java.util.List;

public class Narry<T> {
    private static class TreeNode<T> {
        private T value;
        private List<TreeNode<T>> children = new ArrayList<>();
        private int maxChildrenNumber;

        public TreeNode(T value, int maxChildrenNumber) {
            this.value = value;
            this.maxChildrenNumber = maxChildrenNumber;
        }

        public boolean addChild(TreeNode<T> child) {
            if (children.size() < maxChildrenNumber) {
                return children.add(child);
            }
            return false;
        }

        public boolean addChild(T value) {
            return addChild(new TreeNode<>(value, maxChildrenNumber));
        }

        public List<TreeNode<T>> getChildren() {
            return new ArrayList<>(children);
        }

        public TreeNode<T> getChild(int index) {
            if (index < 0 || index >= children.size()) {
                throw new IndexOutOfBoundsException();
            }
            return children.get(index);
        }

    }

    public static <T> void print(TreeNode<T> node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode<T>> stack = new ArrayStack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode<T> n = stack.pop();
            System.out.println(n.value);
            for (TreeNode<T> child : n.children) {
                stack.push(child);
            }
        }
    }
}
