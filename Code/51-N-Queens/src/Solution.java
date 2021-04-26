import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * <p>
 * 回溯法解N皇后问题.
 * <p>
 * Created By xxm
 */
public class Solution {
    List<List<String>> res;
    int N = 0;

    /* 判断在棋盘 board 第 row 行、第 col 列放置皇后是否合法 */
    private boolean isValid(char[][] board, int row, int col) {
        // 检查 board[row][col] 正上方
        // 即: 第 col 列的第 [0, row) 行
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // 检查 board[row][col] 右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查 board[row][col] 左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // 因为当前仅尝试了 [0, row] 行, 所以不用判断 board[row][col] 下方

        // board[row][col] 可以放置皇后
        return true;
    }

    /* 将用来存储棋盘的 arr 转化为输出结果 */
    private List<String> charArr2List(char[][] arr) {
        List<String> path = new ArrayList<>();
        for (char[] chars : arr) {
            path.add(new String(chars));
        }
        return path;
    }

    /* 在 NxN 的棋盘 board 中, 前 row 行放置皇后*/
    private void backTrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(charArr2List(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            // 排除不合法的选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 选择皇后放置的位置
            board[row][col] = 'Q';
            // 进入下一次决策
            backTrack(board, row + 1);
            // 取消选择
            board[row][col] = '.';
        }

    }

    public List<List<String>> solveNQueens(int n) {
        N = n;
        res = new ArrayList<>();

        // 声明 char 数组存储棋盘并初始化 '.'
        char[][] board = new char[N][N];
        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }

        backTrack(board, 0);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
}
