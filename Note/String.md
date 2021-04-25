# String

---

### 字符串匹配问题

#### 朴素匹配法

枚举原串中每个字符作为起点, 每次从原串起点出发与匹配串起点开始匹配.

```java
class Solution {
    int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        // 枚举原串每个字符作为起始点
        for (int i = 0; i <= n - m; i++) {
            // 从原串开始和匹配串的首位开始, 尝试匹配
            int a = i, b = 0;
            while (b < m && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            // 如果能够完全匹配, 返回原串的起点下标
            if (b == m) return i;
        }
        // 原串中不存在匹配串
        return -1;
    }
}
```

#### KMP算法

**KMP算法**是一个快速查找匹配串的算法, KMP算法复杂度为`O(m+n)`, 
`m`为原串长度, `n`为匹配串长度.

首先明确一些概念:

1. 前缀: 包含首字母但不包含尾字母的所有子串.

2. 后缀: 包含尾字母但不包含首字母的所有子串.

3. **最长公共前后缀**: 前缀和后缀的交集中最长的子串.

4. **前缀表**: 前缀表是用来回退的, 它记录了模式串与主串(文本串)不匹配的时候, 模式串应该从哪里开始重新匹配.

题目：#28

---