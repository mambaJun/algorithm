//
// created by jun on 2020/5/5 下午11:28.
//

#ifndef C___BINTREE_H
#define C___BINTREE_H

#include "BinNode.h"
#define stature(p) ((p) ? (p)->height : -1)


template<typename T>
class BinTree {
protected:
    int _size;
    BinNodePosition(T) _root;

    virtual int updateHeight(BinNodePosition(T)node); // 更新新节点 node 的高度

    void updateHeightAbove(BinNodePosition(T)node);  // 更新Node 以及祖先的高度

public:
    int size() const ;

    bool empty() const;

    BinNodePosition(T)root() const;

    BinNodePosition(T)insertAsRC(BinNodePosition(T)node, T const &data);
};


#endif //C___BINTREE_H
