# Binary search

二分查找: 分治算法的一种

基本形式: 从单调递增数组中, 查找一个值是否存在

**判断一个值是否是解通常比求解容易**

- 整数区间二分 [left, right] , left <= right

- `left = mid + 1` 或 `right = mid - 1`

- 解是什么? left - 1 或 right + 1

```java
// 左右界限
left, right;
while (left <= right) {
    mid = left + (right - left) / 2;
    if (fit(mid)) {
        // 如果满足条件，记录答案
        ...
        // 减小右边界以找到更小的满足要求的值
        right = mid - 1;
    } else {
        // 如果不满足条件，增加天数以放宽条件
        left = mid + 1;    
    }
}
```

题目: #69, 1482， 1552

"先猜后证"