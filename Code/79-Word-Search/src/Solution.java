import java.util.Arrays;

/**
 * Description:
 * <p>
 * 思路: 向四个方向进行遍历，先进行上下限的判断，然后看是否已经访问过该位置，
 * 如果在界限内且没有访问过，而且当前位置的字符等于字符串要访问位置的字符，
 * 那么进行下一次递归，对word中下一个字符进行操作
 * ------------------------
 * 递归开始条件: 而开始递归的条件就是在二维数组中找到和word第一个字母匹配的，才开始进行递归。
 * <p>
 * Created By xxm
 */
public class Solution {
    // 表示当前移动的方向: 向右、向左、向上、向下
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    // 标记二维数组中已经访问过的位置
    boolean[][] visited;

    /* code is null */
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        // 遍历二维数组寻找 word 的首字母出现的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果 word 的首字母出现在二维数组中
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[m][n];
                    visited[i][j] = true;
                    // 开始搜素
                    if (backtrack(i, j, 1, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(int x, int y, int pos, char[][] board, String word) {
        // 递归结束条件: word访问结束
        if (pos == word.length()) return true;

        // 从四个方向中选择
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            // 不合法情况1: 移动位置后新的坐标超出界限
            if (newX >= board.length || newX < 0 || newY >= board[0].length || newY < 0) {
                continue;
            }
            // 不合法情况2: 跳过访问过的元素
            if (visited[newX][newY]) continue;
            // 这里需要判断当前决策是否合法
            if (board[newX][newY] == word.charAt(pos)) {
                // 做决策
                visited[newX][newY] = true;
                // 进入下一次决策
                if (backtrack(newX, newY, pos + 1, board, word)) {
                    return true;
                }
                // 取消决策
                visited[newX][newY] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
//        System.out.println(new Solution().exist(board, "ABCCED"));
        System.out.println(new Solution().exist(board, "SEE"));
    }
}
