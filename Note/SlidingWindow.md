### 滑动窗口

定义: 两个指针同向互相追赶

* 解决线性表(数组、链表)相关问题.
* 使用两个指针(下标)互相追赶, 动态维护窗口内的状态.

《挑战程序设计竞赛》这本书中把滑动窗口叫做「虫取法」, 非常生动形象.
因为滑动窗口的两个指针移动的过程和虫子爬动的过程非常像: 前脚不动, 把后脚移动过来; 后脚不动, 把前脚向前移动.

为什么滑动窗口可以降低复杂度? 单调性(窗口不会倒退, 而是从i不断前进, 将算法从O(n^2/3) -> O(2n)

**搜索实数的滑动窗口模版:**

```java
class Solution {
     public int findSubArray(int[] nums) {
         int N = nums.length; // 数组/字符串长度
         int left = 0, right = 0; // 双指针, 表示当前遍历的区间[left, right], 闭区间
         int res = 0; //  保存最大的满足题目要求的 子数组/子串 长度
         int sums = 0; // 用于统计 子数组/子区间 是否有效，根据题目可能会改成求和/计数
         while (right < N) { // 当右边的指针没有搜索到 数组/字符串 的结尾
             sums += nums[right];  // 增加当前右边指针的数字/字符的求和/计数
             while (区间[left, right]不符合题意) { // 此时需要一直移动左指针，直至找到一个符合题意的区间
                 sums -= nums[left]; // 移动左指针前需要从counter中减少left位置字符的求和/计数
                 i++; // 移动左指针
             }
             // 当while结束时, 我们找到一个符合题意的 子数组/子串
             res = Math.max(res, right - left + 1); // 更新结果
             right ++; // 移动右指针, 去探索新的区间
         }
         return res;
     }
}
```

滑动窗口中用到了左右两个指针, 它们移动的思路是: **以右指针作为驱动, 拖着左指针向前走.
右指针每次只移动一步, 而左指针在内部 while 循环中每次可能移动多步.
右指针是主动前移, 探索未知的新区域; 左指针是被迫移动, 负责寻找满足题意的区间**.

题目: #1004, 1234, 80

**搜索子串的滑动窗口模版:**

```java
class Solution{
    void slidingWindow(String s, String t){
        // 用于存储需要匹配的子串 t 每个字符出现的个数
        HashMap<Character, Integer> need = new HashMap<>();
        char [] arr = t.toCharArray();
        for (char c : arr){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // 用于存储位于滑动窗口中 t 中字符出现的个数 
        HashMap<Character, Integer> window = new HashMap<>();
        
        int left = 0, right = 0;
        // 用于标记 t 中字符是否全部进入窗口
        int valid = 0;
        while (right < s.length()){
            // 将字符 c 加入窗口之中
            char c = arr[right];
            // 右移窗口
            right++;
            // TODO: 进行窗口内数据的一系列更新
            ...
            
            // TODO: debug的位置
            System.out.println("left: " + left + "right: " + right);
            
            while (window needs shrink){
                // 字符 d 是移除窗口的元素
                char d = arr[left];
                // 左移窗口
                left++;
                // TODO: 进行窗口内数据的一些列更新
                ...
            }

        }
    }   
}
```

题目: #76, 567, 438, 3

---