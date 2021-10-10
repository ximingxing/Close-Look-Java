/**
 * Description: TopK问题
 * Solution: 堆排序
 * Created By xingximing.xxm
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;

        // 1. 构建大根堆
        buildMaxHeap(nums, heapSize);

        // 2. 删除 k-1 个堆顶元素, 并重新调整堆使之满足大根堆定义
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i); // 将堆顶元素与末尾元素进行交换，使末尾元素最大
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }

        // 此时数组中第一个元素为第 k 大的元素
        return nums[0];
    }

    /* 建立大根堆 */
    private void buildMaxHeap(int[] nums, int heapSize) {
        // 从第一个叶子节点开始调整
        for (int i = heapSize / 2 + 1; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    /* 调整元素重新满足大根堆的定义 */
    private void maxHeapify(int[] nums, int i, int heapSize) {
        int leftChild = i * 2 + 1; // 节点 i 的左孩子
        int rightChild = i * 2 + 2; // 节点 i 的右孩子
        int largest = i;

        // 如果节点 i 的左孩子大于其本身
        if (leftChild < heapSize && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }
        // 如果节点 i 的右孩子大于其本身
        if (rightChild < heapSize && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        // 根据大根堆的定义，调整左孩子与节点 i 的位置
        // 并让调整后的堆重新满足大根堆的定义
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
