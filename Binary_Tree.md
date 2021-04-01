# 二叉树 - Binary Tree

**递归算法的关键要明确函数的定义, 相信这个定义, 而不要跳进递归细节**.

写二叉树的算法题, 都是基于递归框架的, 
我们先要搞清楚 root 节点它自己要做什么,
然后根据题目要求选择使用前序、中序、后续的递归框架.

```java
/* 二叉树遍历框架 */
void traverse(Node root) {
    // 前序遍历
    traverse(root.left)
    // 中序遍历
    traverse(root.right)
    // 后序遍历
}
```

二叉树题目的难点在于如何通过题目的要求思考出每一个节点需要做什么, 这个只能通过多刷题进行练习了.

**快速排序就是个二叉树的前序遍历, 归并排序就是个二叉树的后序遍历**.

---

### 翻转二叉树

```
     4               4
   /   \            /  \
  2     7      ->  7    2
 / \   / \        / \  / \
1   3 6   9      6   9 1  3
```

我们发现只要把二叉树上的每一个节点的左右子节点进行交换, 最后的结果就是完全翻转之后的二叉树.

题目: #226

---

### 填充二叉树节点的右侧指针

**二叉树题目的一个难点就是, 如何把题目的要求细化成每个节点需要做的事情**.

如果解决该问题时仅使用一个节点, 将每个节点的左右子节点都穿起来, 其实并不能解决问题: 
考虑两个节点可能没有共同的父节点.

思路: 我们使用两个节点, 分别为root的左子树和右子树
1. 先将这两个节点相连接;
2. 连接父节点相同的两个子节点(分别对root.left和root.right进行这一步)
3. 连接跨越父节点的两个子节点

题目: #116

---

### 将二叉树展开为链表

1. 将 root 的左子树和右子树拉平.
2. 将 root 的右子树接到左子树下方, 然后将整个左子树作为右子树.

```
     1               1             1         
   /   \            /  \            \
  2     5     ->   2    5    ->      2    
 / \     \          \    \            \
3   4     6          3    6            3
                      \                 \
                       4                 4
                                          \
                                           5
                                            \
                                             6
```

题目: #114

---

### 构造最大二叉树

**对于构造二叉树的问题, 根节点要做的就是把想办法把自己构造出来**.

思路: 对于每个根节点, 只需要找到当前nums中的最大值和对应的索引, 然后递归调用左右数组构造左右子树即可.

题目: #654

---

### 通过前序和中序遍历结果构造二叉树

```
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
```

对于前序遍历结果, 第一个元素`3`为二叉树的根节点.

**如何确定前序遍历左右子树是关键**.

对于中序遍历结果, 已知根节点, 便可以用根节点在中序遍历中的索引`ind`,
将中序遍历结果分为左右子树.

```     
            ind
             |
inorder = [9,3,15,20,7]
           |         |
        inStart    inEnd
```

左子树区间为`[inStart, ind]`, 右子树区间为`[ind+1, inEnd]`.

根据中序遍历中根节点索引`ind`以及起始点所以`inStart`.

得到前序遍历左子树区间`[preStart+1, preStart + leftSize]`
得到前序遍历右子树区间`[preStart + leftSize + 1, preEnd]`

```        
         preStart(root)
            |
preorder = [3,9,20,15,7]
                |
       preStart + leftSize +1
```

题目: #105

---

### 寻找重复子树

对于这样一棵二叉树

```
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
```

它有两颗重复的子树:

```
      2
     /     
    4
```

和

```
   4
```

对于某一个节点来说, 它需要做两件事:

1. 首先要知道以自己为根节点的树长什么样
2. 以其他节点为根的树长什么样

解决思路:

1. 通过二叉树的后序遍历很容易知道以自己为根节点的树长什么样

```java
String traverse(TreeNode root) {
    // 对于空节点，可以用一个特殊字符表示
    if (root == null) {
        return "#";
    }
    // 将左右子树序列化成字符串
    String left = traverse(root.left);
    String right = traverse(root.right);
    /* 后序遍历代码位置 */
    // 左右子树加上自己，就是以自己为根的二叉树序列化结果
    String subTree = left + "," + right + "," + root.val;
    return subTree;
}
```

2. 借助一个数据结构(HashMap)存储所有节点的子树, 判断有无重复即可

题目: #652

---

# 二分搜索树 - Binary Search Tree

1. 对于 BST 的每一个节点node, 左子树节点的值都比node的值要小, 右子树节点的值都比node的值大.

2. 对于 BST 的每一个节点node, 它的左侧子树和右侧子树都是BST.

**BST的中序遍历结果是有序的(升序, 元素由小到大排列)**.

```java
void traverse(TreeNode root) {
    if (root == null) return;
    traverse(root.left);
    // 中序遍历代码位置
    print(root.val);
    traverse(root.right);
}
```

BST题目总结:

1. 如果当前节点会对下面的子节点有整体影响, 可以通过辅助函数增长参数列表, 借助参数传递信息.

2. 在二叉树递归框架之上

```java
void BST(TreeNode root, int target) {
    if (root.val == target)
        // 找到目标，做点什么
    if (root.val < target) 
        BST(root.right, target);
    if (root.val > target)
        BST(root.left, target);
}
```

---

### 寻找第K小第元素

解法一: 由于我们已知BST中序遍历结果是升序的, 所有通过中序遍历可以找到第k小第元素.

