package com.alex.nikitin;

public class MyHashMap<K, V> {
    public static final double LOAD_FACTOR = 20;

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private V nullValue;
    private int size;

    private Node<K, V>[] buckets = (Node<K, V>[]) new Node[4];

    public void put(K key, V value) {
        if (key == null) {
            if (nullValue == null) {
                size++;
            }
            nullValue = value;
        } else {
            ensureCapacity();
            if (putUtil(key, value, buckets)) {
                size++;
            }
        }
    }

    private boolean putUtil(K key, V value, Node<K, V>[] buckets) {
        int hashCode = key.hashCode();
        int bucketIndex = hashCode % buckets.length;
        Node<K, V> bucket = buckets[bucketIndex];
        if (bucket == null) {
            buckets[bucketIndex] = new Node<>(key, value);
            return true;
        } else if (bucket.key.equals(key)) {
            bucket.value = value;
            return false;
        } else {
            while (bucket.next != null) {
                bucket = bucket.next;
                if (bucket.key.equals(key)) {
                    bucket.value = value;
                    return false;
                }
            }
            bucket.next = new Node<>(key, value);
            return true;
        }
    }

    public V get(K key) {
        if (key == null) {
            return nullValue;
        } else {
            int hashCode = key.hashCode();
            int bucketIndex = hashCode % buckets.length;
            Node<K, V> bucket = buckets[bucketIndex];
            while (bucket != null && !bucket.key.equals(key)) {
                bucket = bucket.next;
            }
            if (bucket != null) {
                return bucket.value;
            }
            return null;
        }
    }

    public V delete(K key) {
        if (key == null) {
            V value = nullValue;
            nullValue = null;
            size--;
            return value;
        } else {
            int hashCode = key.hashCode();
            int bucketIndex = hashCode % buckets.length;
            Node<K, V> node = buckets[bucketIndex];
            if (node == null) {
                return null;
            } else if (node.key.equals(key)) {
                V value = node.value;
                buckets[bucketIndex] = node.next;
                size--;
                return value;
            } else {
                while (node.next != null) {
                    if (node.next.key.equals(key)) {
                        V value = node.next.value;
                        node.next = node.next.next;
                        size--;
                        return value;
                    }
                    node = node.next;
                }
                return null;
            }
        }
    }

    private void ensureCapacity() {
        if ((double) size / buckets.length >= LOAD_FACTOR) {
            Node<K, V>[] tmp = buckets;
            buckets = (Node<K, V>[]) new Object[buckets.length * 2];
            for (Node<K, V> bucket : tmp) {
                while (bucket != null) {
                    putUtil(bucket.key, bucket.value, buckets);
                    bucket = bucket.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);
        map.put("K", 9);
        map.put("L", 10);

        System.out.println(map.delete("E"));;
        System.out.println(map.delete("A"));;
        System.out.println(map.delete("K"));
        System.out.println();
    }
}
