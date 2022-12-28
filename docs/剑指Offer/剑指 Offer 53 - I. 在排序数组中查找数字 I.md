
## 题目地址
[https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/](I. 在排序数组中查找数字 I)

## 题目描述
统计一个数字在排序数组中出现的次数。

 

示例 1:
```
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
```

示例 2:
```
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
```

提示：

* $0 <= nums.length <= 10^5$
* $-10^9 <= nums[i] <= 10^9$
* nums 是一个非递减数组
* *$-10^9 <= target <= 10^9$


## 解法
### 解法1
参考[labuladong](https://labuladong.github.io/algo/2/20/29/)

```java
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 数组题常见的解法双指针、二分搜索
        // 首先明确变量的含义，left和right分别代表搜索范围的左右边界（闭区间）
        // 所以想不漏掉必须是left <= right
        // while循环相当于在尝试，现在大区间尝试，不断缩小尝试的范围
        // 解法1：引入额外变量，让right、left不再承担两个工作
        int left = 0;
        int right = nums.length - 1;
        int lres = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                lres = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (lres == -1) {
            return 0;
        }

        left = 0;
        right = nums.length - 1;
        int rres = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                rres = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return rres - lres + 1;        
    }

}
```


### 解法2
```java
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 解法2：不引入额外变量，让right、left除了有范围的含义还有lres、rres的功能
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 可以合并分支，这样写更清楚一点
            // 如果区间存在这个值一定会走到这个分支，因为下面两个分支都不会过滤掉正确答案
            // 如果存在这个值最后的left等于这个值，因为left不会过滤答案。
            // 也有可能没有这个值，需要判断一下。
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int lres = left;
        if (lres >= nums.length || nums[lres] != target) {
            return 0;
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int rres = right;

        return rres - lres + 1;        
    }

}
```

### 解法3
```java
class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 解法三:封装一下
        int lres = binarySearch(nums, target, true);
        if (lres == -1) {
            return 0;
        }
        int rres = binarySearch(nums, target, false);
        return rres - lres + 1;
    }

    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res = mid;
                right = isLeft ? mid - 1 : right;
                left = isLeft ? left : mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }


}
```



