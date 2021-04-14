# Backtracking

回溯算法是一种暴力穷举算法.

**解决一个回溯问题, 实际上就是一个决策树的遍历过程**, 即穷举的过程就是遍历多叉树的过程.

**回溯算法就是个多叉树的遍历问题**, 关键就是在**前序遍历**和**后序遍历**的位置做一些操作.

基本框架: 

```python
def backtrack(...):
    for 选择 in 选择列表:
        做选择
        backtrack(...)
        撤销选择
```

**写backtrack函数时, 需要维护走过的「路径」和当前可以做的「选择列表」,
当触发「结束条件」时, 将「路径」记入结果集**.

需要考虑三个问题:

1. **路径**: 已经做出的选择.
2. **选择列表**: 当前可以做的选择.
3. **结束条件**: 到达决策树底层，无法再做选择的条件.

回溯算法的框架: 

```python
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```

---

### Example: 全排列问题

> `[1, 2, 3]` 的全排列

`n` 个不重复的数，全排列共有 `n!` 个.

第一步选择 2 :
`[2]` 就是「路径」，记录你已经做过的选择；
`[1,3]` 就是「选择列表」，表示你当前可以做出的选择；
「结束条件」就是遍历到树的底层，在这里就是选择列表为空的时候.

我们只要在递归之前做出选择，在递归之后撤销刚才的选择

```java
public class Solution{
    // 存储全排列 
    List<List<Integer>> res = new LinkedList<>();
    
    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }
    
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
    
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
}
```

题目: 65

---

### Example: N皇后问题

题目: #51

### 二维数组回溯找路径

题目: #79