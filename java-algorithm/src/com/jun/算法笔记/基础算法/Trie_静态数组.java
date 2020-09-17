package com.jun.算法笔记.基础算法;

/**
 * @author Jun
 * @date 2020/9/17 上午8:29
 */
public class Trie_静态数组 {

    static int N = 100010;
    int[][] son = new int[N]['z' - 'a' + 1];
    int[] current = new int[N];
    // 下标是0的点，既是根节点 又是空节点
    int idx = 0;


    /**
     * Initialize your data structure here.
     */
    public Trie_静态数组() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 根节点
        int p = 0;
        // 遍历 字符串
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            // 为0表示不存在，创建
            if (son[p][u] == 0) son[p][u] = ++idx;

            p = son[p][u];
        }
        current[p]++;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (son[p][u] == 0) return false;
        }
        return current[p] != 0;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (son[p][u] == 0) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
