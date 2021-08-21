# Breadth First Search 算法框架套路详解

BFS可以解决的问题的本质就是让你在一幅**图**中, **找到从起点`start`到终点`target`的最近距离**.

**注意**: BFS是一种算法框架，属于枚举的一种，这里的"图"可以是显式图，也可以是隐式图.

**`BFS`相对`DFS`的最主要的区别是**：`BFS`找到的路径一定是最短的, 但代价就是空间复杂度比`DFS`大很多.

BFS框架:

```java
public class BFS {
    // 计算从起点 start 到终点 target 的最近距离
    int BFS(Node start, Node target) {
        Queue<Node> q; // 核心数据结构
        Set<Node> visited; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        while (!q.isEmpty()) { // 这里可能需要变化
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur.equal(target))
                    return step;
                /* 将 cur 的相邻节点加入队列 */
                for (Node x : cur.adj())
                    if (x not in visited){
                    q.offer(x);
                    visited.add(x);
                }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
    }
}
```

队列`q`是`BFS`的核心数据结构;

`cur.adj()`泛指`cur`相邻的节点, 比如说二维数组中，`cur`上下左右四面的位置就是相邻节点;

`visited`的主要作用是防止走回头路, 大部分时候都是必须的, 但是像一般的二叉树结构，没有子节点到父节点的指针, 不会走回头路就不需要`visited`.

---

## 经典场景: 层序遍历

LeetCode 102. Binary Tree Level Order Traversal 二叉树的层序遍历（Medium）

```
void dfs(Node root) {
    if (root == null) {
        return;
    }
    dfs(root.left);
    dfs(root.right);
}
```

## 经典场景: 最短路径