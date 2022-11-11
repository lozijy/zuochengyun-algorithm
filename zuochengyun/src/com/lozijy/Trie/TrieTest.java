package com.lozijy.Trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("bc");
        System.out.println(trie.prefixNumber("a"));
    }
}
