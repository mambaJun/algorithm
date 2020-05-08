//
// created by jun on 2020/5/5 下午4:41.
//

#include "BinNode.h"

template<typename T>
BinNodePosition(T)BinNode<T>::insertAsLC(const T &e) {
    return this->leftChild = new BinNode(e, this);
}

template<typename T>
BinNodePosition(T)BinNode<T>::insertAsRC(const T &e) {
    return this->rightChild = new BinNode(e, this);
}

template<typename T>
int BinNode<T>::size() {
    int size = 1;
    if (leftChild) {
        size += leftChild.size();
    }
    if (rightChild) {
        size += rightChild.size();
    }
    return size;
}