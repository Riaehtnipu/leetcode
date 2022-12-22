
## 题目地址
[数组中重复的数字](https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

## 题目描述
找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：
```
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
```
 

限制：

2 <= n <= 100000


## 解法

### 解法1

```java
class Solution {

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 因为0没有符号，无法取反来进行标记，因此+1再取反
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int origin = nums[i];
            if (origin < 0) {
                origin = -origin - 1;
            }
            if (nums[origin] < 0) {
                return origin;
            }
            nums[origin] = -(nums[origin] + 1); 
        }
        return res;
    }
}
```

### 解法2
```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }

            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                };
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
```

### 解法3
```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}

```