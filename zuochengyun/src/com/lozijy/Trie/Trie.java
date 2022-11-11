package com.lozijy.Trie;

public class Trie {
    public TrieNode root;

    public Trie() {
        this.root=new TrieNode();
    }
    public void insert(String str){
        if(str==null){
            return ;
        }
        TrieNode node =this.root;
        for (int i = 0; i < str.length(); i++) {
            char chr=str.charAt(i);
            int index = chr - 'a';
            if(node.nexts[index]==null){
                node.nexts[index]=new TrieNode();
            }
            node=node.nexts[index];
            node.pass++;
            if(i==str.length()-1){
                node.end++;
            }
        }
    }

    public void delete(String str){
        if(str==null||str==""||search(str)==0){
            return;
        }
        TrieNode node=this.root;
        char[] charArray = str.toCharArray();
        for(char chr:charArray){
            int index=chr-'a';
            node.pass--;
            node=node.nexts[index];
        }
        node.end--;
        if(node.pass==0){
            node.nexts=null;
        }
    }
    //查看字符串个数
    public int search(String str){
        if(str==null){
            return 0;
        }
        TrieNode node=this.root;
        char[] charArray = str.toCharArray();
        for(char chr:charArray){
            int index=chr-'a';
            if(node.nexts[index]==null){
                return 0;
            }else {
                node = node.nexts[index];
            }
        }
        return node.end;
    }
    //查看以一个字符串为前缀的单词个数
    public int prefixNumber(String pre){
        if(pre==null){
            return 0;
        }
        TrieNode node=this.root;
        char[] charArray = pre.toCharArray();
        for(char chr:charArray){
            int index=chr-'a';
            if(node.nexts[index]==null){
                return 0;
            }else {
                node = node.nexts[index];
            }
        }
        return node.pass;
    }


}
