package com.alex.nikitin.collections;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class SinglyLinkedList<T> implements List<T> {
    private static class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private int size = 0;

    @Override
    public void insertAtEnd(T value) {
        if (isEmpty()) {
            head = new Node<>(value);
        } else {
            Node<T> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<>(value);
        }
        size++;
    }

    @Override
    public void insertAtHead(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            head = new Node<>(value, head);
        }
        size++;
    }

    @Override
    public boolean delete(T element) {
        if (isEmpty()) {
            return false;
        }
        if (Objects.equals(head.value, element)) {
            head = head.next;
            size--;
            return true;
        } else {
            Node<T> tmp = head;
            while (tmp.next != null) {
                if (Objects.equals(tmp.next.value, element)) {
                    tmp.next = tmp.next.next;
                    size--;
                    return true;
                } else {
                    tmp = tmp.next;
                }
            }
        }
        return false;
    }

    @Override
    public T deleteAtHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> tmp = head;
        while (tmp != null) {
            sb.append(tmp.value);
            sb.append(", ");
            tmp = tmp.next;
        }
        return sb.toString();
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next;

        while (current != null) {
            next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public T getNthFromEnd(int n) {
        int numberOfNodes = 0;
        Node<T> tmp = head;
        while (tmp != null) {
            numberOfNodes++;
            tmp = tmp.next;
        }
        if (n < 0 || n >= numberOfNodes) {
            throw new IndexOutOfBoundsException();
        }//toGo = = 5 - 3
        int toGo = numberOfNodes - n - 1;
        tmp = head;
        while (toGo > 0) {
            tmp = tmp.next;
            toGo--;
        }
        return tmp.value;
    }

    public void removeDuplicates() {
        if (size < 2) {
            return;
        }

        Set<T> values = new HashSet<>();
        values.add(head.value);
        Node<T> prev = head;
        Node<T> current = head.next;

        while (current != null) {
            if (values.contains(current.value)) {
                prev.next = current.next;
            } else {
                values.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        System.out.println(list);

        list.insertAtHead(0);

        list.insertAtEnd(1);
        list.insertAtEnd(2);

        list.insertAtHead(-1);

        list.insertAtEnd(3);
        System.out.println(list);

        list.deleteAtHead();
        list.deleteAtHead();
        System.out.println("After deleting at head 2 times " + list);

        list.insertAtEnd(4);
        list.insertAtHead(0);
        System.out.println("Should be 0,1,2,3,4 - " + list);

        list.delete(0);
        list.delete(2);
        list.delete(3);
        System.out.println("After deleting 2 and 3 and 0:   " + list);

        System.out.println("Searching at index 0 and 1: " + list.search(0) + " " + list.search(1));

        list.insertAtHead(5);
        list.insertAtHead(6);

        System.out.println(list);
        System.out.println("Reversing");
        list.reverse();
        System.out.println(list);

        list.deleteAtHead();
        list.deleteAtHead();
        list.deleteAtHead();
        list.reverse();
        System.out.println(list);

        for(int i = 0; i < 5; i++) {
            list.insertAtEnd(i);
        }
        System.out.println(list);
        System.out.println(list.getNthFromEnd(0));

        for (int i = 0; i < 10; i++) {
            list.insertAtEnd(i);
        }
        System.out.println(list);
        list.removeDuplicates();
        System.out.println(list);

    }
}
