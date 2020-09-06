package com.jun.a_常用算法.二叉树;

/**
 * @author Jun
 * @date 2020/5/5 下午4:17
 */
public class BinNode<T> {
    private T data;
    private BinNode<T> parent;
    private BinNode<T> leftChild;
    private BinNode<T> rightChild;
    private int height;

    public BinNode() {
    }

    public BinNode(T data, BinNode<T> parent, BinNode<T> leftChild, BinNode<T> rightChild, int height) {
        this.data = data;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.height = height;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinNode<T> getParent() {
        return parent;
    }

    public void setParent(BinNode<T> parent) {
        this.parent = parent;
    }

    public BinNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

