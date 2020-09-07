package com.jun.a_常用算法.二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/5/5 下午4:38
 */
public abstract class BinaryTree<T> {
    private int size;
    private BinNode<T> root;

    protected abstract int updateHeight(BinNode<T> x);

    public BinaryTree() {
    }

    public BinaryTree(int size, BinNode<T> root) {
        this.size = size;
        this.root = root;
    }

    int size() {
        return size;
    }



}
