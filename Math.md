# Math

### Greatest Common Divisor (gcd) and Lowest Common Multiple (lcm)
(最大公约数和最小公倍数)

**求解最大公约数**: Euclidean algorithm (欧几里得算法)

> 亦称作 "辗转相除法"

* 基本原理 : 设 `x >= y`, `gcd(x, y) = gcd(x - y, y) = gcd(x % y, y)`
* 伪代码 : `gcd(x, y) = y > 0 ? gcd(y, x % y) : x`
* 算法复杂度 : `O(log(max(x, y))) = O(log(x + y))`

```java
int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
}
```

题目：#914,

**求解最小公倍数**: `p * n = lcm(p, n) * gcd(p, n)`

```java
private long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
}
```

题目: #1201,

---

### 容斥原理

容斥原理可以描述如下:

> 要计算**几个集合并集**的大小，我们要先将所有**单个集合**的大小计算出来，然后减去所有**两个集合**相交的部分，再加回所有**三个集合**相交的部分，再减去所有**四个集合**相交的部分，依此类推，一直计算到所有集合相交的部分.
>
---

### 快速模取幂算法

题目: #50,

---