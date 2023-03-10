package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
                continue;
            }
            return false;
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        System.out.println(trie.startsWith("ab")); // return False
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
        System.out.println(trie.search("apple"));
    }
}
