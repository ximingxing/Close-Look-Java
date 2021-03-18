### 876. Middle of the Linked List

> **Easy**

Given a non-empty, singly linked list with head node `head`,
return a middle node of linked list.

If there are two middle nodes, return the second middle node.

#### Note:

* The number of nodes in the given list will be between `1` and `100`.

#### Example:
```
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a Node object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
```

```
Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
```

#### Solution:

思路：

1. 计算链表长度
    
    链表长度为n, 返回第`[n / 2]`步 (向下取整)

2. 快慢指针

    快指针每次移动两步, 慢指针每次移动一步.