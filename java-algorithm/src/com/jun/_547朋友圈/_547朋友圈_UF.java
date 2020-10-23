package com.jun._547朋友圈;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出：2
 * 解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出：1
 * 解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/10/23 下午3:55
 */
public class _547朋友圈_UF {
    private int count;
    private int[] parent;

    public static void main(String[] args) {
        _547朋友圈_UF obj = new _547朋友圈_UF();
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
//        [[1,1,0],[1,1,0],[0,0,1]]

        System.out.println(obj.findCircleNum(M));
    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int n = M.length;
        count = n;
        parent = new int[n];

        // 初始化 id 列表
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (connected(i, j)) {
                    continue;
                }
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        return count();
    }

    /**
     * 查
     *
     * @param x
     * @return
     */
//    int find(int x) {
//        System.out.printf("------ find 开始 %d %d\n", parent[x], x);
//
//        // 查找
//        while (parent[x] != x) {
//            System.out.printf("------ find 中 %d %d\n", parent[x], x);
//            x = parent[x];
//        }
//
//        System.out.printf("------ find 结束 %d %d3\n", parent[x], x);
//        return x;
//    }

    int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    /**
     * 并
     *
     * @param p
     * @param q
     */
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        parent[pRoot] = qRoot;
        count--;
    }

    /**
     * 是否联通
     *
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 分量数量
     *
     * @return
     */
    int count() {
        return count;
    }
}
