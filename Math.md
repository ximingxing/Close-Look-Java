# Math

### 最大公约数 Greatest Common Divisor (gcd) 

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

---

### 最小公倍数 Lowest Common Multiple (lcm)

**求解最小公倍数**: `p * n = lcm(p, n) * gcd(p, n)`

```java
    private long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }
```

题目: #1201,

---

### 容斥原理 (Inclusion-Exclusion principle)

容斥原理可以描述如下:

> 要计算**几个集合并集**的大小,我们要先将所有**单个集合**的大小计算出来,然后减去所有**两个集合**相交的部分,再加回所有**三个集合**相交的部分,再减去所有**四个集合**相交的部分;
> 依此类推,,一直计算到所有集合相交的部分.

题目: #1201,

---

### 快速模取幂算法 (Fast Modular Exponentiation)

题目: #50,

---

### 组合计数 (Combinatorial enumeration)

* 递推式 (<font color=red>计数不一定要枚举</font>)

    递推式本身的定义、初值和递推关系

* 前缀和: 从头开始连续若干项的和, 即前若干项和

    * `presum[i] = arr[0] + arr[1] + ... + arr[i-1]`
    * 对`j < i`, `presum[i + 1] - presum[j] =  arr[j] + arr[j + 1] + ... + arr[i]`. (任意子数组的和可以通过前缀和之差的方式计算)

> 为了快速计算任意子数组的和，可以通过维护前缀和的方式

题目: #1524

---

### 概率问题