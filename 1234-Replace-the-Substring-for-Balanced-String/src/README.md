### 1234. Replace the Substring for Balanced String

> **Medium**

You are given a string containing only 4 kinds of characters `'Q', 'W', 'E' and 'R'`.

A string is said to be balanced if each of its characters appears `n/4` times where n is the length of the string.

Return the minimum length of the substring that can be replaced with any other string of the same length to make the original string s balanced.

Return 0 if the string is already balanced.

#### Constraints:

* `1 <= s.length <= 10^5`
* `s.length is a multiple of 4`
* `s` contains only `'Q', 'W', 'E' and 'R'`.


#### Example:
```
Input: s = "QWER"
Output: 0
Explanation: s is already balanced.
```

```
Input: s = "QQWE"
Output: 1
Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
```

```
Input: s = "QQQW"
Output: 2
Explanation: We can replace the first "QQ" to "ER". 
```

```
Input: s = "QQQQ"
Output: 3
Explanation: We can replace the last 3 'Q' to make s = "QWER".
```

#### Solution:

滑动窗口