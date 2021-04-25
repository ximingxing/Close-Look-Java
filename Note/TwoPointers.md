# Two Pointers 双指针

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

题目: #125

---