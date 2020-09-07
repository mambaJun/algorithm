package com.jun.a_常用算法.二叉搜索树;

/**
 * @author Jun
 * @date 2020/5/5 下午10:53
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Value value, Node left, Node right, int n) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            N = n;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return get(node.left, key);
        }
        if (compare > 0) {
            return get(node.right, key);
        }
        return node.value;
    }

}
