# Queue

"先进先出"的数据结构.

* 按照距离"起点"的距离遍历(隐式图) -- BFS

---

### 简单队列的应用

入队、出队、判断空(满)

题目: #933

---

### 二叉树的层序遍历

* DFS使用递归:

```java
void dfs(TreeNode root) {
    if (root == null) {
        return;
    }
    dfs(root.left);
    dfs(root.right);
}
```

* BFS使用**队列**数据结构

```java
void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
```

题目: #102

---

### 双端队列

队头队尾都可以出入

**堆栈和普通队列都是双端队列的结构**.

题目: #950

---

### 循环/环形队列

队列的一种实现, 为了节省空间, 首尾相接

适用: 队列里元素个数不多

难点: `front`, `rear`, `size`之间的关系以及判断满和空

1. 循环队列

    * 对于front, `tail = (front + size - 1) mod capacity`

    * 对于tail, `front = (tail - size + 1 + capacity) mod capacity`

    题目: #622

2. 循环双端队列

    * 对于front, 指向队列头部第一个有效的数据位置.
    
    * 对于tail, 指向队列尾部 (即最后 1 个有效数据) 的下一个位置, 即下一个从队尾入队元素的位置.
    
    * **为了避免「队列为空」和「队列为满」的判别条件冲突, 我们有意浪费了一个位置**;
    
    判别队列为空的条件是：`front == tail`;
       
    判断队列为满的条件是: `(tail + 1) mode capacity == front`; 
    (当`tail`环到数组的前面, 要从后面追上`front`, 还差一格的时候, 判定队列为满)

    题目: #641

---

### 队列与堆栈互相模拟

两个队列模拟堆栈

题目: # 225

两个堆栈模拟队列

题目: # 232

---

### 单调队列

* 和滑动窗口类似

* 和单调堆栈类似

* 维护队列内元素的单调性, 删除又老又小/大的值.

题目: #239, 1696