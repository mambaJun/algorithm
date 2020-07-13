# 第二章
## 排序
### 选择排序
从 一侧开始循环遍历，保证 i 左侧的都是有序的
```java
public static void sort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        // 把当前节点 看作最小 ，然后遍历 [i + 1, n), 记录最小值， 然后 将 arr[i]  arr[min] 交换
        int min = i;
        for (int j = i + 1; j < n; j++) {
            min = arr[j] < arr[min] ? j : min;
        }
        // 交换
        swap(arr, i, min);
    }
}

private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
```
### 插入排序
从一侧开始循环遍历 ， 每次 都是从 [0, i]，进行排序
```java
public static void sort(int[] nums) {
    int n = nums.length;

    for (int i = 1; i < n; i++) {
        // j > 0 , can't equal 不能取等
        for (int j = i; j > 0; j--) {
            if (nums[j] < nums[j - 1]) {
                swap(nums, j, j - 1);
            } else {
                break;
            }
        }
    }
}

private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
```