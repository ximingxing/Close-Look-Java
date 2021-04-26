### 1201. Ugly Number III

> **Medium**

Given four integers `n`, `a`, `b`, and `c`, return the `n^th` ugly number.

Ugly numbers are **positive integers** that are divisible by `a`, `b`, or `c`.

#### Constraints:

* `1 <= n, a, b, c <= 109`
* `1 <= a * b * c <= 1018`
* It is guaranteed that the result will be in range `[1, 2 * 109]`.

#### Example:
```
Input: n = 3, a = 2, b = 3, c = 5
Output: 4
Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
```

```
Input: n = 4, a = 2, b = 3, c = 4
Output: 6
Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
```

```
Input: n = 5, a = 2, b = 11, c = 13
Output: 10
Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
```

```
Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
Output: 1999999984
```

#### Solution:

核心: 二分查找, 容斥原理, 最小公倍数

二分答案x，对于每个x，利用容斥原理，考察满足条件的数的个数等于任意一个数的倍数的个数之和，减去任意两个数的公倍数个数之和，加上3个数的公倍数个数.
