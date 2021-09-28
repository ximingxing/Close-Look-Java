# Dynamic programming

**动态规划问题的一般形式就是求最值**.

比如: 求**最长**递增子串, **最小**编辑距离.

既然是要求最值, 核心问题是什么呢? 求解动态规划的核心问题是**穷举**.

而且, 动态规划问题一定会具备「最优子结构」, 才能通过子问题的最值得到原问题的最值.

动态规划三要素: **重叠的子问题**, **状态转移方程(最关键)**, **最优子结构**.

明确**状态转移方程**是难点:

    明确「状态」 -> 明确「选择」-> 定义dp数组/函数的含义 -> 明确「base case」

---

### Example: 凑零钱问题

题目: #322

```
给你 `k` 种面值的硬币, 面值分别为 `c1, c2 ... ck `, 
每种硬币的数量无限, 再给一个总金额 `amount`,
问你最少需要几枚硬币凑出这个金额, 如果不可能凑出, 算法返回-1.
```

算法签名:

```
int coinChange(int[]coins,int amount)
```

思路:

1. **最优子结构 (子问题之间必须相互独立)**

你想求 `amount = 11` 时的最少硬币数(原问题), 如果你知道凑出 `amount = 10` 的最少硬币数(子问题), 你只需要把子问题的答案加一 (再选一枚面值为 1 的硬币) 就是原问题的答案,
因为硬币的数量是没有限制的, 子问题之间没有相互制, 是互相独立的.

2. 列出**状态转移方程**

    1. **先确定「状态」: 也就是原问题和子问题中变化的变量**.

       由于硬币数量无限, 所以唯一的状态就是目标金额 `amount`.

    2. **再确定 dp 函数的定义**.

       当前的目标金额是`n`, 至少需要 `dp(n)` 个硬币凑出该金额.

    3. **后确定「选择」并择优 : 对于每个状态, 可以做出什么选择改变当前状态**.

       具体到这个问题, 无论当的目标金额是多少, 选择就是从面额列表`coins`中选择一个硬币,然后目标金额就会减少.

3. 最后**明确 base case**

显然目标金额为0时, 所需硬币数量为0; 当目标金额小于0时, 无解, 返回 -1;

---

### 技巧: 状态压缩

能够将动态规划算法的空间复杂度进一步降低: `O(N^2) -> O(N)`.

能够使用状态压缩技巧的动态规划都是二维`dp`问题.

**如果计算状态`dp[i][j]`需要的都是`dp[i][j]`相邻的状态，那么就可以使用状态压缩技巧**.

---

### 最长公共子序列 -- Longest Common Subsequence(LCS)

```
给你输入两个字符串 s1 和 s2, 请你找出他们俩的最长公共子序列, 返回这个子序列的长度.
```

**状态定义**: `dp[i][j]` 表示 `text1[0:i-1]` 和 `text2[0:j-1]` 的最长公共子序列.

**状态转移方程**:

```
dp[i][j] = dp[i - 1][j - 1] + 1, 当 text1[i - 1] == text2[j - 1].
dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]), 当 text1[i - 1] != text2[j - 1].
```

**状态的初始化**: `dp[i][j]` 初始化为 0.

**遍历方向与范围**: 由于 `dp[i][j]` 依赖与 `dp[i - 1][j - 1]` , `dp[i - 1][j]`, `dp[i][j - 1]`, 所以 i 和 j 的遍历顺序肯定是从小到大的.

题目: #1143

---

### 编辑距离

题目: #72

---

### 最长递增子序列

最长递增子序列(Longes Increasing Subsequence, 简写为 LIS)

For example:

```
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
```

`dp[i]`表示以`nums[i]`这个数结尾的最长递增子序列的长度.

题目: #300, 583

1. **信封嵌套**

LTS在二维数组上的的应用

题目: #354

2. **最大子数组**

题目: #53

---

### 0-1背包问题

题目: #416

---

### 股票买卖系列问题

[题解](https://leetcode-cn.com/circle/article/qiAgHn/)

* `#121`  [Best Time to Buy and Sell Stock](https://github.com/ximingxing/LeetCode-notepad/tree/master/Code/121-Best-Time-to-Buy-and-Sell-Stock/src) <img src="https://img.shields.io/badge/-easy-green">
* `#122`  [Best Time to Buy and Sell Stock II](https://github.com/ximingxing/LeetCode-notepad/tree/master/Code/122-Best-Time-to-Buy-and-Sell-Stock-II/src) <img src="https://img.shields.io/badge/-medium-yellow">
* `#123`  [Best Time to Buy and Sell Stock III](https://github.com/ximingxing/LeetCode-notepad/tree/master/Code/123-Best-Time-to-Buy-and-Sell-Stock-III/src) <img src="https://img.shields.io/badge/-hard-red">
* `#188`  [Best Time to Buy and Sell Stock IV](https://github.com/ximingxing/LeetCode-notepad/tree/master/Code/188-Best-Time-to-Buy-and-Sell-Stock-IV/src) <img src="https://img.shields.io/badge/-hard-red">
* `#309`  [Best Time to Buy and Sell Stock with Cooldown](https://github.com/ximingxing/LeetCode-notepad/tree/master/Code/309-Best-Time-to-Buy-and-Sell-Stock-with-Cooldown/src) <img src="https://img.shields.io/badge/-medium-yellow">
* `#714`  [Best Time to Buy and Sell Stock with Transaction Fee](https://github.com/ximingxing/LeetCode-notepad/tree/master/Code/714-Best-Time-to-Buy-and-Sell-Stock-with-Transaction-Fee/src) <img src="https://img.shields.io/badge/-medium-yellow">
