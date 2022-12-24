
## 题目地址
[替换空格](https://leetcode.cn/problems/ti-huan-kong-ge-lcof/)

## 题目描述
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：
```
输入：s = "We are happy."
输出："We%20are%20happy."
```
 
限制：

0 <= s 的长度 <= 10000


## 解法
### 解法1
```java
class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
```

### 解法2
```java
class Solution {
    // 字符数组
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] charArray = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                charArray[size++] = '%';
                charArray[size++] = '2';
                charArray[size++] = '0';
                continue;
            }
            charArray[size++] = s.charAt(i);
        }
        return new String(charArray, 0, size);
    }
}
```


### 解法3
```java
class Solution {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        return s.replace(" ", "%20");
    }
}
```




