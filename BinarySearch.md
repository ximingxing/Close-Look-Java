# Binary search

二分查找: 分治算法的一种

基本形式: 从单调递增数组中, 查找一个值是否存在

最常用的二分查找场景: 寻找一个数, 寻找左侧边界、寻找右侧边界

**判断一个值是否是解通常比求解容易**

二分查找框架:

```java
public class BinarySearch{
    int binarySearch(int[] nums, int target) {
        int left = 0, right = ...;
    
        while(...) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ...
            } else if (nums[mid] < target) {
                left = ...
            } else if (nums[mid] > target) {
                right = ...
            }
        }
        return ...;
    }
}
```

### 寻找一个数字(基本的二分搜索)

场景: 搜索一个数, 如果存在, 返回其索引, 否则返回-1.

```java
public class BinarySearch{
    int binarySearch(int[] nums, int target) {
        // 搜索范围 [left, right] 左闭右闭区间
        int left = 0; 
        int right = nums.length - 1; 
        
        // 搜索区间为空的时候应该终止
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
            else if (nums[mid] == target) // 停止搜索条件
                return mid;
        }
        // 在 nums 中未找到 target 返回 -1
        return -1;
    }
}
```

`while(left <= right)`的终止条件是`left == right + 1`, 写成区间形式为`[right +1, right]`.

`while(left < right)`的终止条件是`left == right`, 写成区间的形式是`[right, right]`, 
例如, 结束时区间为`[2, 2]`, 可是当前`2`还没有被索引过, `while`就终止了.

题目: #69, 1482， 1552

### 寻找左侧边界的二分搜索

有序数组`nums = [1,2,2,2,3]`, target为`2`, 目标: 寻找 target 的左边界, 即`1`的索引. 

```java
public class BinarySearch{
    public int left_bound(int [] nums, int target){
        if (nums.length = 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right){ // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[i] == target) {
                // 找到 target 时不要立即返回，
                // 而是缩小「搜索区间」的上界 right，
                // 在区间 [left, mid) 中继续搜索，即不断向左收缩，达到锁定左侧边界的目的.
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
}
```

### 寻找右侧边界的二分搜索

有序数组`nums = [1,2,2,2,3]`, target为`2`, 目标: 寻找 target 的右边界, 即`3`的索引.

```java
public class BinarySearch{
    public int right_bound(int [] nums, int target){
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (num[mid] > target) {
                right = mid - 1;
            } else if (num[mid] == target){
                // 找到 target 时不要立即返回，
                // 而是缩小「搜索区间」的上界 right，
                // 在区间 [left, mid) 中继续搜索，即不断向左收缩，达到锁定左侧边界的目的.
                left = mid + 1;
            }
        }
        
        if (right < 0 || nums[right] != taget)
            return -1;
        return right;
    }
}
``` 