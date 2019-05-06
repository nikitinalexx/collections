package com.alex.nikitin;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private static class TrieNode {
        private char c;
        private Map<Character, TrieNode> children = new HashMap<>();
        private boolean isLeaf;

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode() {

        }
    }

    private TrieNode root = new TrieNode();
    private boolean containsNull;

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            containsNull = true;
            return;
        }

        TrieNode tmp = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!tmp.children.containsKey(c)) {
                TrieNode newNode = new TrieNode(c);
                tmp.children.put(c, newNode);
                tmp = newNode;
            } else {
                tmp = tmp.children.get(c);
            }
        }
        tmp.isLeaf = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return containsNull;
        }

        TrieNode result = findNode(word);
        return result != null && result.isLeaf;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return containsNull;
        }

        TrieNode result = findNode(prefix);
        return result != null;
    }

    private TrieNode findNode(String s) {
        TrieNode tmp = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!tmp.children.containsKey(c)) {
                return null;
            } else {
                tmp = tmp.children.get(c);
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("hello");
        trie.insert("helloa");
        trie.insert("heop");

        System.out.println(trie.search("heo"));
        System.out.println(trie.startsWith("hello"));
    }

}
