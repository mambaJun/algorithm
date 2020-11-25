package com.jun.算法实验.回溯算法;

import java.util.Objects;

/**
 * 1、如果给定的装载问题有解，则采用下面的策略可以得到一个最优装载方案：
 * （1）首先将第一艘轮船尽可能装满；
 * （2）然后将剩余的集装箱装到第二艘轮船上。
 * 将第一艘轮船尽可能装满，等价于选取全体集装箱的一个子集，使该子集中集装箱重
 * 量之和最接近c1。由此可知，装载问题等价于以下特殊的0-1背包问题：
 * max∑𝑤𝑖𝑥𝑖
 * 𝑛
 * 𝑖=1
 * ∑𝑤𝑖𝑥𝑖 ≤ 𝑐1
 * 𝑛
 * 𝑖=1
 * 𝑥𝑖 ∈ {0,1}，1 ≤ 𝑖 ≤ 𝑛
 * 2、求最优解值时，用变量cw表示当前实际载重量，bestw表示当前最优载重量，
 * r=∑ 𝑤𝑖
 * 𝑛
 * 𝑗=𝑖+1 是剩余集装箱的总重量。
 * 该问题解空间可用子集树表示。子集树中可行结点的左儿子结点表示x[i]=1的情形，右
 * 儿子结点表示x[i]=0的情形。引入约束函数用于剪去不含可行解和最优解的子树：
 *  （约束函数）用来剪去不含可行解的分枝：仅当cw+w[i] ≤c时进入可行结点的左子
 * 树，否则剪去左子树。而可行结点的右儿子结点总是可行的，故进入右子树时不需检
 * 查可行性。
 *  （约束函数）用来剪去不含最优解的分枝：由于当前结点的左孩子cw+r值保持不变，
 * 因此无需检查。而仅当右孩子cw+r>bestw时才需要进入右子树搜索，否则应对右子树
 * 进行剪枝。
 *  另外，引入剪去不含最优解分枝的约束函数后，在达到一个叶节点时，就不必再检查
 * 该叶结点是否优于当前最优解，因为算法搜索到的每个叶节点都是迄今为止找到的最
 * 优解。
 * 3、为了在算法中记录与当前最优值相应的当前最优解，需要增加两个数组数据成员x和
 * bestx。x用于记录从根至当前结点的路径；bestx记录当前最优解。算法每搜索到一个叶结
 * 点处，就修正bestx的值。
 * 4、算法实现主体部分如下，请补充完整，并使用下面三个测试案例调试通过。
 * 第一艘船载重60，第二艘船载重40，5个集装箱重量分别为：
 * （1）22 35 24 19 4
 * （2）22 35 24 15 4
 * （3）22 35 24 15 3
 *
 * @author Jun
 * @date 2020/11/24 上午11:02
 */
public class 装载问题 {
    /*
    算法思路 与 分析
        1、如果给定的装载问题有解，则采用下面的策略可以得到一个最优装载方案：
            1）首先将第一艘轮船尽可能装满；
            2）然后将剩余的集装箱装到第二艘轮船上。
     */
    public static void main(String[] args) throws ClassNotFoundException {
        int k = 0;
        int sum = 0;
        int n = 5;

        while (n != 0) {
            for (int i = 0; i < n; i++) {

            }
        }

        String className = "User";
        Class.forName(className);
    }
}

class User {
    private int name;
    private int age;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name == user.name &&
                age == user.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
