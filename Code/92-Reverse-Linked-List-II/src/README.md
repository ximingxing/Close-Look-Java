### 92. Reverse Linked List II

> **Medium**

Given the `head` of a singly linked list and two integers `left` and `right` where `left <= right`, 
reverse the nodes of the list from position `left` to position `right`, 
and return the *reversed list*.

#### Constraints:

* The number of nodes in the list is `n`.
* `1 <= n <= 500`
* `-500 <= Node.val <= 500`
* `1 <= left <= right <= n`

#### Example:
```
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
```

```
Input: head = [5], left = 1, right = 1
Output: [5]
```

#### Solution:

思路:

1. 将需要翻转的链表截取出来单独翻转, 再将翻转后的链表拼接回原链表之中

2. 头插法