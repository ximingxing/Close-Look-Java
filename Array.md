# Array

* 优点: `O(1)`时间里根据数组的下标查询某个元素.

* 缺点: 构建时需要分配一段连续的空间. 查询某个元素是否存在时需要遍历整个数组, 耗费`O(n)`的时间.

---

### 循环不变量

定义: 声明的变量在遍历的过程中保持定义不变.

For example: **荷兰国旗问题**

Solution: `[0, i)`均为`0`, `[i, j)`均为`1`, `[j, k]`未知, `[k+1, nums.length-1)`均为`2`.

注意: 这个式子在循环的过程中定义不改变, 仅改变变量的取值.

题目：#75

---

### 双指针

双指针技巧可以分为 **(1) 快慢指针**; **(2) 左右指针** 两类, 前者主要解决链表中的问题, 比如链表找环; 
后者主要解决数组(字符串)中的问题, 比如二分查找.

#### 左右指针的常用算法

定义: 两个指针相对而行

* 解决线性表(数组、链表)相关问题.
* 使用两个指针(下标)简化枚举, 降低算法时间复杂度.

##### 1. 二分查找

见`BinarySearch.md`.

##### 2. 两数之和
   
```java
public class TwoSum{
    public int[] twoSum(int [] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{left, right};
            }else if (sum < target){
                left++;
            }else if (sum > target){
                right--;
            }
        }
        return new int[]{left, right};
    }
}
```

题目: #1, 167

##### 3. 反转数组

```java
public class Reverse{
    public void reverseString(char [] arr){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
```

题目: #344

##### 4. 判断一个字符串是否为回文

```java
     for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
          if (s.charAt(i) != s.charAt(j)) {
              return false;
          }
     }
     return true;
```

题目: #

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
     public int findSubArray(int[] nums) {
         int N = nums.length; // 数组/字符串长度
         int left = 0, right = 0; // 双指针, 表示当前遍历的区间[left, right], 闭区间
         int res = 0; //  保存最大的满足题目要求的 子数组/子串 长度
         int sums = 0; // 用于统计 子数组/子区间 是否有效，根据题目可能会改成求和/计数
         while (right < N) { // 当右边的指针没有搜索到 数组/字符串 的结尾
             sums += nums[right];  // 增加当前右边指针的数字/字符的求和/计数
             while (区间[left, right]不符合题意) { // 此时需要一直移动左指针，直至找到一个符合题意的区间
                 sums -= nums[left]; // 移动左指针前需要从counter中减少left位置字符的求和/计数
                 i++; // 移动左指针
             }
             // 当while结束时, 我们找到一个符合题意的 子数组/子串
             res = Math.max(res, right - left + 1); // 更新结果
             right ++; // 移动右指针, 去探索新的区间
         }
         return res;
     }
}
```

滑动窗口中用到了左右两个指针, 它们移动的思路是: **以右指针作为驱动, 拖着左指针向前走.
右指针每次只移动一步, 而左指针在内部 while 循环中每次可能移动多步.
右指针是主动前移, 探索未知的新区域; 左指针是被迫移动, 负责寻找满足题意的区间**.

题目: #1004, 1234, 80

---
 
### 代替map
 
理解数组作为map, 并建立映射关系
 
* 如果一个map(HashMap)的key为整数, 并且范围很小, 则可以使用数组代替.
* key可能需要通过变换转换为非负整数.
 
题目: #1637