import java.util.ArrayList;
import java.util.List;

/**
 * Description: 模拟
 * Created By xxm
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < (Math.min(m, n) + 1) / 2; i++) {
            // 从左往右
            for (int j = i; j < n - i; j++) {
                res.add(matrix[i][j]);
            }
            // 从上往下
            for (int j = i + 1; j < m - i; j++) {
                res.add(matrix[j][n - 1 - i]);
            }
            // 从右向左
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i) != i; j--) {
                res.add(matrix[m - 1 - i][j]);
            }
            // 从下往上
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--) {
                res.add(matrix[j][i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };
        System.out.println(new Solution().spiralOrder(mat));
    }
}
