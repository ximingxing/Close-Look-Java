/**
 * Description:
 * <p>
 * 二分查找
 * <p>
 * Created By xxm
 */
public class Solution3 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 因为矩阵每一行升序, 并且第二行的元素均大于第一行,
        // 我们利用这个性质, 以左下角为原点建立坐标轴,
        // 先从列开始查找,
        // 再从行里查找, 最后得到元素.
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        boolean flag = searchMatrix(mat, 3);
        System.out.println(flag);
    }
}
