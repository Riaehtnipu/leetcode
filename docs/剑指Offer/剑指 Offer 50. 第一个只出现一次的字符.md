
## 题目地址
[第一个只出现一次的字符](https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

## 题目描述
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例 1:
```
输入：s = "abaccdeff"
输出：'b'
```

示例 2:
```
输入：s = "" 
输出：' '
```

限制：

0 <= s 的长度 <= 50000


## 解法
### 解法1
```java
class Solution {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        // 更省空间,可以选择存数量、存索引、存boolean
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }

        for (int i = 0; i < s.length(); i++) {
            // 一定存在key
            if(map.get(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

}
```


### 解法2
```java
class Solution {

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }
        // 遍历速度会变快
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            // 一定存在key
            if(entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

}
```

### 解法3
```java
class Solution {
    
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        Map<Character, Boolean> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        // 空间换时间，使用队列，避免多遍历一次
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
            if (map.get(s.charAt(i))) {
                queue.offer(s.charAt(i));
            } else {
                // 延迟删除
                while (!queue.isEmpty() && !map.get(queue.peek())) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? ' ' : queue.peek();
    }
}
```



