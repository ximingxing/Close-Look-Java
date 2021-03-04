### 25. Reverse Nodes in k-Group

> **Hard**

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

**Follow up:**

* Could you solve the problem in O(1) extra memory space?
* You may not alter the values in the list's nodes, only nodes itself may be changed.

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

思路分析：先把链表节点每k个一组, 截取出子链表, 每个子链表单独进行翻转.
注意最后不足k个的情况, 还要注意每个子链表要连接起来.
