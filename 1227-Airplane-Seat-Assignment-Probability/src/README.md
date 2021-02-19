### 1227. Airplane Seat Assignment Probability

> **Medium**

`n` passengers board an airplane with exactly `n` seats. 
The first passenger has lost the ticket and picks a seat randomly. 
But after that, the rest of passengers will:

Take their own seat if it is still available,
Pick other seats randomly when they find their seat occupied
What is the probability that the n-th person can get his own seat?

#### Constraints:

* `1 <= n <= 10^5`

#### Example:
```
Input: n = 1
Output: 1.00000
Explanation: The first person can only get the first seat.
```

```
Input: n = 2
Output: 0.50000
Explanation: The second person has a probability of 0.5 to get the second seat (when first person gets the first seat).
```

#### Solution:

**思路1:** 分类讨论如果第1个人坐在第k个人的座位，第k个人是否坐在第一个人的座位上.

**思路2:** 除1号外其他乘客, 如果自己的座位上有人就把他赶走, 所以2号到n-1号都可以对号入座; 1号乘客仅在1号和n号之间入座.
