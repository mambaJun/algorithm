//
// created by jun on 2020/5/5 下午4:41.
//

#ifndef C___BINNODE_H
#define C___BINNODE_H

#define BinNodePosition(T) BinNode<T>* //节点位置

#include <iostream>

using namespace std;


template<typename T>
class BinNode { // 二叉树 节点模板
    BinNodePosition(T)parent, leftChild, rightChild;
    T data;
    int height;

    int size();

    BinNodePosition(T)insertAsLC(T const &);

    BinNodePosition(T)insertAsRC(T const &);

    BinNodePosition(T)succ();

    template<typename VST>
    void travLevel(VST &);

    template<typename VST>
    void travPre(VST &);

    template<typename VST>
    void travIn(VST &);

    template<typename VST>
    void travPost(VST &);
};


#endif //C___BINNODE_H
