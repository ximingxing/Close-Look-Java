### 1551. Minimum Operations to Make Array Equal

> **Medium**

You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).

In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). 
The goal is to make all the elements of the array equal. 
It is guaranteed that all the elements of the array can be made equal using some operations.

Given an integer n, the length of the array. 
Return the minimum number of operations needed to make all the elements of arr equal.

#### Note:

* 1 <= n <= 10^4

#### Example:
```
Input: n = 3
Output: 2
Explanation: arr = [1, 3, 5]
First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].
```

```
Input: n = 6
Output: 9
```

#### Solution:

If the array looks like `[1, 3, 5, 7, 9, 11]`, then `[1 + 5, 3 + 3, 5 + 1, 7 - 1, 9 - 3, 11 - 5]`.
- **Minimum number of operations** : `1 + 3 + 5 = 9`.
- The equivalent of the sum of the `n / 2` positive even numbers. (相当于前 `n / 2` 个正奇数的和.)
- The first item: `1`, the last item: `(n/2 - 1) * 2 + 1 = n - 1`. (项数 - 1 乘以公差加首项.)
- Sum: `{[1 + (n-1)] * n/2 } / 2`, equal to `(n * n) / 4`.

If the array looks like `[1, 3, 5, 7, 9]`, then `[1 + 4, 3 + 2, 5, 7 - 2, 9 - 4]`.
- **Minimum number of operations** : `2 + 4 = 6`.
- The equivalent of the sum of the `(n - 1) / 2` positive even numbers. (相当于前 `(n - 1) / 2` 个正偶数的和.)
- The first item: `2`, the last item: `((n - 1) / 2 - 1) * 2 + 2 = n -1`. (项数 - 1 乘以公差加首项.)
- Sum: `{[2 + (n-1)] * (n-1)/2 } / 2`, equal to `[(n + 1) * (n - 1)] / 4`.

In summary: 
- n is even: `(n * n) / 4`.
- n is odd : `(n + 1) * (n - 1) / 4` ,it's also equal to `(n * n - n + n - 1) / 4`, equal to `(n * n - 1) / 4`.

As a result:
- `(n * n - (n & 1)) >> 2`.

> `n & 1` means N and 1, the equivalent of remainder of n with respect to 2.