# [剑指offer26] 树的子结构

[TOC]

## 题目

> 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
>
> B是A的子结构， 即 A中有出现和B相同的结构和节点值。
>
> 例如:
> 给定的树 A:
>
>  3
> / \
>
>    4   5
>   / \
>  1   2
> 给定的树 B：
>
>    4 
>   /
>  1
> 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
>
> 示例 1：
>
> 输入：A = [1,2,3], B = [3,1]
> 输出：false
> 示例 2：
>
> 输入：A = [3,4,5,1,2], B = [4,1]
> 输出：true
> 限制：
>
> 0 <= 节点个数 <= 10000
>
> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 解题思路

如果`B` 是树 `A` 的子结构，则子结构的根节点可能是树 `A` 上的任意一个节点。所以判断`B`是不是树`A`的子结构，需要完成以下两步工作：

1. 先序遍历树`A`上的每个节点 A<sub>i</sub> （对应的函数 `isSubStructure(A, B)`）

2. 判断树`A`上 以A<sub>i</sub>为根节点的子树是否包含树`B`（对应函数 `recur(A, B)`）

   <div align="center"  >
   <img src="https://raw.githubusercontent.com/mambaJun/picture/master/blog/20210201224726.png" width="50%"/>    
   </div>

## 算法流程

`recur(A, B)`函数：

1. 终止条件：
   1. 当节点B为空时，说明树B 已经匹配完成了，返回 `true`;
   2. 当节点A为空时，说明树B的节点已经超越了树A 的节点，即匹配失败，返回false;
   3. 当节点A和B的值不同时，说明不是子树，返回false;
2. 返回值：
   1. 判断A 和 B的**左**节点是否相等，即 `recur(A.left, B.left）`;
   2. 判断 A 和 B 的**右**子节点是否相等，即 `recur(A.right, B.right)` ；

`isSubStructure(A, B)`函数：

1. 特例处理：当树A和树B 为空时，直接返回 false;
2. 返回值：若树B 是树A的子结构，则必须满足下面三种情况之一，因此用 或`||`连接;
   1. 以节点A 为根节点的子树包含树B `recur(A, B)`
   2. 树B是树A左子树的子结构 `isSubStructure(A.left, B)`
   3. 树B是树A右子树的子结构 `isSubStructure(A.right, B)`

##  复杂度分析

- **时间复杂度 $\ O(MN)$：**M、N 分别为树 A 和 树 B的节点数量;先序遍历树 A占用 $\ O(M)$，每次调用 `recur(A, B)`判断占用 $\ O(N)$。
- **空间复杂度 $\ O(M)$：**当树A 和树B 都退化成链表时，递归调用深度最大。
  - 当 M < N时，遍历树 A与递归判断总递归深度为M;
  - 当M > N 时，最差情况为遍历到树A 叶子节点，此时总递归深度为M。

## 代码

```java
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
```

