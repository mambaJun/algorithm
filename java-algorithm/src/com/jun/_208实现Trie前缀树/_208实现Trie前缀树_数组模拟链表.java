package com.jun._208实现Trie前缀树;

/**
 * @author Jun
 * @date 2020/9/14 下午8:25
 */
public class _208实现Trie前缀树_数组模拟链表 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}

/*
["Trie","insert","search","search","startsWith","insert","search"]
[    [],["apple"],["apple"],["app"],["app"],["app"],["app"]]
result:
    [null,null,true,false,true,null,true]
*/
class Trie {

    static int N = 26;
    int[][] son = new int[N]['z' - 'a' + 1];
    int[] current = new int[N];
    // 下标是0的点，既是根节点 又是空节点
    int idx = 0;


    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 根节点、
        int p = 0;
        // 遍历 字符串
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            // 为0表示不存在，创建
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }

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
            if (son[p][u] == 0) {
                return false;
            }
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
