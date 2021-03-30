/**
 * Description:
 * Created By xxm
 */
public class Solution2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 我们可以逐行判断, target是否在[0, matrix[i].length - 1]这个范围内
        // 如果在该范围内, 则搜索该行
        // 如果不在, 则向下一行重复进行该过程
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == target) return true;
                }
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
