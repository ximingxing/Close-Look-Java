### 142. Linked List Cycle II

> **Medium**

Given a linked list, return the node where the cycle begins. 
If there is no cycle, return `null`.

There is a cycle in a linked list if there is some node in the list that 
can be reached again by continuously following the `next` pointer. 
Internally, `pos` is used to denote the index of the node that 
tail's `next` pointer is connected to.
**Note that `pos` is not passed as a parameter**.

**Notice** that you **should not modify** the linked list.

#### Constraints:

* The number of the nodes in the list is in the range `[0, 104]`.
* `-10^5 <= Node.val <= 10^5`
* `pos` is `-1` or a valid index in the linked-list.

**Follow up**: Can you solve it using `O(1)` (i.e. constant) memory?

#### Example:
```
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```

```
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

```
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
```

#### Solution:

1. HashSet记录之前出现过的全部节点, 返回首次重复出现的节点

2. 快慢指针

    快针走的是慢针的两倍.
    慢针走过的路，快针走过一遍.
    快针走过的剩余路程, 也就是和慢针走过的全部路程相等. (a+b = c+b)
    减去快针追赶慢针的半圈(b)，剩余路程即为所求入环距离(a=c)
   
    ```
    if `len(list)` == a + b + c
    and a = 入环前的路程, 
        b = 慢指针入环后到相遇点的路程, 
        c = 快指针从相遇点到入环点的路程.
    ---
    slow * 2 = fast;
    slow = a + b;
    fast = a + b + c + b = a + 2*b + c;
    (a + b)*2 = a + 2*b + c;
    a = c;
    ```

