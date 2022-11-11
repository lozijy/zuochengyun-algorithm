package com.lozijy.Trie;

public class TrieNode {
    public int pass;//以这几个字符为前缀的字符串
    public int end;//共有多少个这样的字符串
    public TrieNode[] nexts;

    public TrieNode() {
        this.pass=0;
        this.end=0;
        this.nexts=new TrieNode[26];
    }
}
