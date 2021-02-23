### 75. Sort Colors

> **Medium**

Given an array `nums` with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

#### Constraints:

* `n == nums.length`
* `1 <= n <= 300`
* `nums[i]` is `0`, `1`, or `2`.

#### Example:
```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

```
Input: nums = [2,0,1]
Output: [0,1,2]
```

```
Input: nums = [0]
Output: [0]
```

```
Input: nums = [1]
Output: [1] d
```

#### Follow up:

Could you solve this problem without using the library's sort function?
Could you come up with a one-pass algorithm using only O(1) constant space?

#### Solution:

**荷兰国旗问题**

核心: 循环不变量

* 这里循环不变量`[0, i)`为0区, `[i..j)`为1区, `[j, k]`为未知区, `[k+1..nums.length-1]`为2区
* 初值 `i=0, j=0, k=nums.length -1`, 0区、1区、2区为空
* 循环j (从index=0开始)
    * 如果`num[j]==0`, 交换`num[j]`和`nums[i]`, `++i` (相当于0区扩大1, 0区向右扩大)
    * 如果`num[j]==2`, 交换`num[j]`和`nums[k]`, `--j, --k` (相当于2区扩大1, 2区向左扩大; 同时`num[k]`元素未知, 需要`j--`重新遍历)
