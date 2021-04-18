# 排序算法

快速排序和归并排序是互补的:

**归并排序将数组分成两个子数组分别排序, 并将有序的子数组归并以将整个数组排序**;

**而快速排序将数组排序的方式则是当两个子数组都有序时整个数组也就自然有序了**.

在第一种情况中, 递归调用发生在处理整个数组之前;

在第二种情况中, 递归调用发生在处理整个数组之后.

**在归并排序中, 一个数组被等分为两半; 在快速排序中, 切分(partition)的位置取决于数组的内容**.

### 归并排序(Merge Sort)

归并, 即将两个有序的数组归并成一个更大的有序数组.

要将一个数组排序, 可以先(递归地)将它分成两半分别排序, 然后将结果归并起来.

你将会看到, 归并排序最吸引人的性质是它能够保证将任意长度为 N 的数组排序所需时间和 NlogN 成正比;
它的主要缺点则是它所需的额外空间和 N 成正比.

#### 原地归并的抽象方法

```java
public class Merge {
    public static void merge(Comparable[] a, int lo, int mid, int hi) { 
        // 将a[lo..mid] 和 a[mid+1..hi] 归并
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++) // 将a[lo..hi]复制到aux[lo..hi] 
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++) // 归并回到a[lo..hi] 
            if (i > mid) a[k] = aux[j++]; 
            else if (j > hi ) a[k] = aux[i++]; 
            else if (less(aux[j], aux[i])) a[k] = aux[j++]; 
            else a[k] = aux[i++];
    }
}
```

#### 自顶向下的归并排序

应用高效算法设计中**分治思想**的最典型的一个例子:

```java
public class Merge{
    private static Comparable[] aux; // 归并所需的辅助数组

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length]; // 一次性分配空间 
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) { // 将数组a[lo..hi]排序
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // 将左半边排序
        sort(a, mid+1, hi); // 将右半边排序
        merge(a, lo, mid, hi); // 归并结果(代码见“原地归并的抽象方法”)
    } 
}
```

### 快速排序(Quick Sort)

快速排序引人注目的特点包 括它是原地排序(只需要一个很小的辅助栈), 
且将长度为`N`的数组排序所需的时间和`NlgN`成正比.

快速排序是一种分治的排序算法. 

它将一个数组分成两个子数组, 将两部分独立地排序.

```
{ E C A I E } K { L P U T M Q R X O S }
              | 
             split 
```

`split`切分元素左边不大于它, 右边不小于它.

#### 快速排序框架

```java
public class Quick{
    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        // 递归出口
        if (hi <= lo) return;
        // 快速排序切分
        int j = partition(a ,lo, hi);
        // 将左半边部分a[lo, j-1]排序
        sort(a, lo, j-1);
        // 将右半边部分a[j+1, hi]排序
        sort(a, j+1, hi);
    }
}
```

该方法的关键在于切分, 这个过程使得数组满足下面三个条件:

1. 对于某个`j`, `a[j]`已经排定;

2. `a[lo]`到`a[j-1]`中的所有元素都不大于`a[j]`;

3. `a[j+1]`到`a[hi]`中的所有元素都不小于`a[j]`.

我们就是通过递归地调用切分来排序的.

**用归纳法不难证明递归能够正确地将数组排序:
如果左子数组和右子数组都是有序的，那么由左子数组(有序且没有任何元素大于切分元素)、
切分元素和右子数组(有序且没有任何元素小于切分元素)组成的结果数组也一定是有序的**.

#### 快速排序切分的实现

要完成这个实现，需要实现切分方法。

一般策略是先 随意地取`a[lo]`作为切分元素，即那个将会被排定的元素，
然后我们从数组的左端开始向右扫描直到找到一个大于等于它的元素，
再从数组的右端开始向左扫描直到找到一个小于等于它的元素。
这两个元素显然是没有排定的，因此我们交换它们的位置。
如此继续，我们就可以保证左指针 `i` 的左侧元素都不大于切分元素，右指针 `j` 的右侧元素都不小于切分元素。
当两个指针相遇时，我们只需要将切分元素 `a[lo]` 和左子数组最右侧的元素(`a[j]`)交换然后返 回 `j` 即可。

```java
public class Quick{
    private static int partition(Comparable[] a, int lo, int hi){
        // 左右扫描的指针
        int i = lo, j = hi;
        // 切分元素
        Comparable v = a[i];
        
        while (true){
            // 扫描左右, 检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a ,i ,j);           
        }
        // 将 v = a[j] 放入正确位置
        exch(a ,lo, j);
        // a[lo, j-1] <= a[j] <= a[j+1, hi] 达成
        return j;
    }
}
```

#### 快速排序的改进 

##### 改进一: **切换到插入排序**

1. 对于小数组而言, 快速排序比插入排序慢;

2. 因为递归, 快速排序的`sort()`方法在小数组中也会调用自己.

**因此, 在排序小数组时应该切换到插入排序**.

将排序中的:
```
if (hi <= lo) return;
```

变为:
```
if (hi <= lo + M) { Insertion.sort(a, lo, hi); return; }
```

转换参数`M`的最佳值是和系统相关的, 但是`5 ~ 15`之间的任意值在大多数情况下都能令人满.

##### 改进二: **三取样切分**

改进快速排序性能的第二个办法是使用子数组的一小部分元素的中位数来切分数组.

这样做得到的切分更好, 但代价是需要计算中位数.

人们发现将取样大小设为`3`并用大小居中的元素切分的效果最好.

```java
public class Quick3way{
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        // 处理 [i, gt] 中未确定的元素
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            // a[i] < v
            if      (cmp < 0) exch(a, lt++, i++);
            // a[i] > v
            else if (cmp > 0) exch(a, i, gt--);
            // a[i] == v
            else     i++;
        } 
    // 现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立 
    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
    } 
}
```

它从左到右遍历数组一次,
维护一个指针`lt`使得`a[lo..lt-1]`中的元素都小于`v`,
一个指针`gt`使得`a[gt+1..hi]`中的元素都大于`v`,
一个指针`i`使得`a[lt..i-1]`中的元素都等于`v`,
`a[i..gt]`中的元素都还未确定.

### 桶排序算法

题目: #220