解法二: 用栈模拟递归解法

题目: #230

---

### BST转化累加树

要求使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和.

我们知道BST中序遍历是升序的, 但是我们现在要累加大于或者等于当前节点的值.

这道题目核心: 跳出BST中序遍历顺序(`raw: left, root, right`)

改变思路为: 先遍历right, 再遍历自己, 最后遍历left.

题目: #538

---

### 判断BST合法性

判断BST是否合法, 每个节点自己要做的事不仅仅是比较自己和左右孩子.

```java
boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    if (root.left != null && root.val <= root.left.val)
        return false;
    if (root.right != null && root.val >= root.right.val)
        return false;

    return isValidBST(root.left)
        && isValidBST(root.right);
}

```

上述代码出现了错误, 考虑下面这种情况, 6比10小, 却出现在右子树中.

```
        10
       / \
      5   15
         / \
        6   20
``` 

因为**对于每一个节点root,
代码值检查了它的左右孩子节点是否符合左小右大的原则; 
但是根据 BST 的定义, 
root的整个左子树都要小于root.val, 整个右子树都要大于root.val**.

```java
boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
}

/* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    // base case
    if (root == null) return true;
    // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
    if (min != null && root.val <= min.val) return false;
    if (max != null && root.val >= max.val) return false;
    // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
    return isValidBST(root.left, min, root) 
        && isValidBST(root.right, root, max);
}
```

### 在BST中搜索一个数

利用BST「左大又小」, 进行二分查找

```java
void BST(TreeNode root, int target) {
    if (root.val == target)
        // 找到目标，做点什么
    if (root.val < target) 
        BST(root.right, target);
    if (root.val > target)
        BST(root.left, target);
}
```

题目: #700

### 在BST中插入一个数

我们总结了 BST 中的遍历框架, 就是「找」的问题.
直接套框架, 加上「改」的操作即可. 
**一旦涉及「改」, 函数就要返回TreeNode类型, 并且对递归调用的返回值进行接收**.

```java
TreeNode insertIntoBST(TreeNode root, int val) {
    // 找到空位置插入新节点
    if (root == null) return new TreeNode(val);
    // if (root.val == val)
    //     BST 中一般不会插入已存在元素
    if (root.val < val) 
        root.right = insertIntoBST(root.right, val);
    if (root.val > val) 
        root.left = insertIntoBST(root.left, val);
    return root;
}
```

题目: #701

### 在BST中删除一个数

跟插入操作类似, 先「找」再「改」, 算法框架如下:

```java
TreeNode deleteNode(TreeNode root, int key) {
    if (root.val == key) {
        // 找到啦，进行删除
    } else if (root.val > key) {
        // 去左子树找
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        // 去右子树找
        root.right = deleteNode(root.right, key);
    }
    return root;
}
```

比方说是节点A, 如何删除这个节点, 这是难点. 因为删除节点的同时不能破坏 BST 的性质.

**情况1**: A恰好是末端节点, 两个子节点都为空, 删掉即可.
  
**情况2**: A只有一个非空子节点, 那么它要让这个孩子接替自己的位置.

**情况3**: A有两个子节点, 为了不破坏 BST 的性质;
A必须找到左子树中最大的那个节点, 或者右子树中最小的那个节点来接替自己.

```java
TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (root.val == key) {
        // 这两个 if 把情况 1 和 2 都正确处理了
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        // 处理情况 3
        TreeNode minNode = getMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, minNode.val);
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
}

TreeNode getMin(TreeNode node) {
    // BST 最左边的就是最小的
    while (node.left != null) node = node.left;
    return node;
} 

```

题目: #450

---

### 二叉树的序列化

二叉树结该是一个二维平面内的结构，而序列化出来的字符串是一个线性的一维结构.

**所谓的序列化不过就是把结构化的数据「打平」,其实就是在考察二叉树的遍历方式**.

> 一般语境下, 单单前序遍历结果是不能还原二叉树结构的, 因为缺少空指针的信息,
> 至少要得到前、中、后序遍历中的两种才能还原二叉树.

**解法一**: 前序遍历

**解法二**: 后序遍历

**至于单独依靠中序遍历无法完成反序列化, 因为无法判断root节点所在的位置**.

**解法三**: 层序遍历

层序遍历二叉树框架:

```java
void traverse(TreeNode root) {
    if (root == null) return;
    // 初始化队列，将 root 加入队列
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        TreeNode cur = q.poll();

        /* 层级遍历代码位置 */
        System.out.println(root.val);
        /*****************/

        if (cur.left != null) {
            q.offer(cur.left);
        }

        if (cur.right != null) {
            q.offer(cur.right);
        }
    }
}
```

基于层序遍历序列化二叉树和层序遍历二叉树相似.

同样, 由于存在空指针的信息, 也可以用层序遍历反序列化二叉树, 同样使用一个队列依次保存父节点.

题目: #297

---

### 多叉树遍历

多叉树的基本结构:

```
/* 基本的 N 叉树节点 */
class TreeNode {
    int val;
    TreeNode[] children;
}
```

题目中可能类似的数据结构:

```
class NestedInteger {
    Integer val;
    List<NestedInteger> list;
}
```

**多叉树遍历框架**:

```java
void traverse(TreeNode root) {
    for (TreeNode child : root.children)
        traverse(child);
```

题目: #341

---