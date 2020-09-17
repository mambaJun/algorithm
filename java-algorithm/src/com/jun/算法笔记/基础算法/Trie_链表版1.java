package com.jun.算法笔记.基础算法;

/**
 * @author Jun
 * @date 2020/9/17 上午8:32
 */
public class Trie_链表版1 {
    private class TrieNode {
        TrieNode[] next = new TrieNode['z' - 'a' + 1];
        boolean isEnd = false;
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie_链表版1() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 从 根节点 开始， 类似表头
        TrieNode node = root;
        // i 代表 字符串的第几个字母 ， 同时代表第几层
        for (int i = 0; i < word.length(); i++) {
            // 取出 当前层的字符
            char ch = word.charAt(i);
            // 如果当前层 没有对应的 子节点，新生成一个
            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new TrieNode();
            }
            // 节点 指针 移向 下一层
            node = node.next[ch - 'a'];
        }
        // 字符 插入完毕， 将当前的节点 标记为 单词结尾
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.next[ch - 'a'] == null) return false;
            node = node.next[ch - 'a'];
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.next[ch - 'a'] == null) return false;
            node = node.next[ch - 'a'];
        }
        return false;
    }
}
