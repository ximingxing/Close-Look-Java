### 50. Pow(x, n)

> **Medium**

Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

#### Constraints:

* -100.0 < x < 100.0
* -231 <= n <= 231-1
* -104 <= xn <= 104

#### Example:
```
Input: x = 2.00000, n = 10
Output: 1024.00000
```

```
Input: x = 2.10000, n = 3
Output: 9.26100
```

```
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
```

#### Solution:

这道题目暴力解法为for循环n次x相乘, 时间复杂度为`O(n)`, 
使用快速模取幂算法可以将幂运算复杂度变为`O(logn)`

解法1: 快速模取幂算法
解法2: 堆栈模拟递归调用
