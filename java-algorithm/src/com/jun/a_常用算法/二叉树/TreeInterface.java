package com.jun.a_常用算法.二叉树;

/**
 * @author Jun
 * @date 2020/5/5 下午4:21
 */
public interface TreeInterface<T> {
    int size();

    BinNode<T> insertAsLeftChild();

    BinNode<T> insertAsRightChild();

    BinNode<T> succ();

    void travlevel();

    void travPre();

    void travIn();

    void travPost();

    boolean isRoot(BinNode<T> x);

    boolean isLeftChild(BinNode x);

    boolean isRightChild(BinNode x);

    boolean hasParent(BinNode x);

    boolean hasLeftChild(BinNode x);

    boolean hasRightChild(BinNode x);

    boolean hasBothChild(BinNode x);

    boolean isLeaf(BinNode x);

    boolean sibling(BinNode x);

    boolean uncle(BinNode x);

    boolean fromParentTo(BinNode x);


}
