package com.jun._22括号生成;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jun
 * @date 2020/7/31 上午9:25
 */
public class _22括号生成_BFS {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }

    private static class Node {
        private String str;
        private int left;
        private int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    /*
        广度优先搜索（BFS）
        BFS 是借助 队列，入队 然后出队 将子节点存入，实现 树的 层级遍历

    */

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        // 队列 进行存放 树节点
        Queue<Node> queue = new LinkedList<>();
        // 将根节点 存入队列
        queue.offer(new Node("", 0, 0));

        // 如果队列非空 说明还有节点继续遍历
        while (!queue.isEmpty()) {
            // 按照顺序 取出节点 进行 对 当前节点进行操作
            // 然后 按照 树的访问顺序 放入 当前节点的子节点
            Node node = queue.poll();
            if (node.left == n && node.right == n) {
                list.add(node.str);
                continue;
            }
            // 剪枝
            if (node.left < node.right) {
                continue;
            }
            if (node.left < n) {
                queue.offer(new Node(node.str + "(", node.left + 1, node.right));
            }
            if (node.right < n) {
                queue.offer(new Node(node.str + ")", node.left, node.right + 1));
            }
        }
        return list;
    }

/*    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.str);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.str + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.str + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }*/
}
