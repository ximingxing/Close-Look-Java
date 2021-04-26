### 206. Reverse Linked List

> **Easy**

Given the `head` of a singly linked list, reverse the list, and return the reversed list.

#### Constraints:

* The number of nodes in the list is the range `[0, 5000]`.
* `-5000 <= Node.val <= 5000`

#### Example:
```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

```
Input: head = [1,2]
Output: [2,1]
```

```
Input: head = []
Output: []
```

#### Solution:

方法1: 递归思想 (时间上是线性的, 空间上隐式的调用了系统堆栈)
* 翻转除第一个节点外后面的部分, 返回表头和表尾

方法2: 利用堆栈 (时间上是线性的, 空间上是非线性的)
* 弹出节点的顺序是反向的, 顺次连结

方法3: 顺次翻转 (时间上是线性的, 空间上是常数的)
* 把未翻转部分的每个节点作为新的已翻转部分的链表头