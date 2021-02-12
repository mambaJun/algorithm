package com.jun.offer36二叉搜索树与双向链表;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2021/2/11 下午11:07
 */
public class offer36二叉搜索树与双向链表 {

}

class Solution {
    /*
        首先观察到题目给的是一棵 BST，这就意味着我们只需要用中序遍历就能实现排序的链表了。
        最终得到的链表的头节点必然是 BST 最左边的节点（题目示例中就是 1）；尾节点必然是 BST 最右边的节点（题目示例中就是 5）。
        1、先定义 head 和 tail，初始它们都是 null，到最后则会一个指向尾节点一个指向头节点。
        2、中序遍历，首先 root 一直往左走，走到了最左边的 1 处，此时 tail 还是 null，并且整个遍历过程中只（有这个时候 tail 会是 null）。这个时候我们让 head = root，也就找到了链表的头节点。
        然后我们更新 tail = root（也就是 1），root 会回溯到上一级也就是 2。这时我们就写 tail -> right = root; 和 root -> left = tail;。
        我们此时接着更新 tail = root（也就是 2）。如此往复。
        中序遍历走完之后，链表也就构造完了，除了 head 和 tail 之间的连接，我们再连接一下就好了（代码对应处有注释）。
    */

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node head;
    private Node tail;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        // 构造出链表的所有结构，除了头连尾和尾连头的两个指针
        inorder(root);
        // 补上头连尾
        head.left = tail;
        // 补上尾连头
        tail.right = head;

        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        // 中序遍历 （左）
        inorder(root.left);
        
        // 当tail还不存在，也就是root此时在整个BST的最左边的节点，这个节点就是head
        if (tail != null) {
            head = root;
        } else {
            tail.right = root;
            root.left = tail;
        }
        tail = root;

        // 中序遍历 （you）
        inorder(root.right);
    }
}
