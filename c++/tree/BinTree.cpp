//
// created by jun on 2020/5/5 下午11:28.
//

#include "BinTree.h"

template<typename T>
int BinTree<T>::size() const {
    return this->_size;
}

template<typename T>
bool BinTree<T>::empty() const {
    return !_root;
}

template<typename T>
BinNodePosition(T) BinTree<T>::root() const {
    return _root;
}

template<typename T>
int BinTree<T>::updateHeight(BinNodePosition(T)node) {
    return node->height = 1 + max(stature(node->leftChild), stature(node->rightChild));
}

template<typename T>
BinNodePosition(T)BinTree<T>::insertAsRC(BinNodePosition(T) node, const T &data) {
    _size++;
    node->insertAsRC(data);
    updateHeightAbove(node);
    return node->rightChild;
}