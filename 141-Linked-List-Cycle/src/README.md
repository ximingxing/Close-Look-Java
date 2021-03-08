### 141. Linked List Cycle

> **Easy**

Code 

#### Constraints:

* The number of nodes in the list is in the range `sz`.
* `1 <= sz <= 5000`
* `0 <= Node.val <= 1000`
* `1 <= k <= sz`

#### Example:
```
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
```

```
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
```

```
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
```

```
Input: head = [1], k = 1
Output: [1]
```

#### Solution:

判断一个节点是否在之前出现过?

1. HashSet记录之前出现过的全部节点

2. 快、慢指针
    * 如果链表有环，快慢指针会在环里"打转"
    * 如果链表有环，快慢指针同向移动，总会相遇

