package com.alex.nikitin.graphs;

import com.alex.nikitin.collections.ArrayStack;
import com.alex.nikitin.collections.LinkedQueue;
import com.alex.nikitin.collections.Queue;
import com.alex.nikitin.collections.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode<T> {
    private T value;
    private List<GraphNode<T>> adjacent = new ArrayList<>();
    private boolean visited = false;

    public GraphNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void connect(GraphNode<T> node) {
        adjacent.add(node);
    }

    public static <T> void depthSearch(GraphNode<T> root, T value) {
        Stack<GraphNode<T>> stack = new ArrayStack<>();
        stack.push(root);

        int iterCounter = 0;

        while (!stack.isEmpty()) {
            iterCounter++;
            GraphNode<T> node = stack.pop();
            node.visited = true;
            if (Objects.equals(node.value, value)) {
                System.out.println("Found a value " + node.value + ", in " + iterCounter + " iterations");
                return;
            } else {
                List<GraphNode<T>> adjacent = node.adjacent;
                for (GraphNode<T> graphNode : adjacent) {
                    if (!graphNode.visited) {
                        stack.push(graphNode);
                    }
                }
            }
        }
    }

    public static <T> void breadthSearch(GraphNode<T> root, T value) {
        Queue<GraphNode<T>> queue = new LinkedQueue<>();
        queue.enqueue(root);

        int iterCounter = 0;

        while (!queue.isEmpty()) {
            GraphNode<T> node = queue.dequeue();
            if (node.visited) {
                continue;
            }
            node.visited = true;
            iterCounter++;

            if (Objects.equals(node.value, value)) {
                System.out.println("Found a value " + node.value + ", in " + iterCounter + " iterations");
                return;
            } else {
                node.adjacent.forEach(queue::enqueue);
            }
        }
    }

    public static void main(String[] args) {
        List<GraphNode<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nodes.add(new GraphNode<>(i + 1));
        }
        nodes.get(4).connect(nodes.get(2));
        nodes.get(4).connect(nodes.get(3));


        nodes.get(2).connect(nodes.get(1));

        nodes.get(3).connect(nodes.get(1));
        nodes.get(3).connect(nodes.get(8));
        nodes.get(3).connect(nodes.get(5));
        nodes.get(3).connect(nodes.get(6));




        nodes.get(1).connect(nodes.get(0));

        nodes.get(8).connect(nodes.get(9));

        nodes.get(5).connect(nodes.get(8));
        nodes.get(5).connect(nodes.get(7));


        nodes.get(9).connect(nodes.get(0));

        breadthSearch(nodes.get(4), 6);
    }

}
