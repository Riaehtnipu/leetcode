
## 题目地址
[0～n-1中缺失的数字](https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/)

## 题目描述
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

 

示例 1:
```
输入: [0,1,3]
输出: 2
```
示例 2:
```
输入: [0,1,2,3,4,5,6,7,9]
输出: 8
```

限制：

1 <= 数组长度 <= 10000


## 解法
### 解法1
```java
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 目的：0 ~ nums.length - 1中找到第一个不满足nums[i] = i的i值
        // 如果不满足返回nums.length
        // 方法1：使用res变量做记录
        int left = 0;
        int right = nums.length - 1;
        // 找不到默认值不用-1，用nums.length
        int res = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] < mid) {
                // 不可能出现
                throw new RuntimeException();
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

}
```


### 解法2
```java
class Solution {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 方法2：用left替代res作用，因为left的移动不会导致解丢失
        int left = 0;
        int right = nums.length - 1;
        // 找不到默认值不用-1，用nums.length
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] < mid) {
                // 不可能出现
                throw new RuntimeException();
            } else {
                right = mid - 1;
            }
        }
        return left;
    }    
}
```


