//
// created by jun on 2020/5/5 下午4:06.
//

#define BinNodePosition(T) BinNode<T>* //节点位置

#define stature<p> ((p) ? p->height : -1) // 节点高度

typedef enum { // 节点颜色
    RB_RED, RB_BLACK
} RB_COLOR;

template<typename T>
struct BinNode { // 二叉树 节点模板
    T data;
    BinNodePosition(T)parent;
    BinNodePosition(T)leftChild;
    BinNodePosition(T)rightChild;
    int height;
    int npl; // NULL Path Length
    RB_COLOR color;

    // 构造函数
    BinNode() {}

    BinNode(T data, BinNode<T> *parent, BinNode<T> *leftChild, BinNode<T> *rightChild, int height, int npl,
            RB_COLOR color) : data(data), parent(parent), leftChild(leftChild), rightChild(rightChild), height(height),
                              npl(npl), color(color) {}


};
