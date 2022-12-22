
## 题目地址
[求1+2+…+n](https://leetcode.cn/problems/qiu-12n-lcof/)

## 题目描述
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

 

示例 1：
```
输入: n = 3
输出: 6
```
示例 2：
```
输入: n = 9
输出: 45
```
 

限制：

* 1 <= n <= 10000


## 解法
### 解法1
```java
class Solution {

    // 不做参数校验了，因为需要if
    public int sumNums(int n) {
        // 从if演化过来，无关变量是用来通过编译的
        boolean flag = (n > 1) && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int sumNums(int n) {
        return sum(n, 0);
    }

    // 求1到n，再加total的值
    int sum(int n, int total) {
        boolean flag = (n > 0) && (total = sum(n - 1, n + total)) > 0;
        return total;
    }

}
```


### 解法2
```java
class Solution {

    public int sumNums(int n) {
        int a = 1 + n; 
        int b = n;

        int res = 0;

        // 编译用
        boolean flag;

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;         

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1;  

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        flag = ((b & 1) == 1) && (res += a) > 0;
        a <<= 1;
        b >>= 1; 

        return res >> 1;
    }
}
```
