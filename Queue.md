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

题目: #641

---