/**
 * Description:
 * <p>
 * 快速排序
 * <p>
 * Created By xxm
 */
class Solution3 {

    private int compare(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }

    private void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        int v = arr[lo];
        while (i <= gt) {
            int cmp = compare(arr[i], v);
            if (cmp < 0) exch(arr, lt++, i++);
            else if (cmp > 0) exch(arr, i, gt--);
            else i++;
        }
        // arr[lo .. lt-1] < v = arr[lt .. gt] < arr[gt+1 .. hi]
        quicksort(arr, lo, lt - 1);
        quicksort(arr, gt + 1, hi);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) return;
        for (int i = 0; i < nums1.length; i++) {
            if (i >= m) {
                nums1[i] = nums2[i - m];
            }
        }
        sort(nums1);
    }
}
