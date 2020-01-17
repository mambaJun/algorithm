# 四数之和
>给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。  
>注意：  
>答案中不可以包含重复的四元组。  

下面把题目变一下

>给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ...m ，使得 a + b + c + d + ... + m 的值与 target 相等？找出所有满足条件且不重复的m元组。  
>注意：  
>答案中不可以包含重复的m元组。 

通过 两数之和、三数之和、四数之和 推出 n 数之和

先说一下两数之和，最容易想的一定是 两层for循环 O(n^2)  优化方法 用 map key匹配的方法 优化成 O(n)

下面给个这类通用方法；  

这里 的 排序很重要，如果不排序发现根本没法下手
每多一层就加一层 for,最后简化成 三数之和
- 步骤
1. 排序
2. for 里嵌套 for一直到 三数之和
3. over
提示：
    for 和 递归 可以互相转换，也就是说通过递归，一直到递归出口，但是递归比for更加消耗内存，这个方法不适用n 过大，还在刷题总结中，后面看看有没有更好的方法

- 代码  
三数之和
```java
for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            // 跳过重复答案
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] == target) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                        continue;
                    }
                    if (nums[i] + nums[l] + nums[r] < target) {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        continue;
                    }
                    if (nums[i] + nums[l] + nums[r] > target) {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                        continue;
                    }
                }
            }
        }
```
四数之和  
```java
public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; ++j) {
                int l = j + 1;
                int r = length - 1;
                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l = moveLeft(nums, l, r);
                        r = moveRight(nums, l, r);
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        l = moveLeft(nums, l, r);
                        continue;
                    }
                    r = moveRight(nums, l, r);
                }
                while (j < length - 2 && nums[j] == nums[j + 1]) j++;
            }
            while (i < length - 3 && nums[i] == nums[i + 1]) i++;
        }
        return result;
}

private static int moveRight(int[] nums, int l, int r) {
    while (l < r && nums[r] == nums[r - 1]) r--;
    r--;
    return r;
}

private static int moveLeft(int[] nums, int l, int r) {
    while (l < r && nums[l] == nums[l + 1]) l++;
    l++;
    return l;
}
```
