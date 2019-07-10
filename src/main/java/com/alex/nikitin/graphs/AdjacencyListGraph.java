package com.alex.nikitin.graphs;

import com.alex.nikitin.collections.LinkedQueue;

import java.util.*;

public class AdjacencyListGraph<T> {
    private Map<Vertex<T>, Set<Vertex<T>>> adjacencyLists;

    public AdjacencyListGraph() {
        adjacencyLists = new HashMap<>();
    }

    public void addVertex(T value) {
        adjacencyLists.putIfAbsent(new Vertex<>(value), new HashSet<>());
    }

    public void removeVertex(T value) {
        Vertex<T> vertex = new Vertex<>(value);
        adjacencyLists.remove(vertex);
        adjacencyLists.values().forEach(l -> l.remove(vertex));
    }

    public void addEdge(T v1, T v2) {
        Vertex<T> first = new Vertex<>(v1);
        Vertex<T> second = new Vertex<>(v2);

        adjacencyLists.get(first).add(second);
        adjacencyLists.get(second).add(first);
    }

    public void removeEdge(T v1, T v2) {
        Vertex<T> first = new Vertex<>(v1);
        Vertex<T> second = new Vertex<>(v2);

        if (adjacencyLists.containsKey(first)) {
            adjacencyLists.get(first).remove(second);
        }
        if (adjacencyLists.containsKey(second)) {
            adjacencyLists.get(second).remove(first);
        }
    }

    public Set<T> depthFirstTraversal(T root) {
        Set<T> visited = new LinkedHashSet<>();
        Stack<T> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex<T> v : adjacencyLists.get(new Vertex<>(vertex))) {
                    stack.push(v.value);
                }
            }
        }
        return visited;
    }

    public Set<T> breadthFirstTraversal(T root) {
        Set<T> visited = new LinkedHashSet<>();
        com.alex.nikitin.collections.Queue<T> queue = new LinkedQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            T vertex = queue.dequeue();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex<T> v : adjacencyLists.get(new Vertex<>(vertex))) {
                    queue.enqueue(v.value);
                }
            }
        }
        return visited;
    }


}
