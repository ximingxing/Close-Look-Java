### 992. Subarrays with K Different Integers

> **Hard**

Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.

#### Note:

1. `1 <= A.length <= 20000`
2. `1 <= A[i] <= A.length`
3. `1 <= K <= A.length`

#### Example:
```
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
```

```
Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
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