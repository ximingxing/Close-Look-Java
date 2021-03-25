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
