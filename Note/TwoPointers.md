# Two Pointers 双指针技巧总结

双指针技巧可以分为 **(1) 快慢指针**; **(2) 左右指针** 两类, 前者主要解决链表中的问题, 比如链表找环; 
后者主要解决数组(字符串)中的问题, 比如二分查找.

---

## 快慢指针

快慢指针一般都初始化指向链表的头结点`head`, 前进时快指针`fast`在前, 慢指针`slow`在后, 巧妙解决一些链表中的问题.

### 1. 判定链表中是否含有环

我们使用两个指针, `fast`与`slow`, 它们起始都位于链表的头部. 
随后,`slow`指针每次向后移动一个位置, 而`fast`指针向后移动两个位置.
如果链表中存在环, 则`fast`指针最终将再次与`slow`指针在环中相遇.

题目: #141 

### 2. 已知链表中含有环, 返回这个环的起始位置

快慢指针第一次相遇时, 假设慢指针`slow`走了`k`步, 
那么快指针`fast`一定走了`2k`步, 也就是说比`slow`多走了`k`步 (**也就是环的长度**)。

设相遇点距环的起点的距离为`m`, 那么环的起点距头结点`head`的距离为`k - m`, 
也就是说如果从`head`前进`k - m`步就能到达环起点。

题目: #142

### 3. 寻找链表中点

题目：#876, 1669

类似上面的思路, 我们还可以让快指针一次前进两步, 慢指针一次前进一步, 当快指针到达链表尽头时, 慢指针就处于链表的中间位置.

寻找链表中点的一个重要作用是对链表进行归并排序

回想数组的归并排序: 求中点索引递归地把数组二分, 最后合并两个有序数组。
对于链表, 合并两个有序链表是很简单的, 难点就在于二分。

### 4. 寻找链表倒数第k个元素

我们的思路还是使用快慢指针, 让快指针先走`k`步, 然后快慢指针开始同速前进。
这样当快指针走到链表末尾`null`时, 慢指针所在的位置就是倒数第`k`个链表节点。

---

## 左右指针的常用算法

定义: 两个指针相对而行

左右指针在数组中实际是指两个索引值, 一般初始化为`left = 0, right = nums.length - 1`. 

### 1. 二分查找

见`BinarySearch.md`.

### 2. 两数之和

**升序数组**中求两个数的和等于`target`.

```java
public class TwoSum{
    public int[] twoSum(int [] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{left, right};
            } else if (sum < target){
                // 如果 sum 小于 target, 增大 sum
                left++;
            } else if (sum > target){
                // 如果 sum 大于 target, 减小 sum
                right--;
            }
        }
        return new int[]{left, right};
    }
}
```

题目: #1, 167

### 3. 反转数组

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

### 4. 判断一个字符串是否为回文

伪代码: 

```
     for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
          if (s.charAt(i) != s.charAt(j)) {
              return false;
          }
     }
     return true;
```

题目: #125

### 5. 滑动窗口

见`SlidingWindow.md`.

---