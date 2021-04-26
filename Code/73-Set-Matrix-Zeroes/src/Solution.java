/**
 * Description:
 * STOPSHIP: 2021/3/21 每日一题
 * <p>
 * 使用标记数组标记出需要置0的元素, 修改原矩阵即可
 * <p>
 * Created By xxm
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int x = matrix.length, y = matrix[0].length;

        // 声明flags标记位数组, 标记matrix中需要置0的元素
        boolean[][] flags = new boolean[x][y];

        // 这里需要先遍历一次matrix, 为flags赋值
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    // 将flags全部设置为true
                    // 第i行
                    for (int m = 0; m < y; m++)
                        flags[i][m] = true;
                    // 第j列
                    for (int n = 0; n < x; n++)
                        flags[n][j] = true;
                }
            }
        }

        // 根据flags将matrix元素原地置0
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (flags[i][j]) matrix[i][j] = 0;
            }
        }
    }
}
