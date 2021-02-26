# Array/String

* 优点: `O(1)`时间里根据数组的下标查询某个元素.

* 缺点: 构建时需要分配一段连续的空间. 查询某个元素是否存在时需要遍历整个数组, 耗费`O(n)`的时间.

<font color=red>一维数组可以理解为key是连续整数的map.</font>

---

### 循环不变量

定义: 声明的变量在遍历的过程中保持定义不变.

**荷兰国旗问题**

题目：#75, 

---

### 代替map

理解数组作为map, 并建立映射关系

* 如果一个map(HashMap)的key为整数, 并且范围很小, 则可以使用数组代替.
* key可能需要通过变换转换为非负整数.

**分桶原理**:

1.  
2. 

题目: #1637

---

### 双指针

定义: 两个指针相对而行

* 解决线性表(数组、链表)相关问题.
* 使用两个指针(下标)简化枚举, 降低算法时间复杂度.

**例题:**

判断一个字符串是否为回文:

```java
    for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
         if (s.charAt(i) != s.charAt(j)) {
             return false;
         }
    }
    return true;
```

题目: #1

---

### 滑动窗口

定义: 两个指针同向互相追赶

* 解决线性表(数组、链表)相关问题.
* 使用两个指针(下标)互相追赶, 动态维护窗口内的状态.

《挑战程序设计竞赛》这本书中把滑动窗口叫做「虫取法」, 非常生动形象.
因为滑动窗口的两个指针移动的过程和虫子爬动的过程非常像: 前脚不动, 把后脚移动过来; 后脚不动, 把前脚向前移动.

为什么滑动窗口可以降低复杂度? 单调性(窗口不会倒退, 而是从i不断前进, 将算法从O(n^2/3) -> O(2n)

**模版:**

```java
class Solution {
    public int findSubArray(int[] A, int K) {
        int N = A.length; // 数组/字符串长度
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < N) {
            if (A[right] == 0)
                zeros ++;
            while (zeros > K) {
                if (A[left++] == 0) 
                    zeros --;
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;
    }
}
```


题目: #1234

---