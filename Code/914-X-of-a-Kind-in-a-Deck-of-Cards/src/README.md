### 914. X of a Kind in a Deck of Cards

> **Easy**

In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose `X >= 2` such that 
it is possible to split the entire deck into 1 or more groups of cards, where:

* Each group has exactly X cards.
* All the cards in each group have the same integer.

#### Note:

* 1 <= n <= 10^4

#### Example:
```
Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
```

```
Input: deck = [1,1,1,2,2,2,3,3]
Output: false´
Explanation: No possible partition.
```

#### Solution:

统计各个数出现的次数，然后求次数之间是否存在公约数
