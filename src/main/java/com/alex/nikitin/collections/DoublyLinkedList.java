package com.alex.nikitin.collections;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<T> implements List<T> {
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public void insertAtEnd(T value) {
        if (isEmpty()) {
            head = tail = new Node<>(value);
        } else {
            Node<T> oldTail = tail;
            Node<T> newTail = new Node<>(value);
            oldTail.next = newTail;
            newTail.previous = oldTail;
            tail = newTail;
        }
        size++;
    }

    @Override
    public void insertAtHead(T value) {
        if (isEmpty()) {
            head = tail = new Node<>(value);
        } else {
            Node<T> oldHead = head;
            Node<T> newHead = new Node<>(value);
            oldHead.previous = newHead;
            newHead.next = oldHead;
            head = newHead;
        }
        size++;
    }

    @Override
    public boolean delete(T element) {
        if (isEmpty()) {
            return false;
        }
        if (head == tail && Objects.equals(head.value, element)) {
            head = tail = null;
            size--;
            return true;
        } else if (head != tail) {
            if (Objects.equals(head.value, element)) {
                head.next.previous = null;
                head = head.next;
                size--;
                return true;
            } else if (Objects.equals(tail.value, element)) {
                tail.previous.next = null;
                tail = tail.previous;
                size--;
                return true;
            } else {
                Node<T> tmp = head.next;
                while (tmp != null && tmp != tail) {
                    if (Objects.equals(tmp.value, element)) {
                        tmp.previous.next = tmp.next;
                        tmp.next.previous = tmp.previous;
                        size--;
                        return true;
                    } else {
                        tmp = tmp.next;
                    }
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
        size--;
        if (head == tail) {
            T value = head.value;
            head = tail = null;
            return value;
        } else {
            T value = head.value;
            head.next.previous = null;
            head = head.next;
            return value;
        }
    }

    @Override
    public T search(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
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

    public static void main(String[] args) {
        List<Integer> list = new DoublyLinkedList<>();
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtHead(4);
        list.insertAtHead(3);

        list.delete(3);
        list.delete(6);
        list.insertAtEnd(6);
        list.insertAtHead(3);
        list.delete(4);
        list.insertAtEnd(7);
        list.delete(6);
        System.out.println("Head delete: " + list.deleteAtHead());
        System.out.println("Head delete: " + list.deleteAtHead());
        System.out.println("Head delete: " + list.deleteAtHead());
        list.insertAtHead(5);
        list.insertAtHead(4);
        list.insertAtHead(3);
        list.insertAtHead(2);
        System.out.println("Search 0 " + list.search(0));
        System.out.println("Search 1 " + list.search(1));
        System.out.println("Search 2 " + list.search(2));
        System.out.println("Search 3 " + list.search(3));
        System.out.println(list);
    }
}
