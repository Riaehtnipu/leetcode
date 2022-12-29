
## 题目地址
[左旋转字符串](https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

## 题目描述
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

 

示例 1：
```
输入: s = "abcdefg", k = 2
输出: "cdefgab"
```

示例 2：
```
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
```

限制：

* 1 <= k < s.length <= 10000


## 解法
### 解法1
```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        // 可以写完之后再看看这个有没有必要有，即参数校验最后看
        if (s == null) {
            return null;
        }

        StringBuilder pre = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < n) {
                pre.append(s.charAt(i));
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.append(pre).toString();
    }

}
```


### 解法2
```java
class Solution {

    // 简化版
    public String reverseLeftWords(String s, int n) {
        if (s == null) {
            return null;
        }

        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    
}
```

### 解法3
```java
class Solution {

    public String reverseLeftWords(String s, int n) {
        if (s == null) {
            return null;
        }
        return s.substring(n, s.length()) + s.substring(0, n);
    }

}
```

### 解法4
```java
class Solution {

    public String reverseLeftWords(String s, int n) {
        if (s == null) {
            return null;
        }

        // 取余技巧
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res.append(s.charAt((i + n) % s.length()));
        }
        return res.toString();
    }

}
```

### 解法5
```java
class Solution {

    public String reverseLeftWords(String s, int n) {
        // 考虑一下可能的参数异常情况，题目的要求比较松
        if (s == null || s.length() == 0 || n <= 0 || n >= s.length()) {
            return s;
        }
        StringBuilder res = new StringBuilder(s);
        // 出现越界直接不操作
        reverse(res, 0, n - 1);
        reverse(res, n, res.length() - 1);
        reverse(res, 0 ,res.length() - 1);
        return res.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }
}
```

