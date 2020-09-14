package com.jun._208实现Trie前缀树;

/**
 * @author Jun
 * @date 2020/9/14 下午8:01
 */
public class _208实现Trie前缀树 {

}

class Trie {
    static int N = 10010;
    //
    int[][] son = new int[N][26];
    //  当前这个点结尾 的个数
    int[] current = new int[N];
    // 下标是 0的点，既是根节点又是 空节点
    int idx;

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            // 如 p 不存在，创建 出来
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
            p = son[p][u];
        }
        return current[p] == 0;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (son[p][u] == 0) return false;
            p = son[p][u];
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