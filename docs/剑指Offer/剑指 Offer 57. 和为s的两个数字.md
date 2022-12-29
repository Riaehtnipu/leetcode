
## 题目地址
[和为s的两个数字](https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

## 题目描述

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

 

示例 1：
```
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
```


示例 2：
```
输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]
```

 

限制：

* 1 <= nums.length <= 10^5
* 1 <= nums[i] <= 10^6


## 解法
### 解法1
排序数组常用方法：双指针，解空间为矩形的右上角部分，类似九九乘法表。利用特殊的遍历方法，可以不需要遍历每一个可能的解。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 有限制不会溢出
            // 没有限制的话用减法还是有溢出的可能，用long更好
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }


}
```


### 解法2
```java
class Solution {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                return new int[]{target - nums[i], nums[i]};
            }
            set.add(nums[i]);
        }
        return new int[0];
    }
}
```

