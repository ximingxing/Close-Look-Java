# Math

### Greatest Common Divisor (gcd) and Lowest Common Multiple (lcm)

(最大公约数和最小公倍数)

* 性质 : `p * n = lcm(p, n) * gcd(p, n)`

**Solution**: Euclidean algorithm (欧几里得算法)

> 亦称作 "辗转相除法"

* 基本原理 : 设 `x >= y`, `gcd(x, y) = gcd(x - y, y) = gcd(x % y, y)`
* 伪代码 : `gcd(x, y) = y > 0 ? gcd(y, x % y) : x`
* 算法复杂度 : `O(log(max(x, y))) = O(log(x + y))`

```java
int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
}
```

题目: #914, 1201

### 

