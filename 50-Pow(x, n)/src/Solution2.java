import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * <p>
 * 使用堆栈模拟递归调用pow.
 * <p>
 * Created By xxm
 */
public class Solution2 {

    private double pow(double x, long n) {
        // 用堆栈模拟递归调用
        Deque<Long> stack = new LinkedList<>();
        // 将 n 次幂除以 2 后依次入栈
        for (stack.push(n); stack.peek() > 1; stack.push(stack.peek() / 2)) ;
        // r 用来存储返回结果
        double r = x;
        // 让堆栈中的幂次依次出栈
        for (stack.pop(); !stack.isEmpty(); ) {
            // 出栈一个元素 r 自乘一次
            r *= r;
            // 如果要求得是奇数次幂, 即 x^n, n为奇数
            // 需要再次自乘
            if (stack.pop() % 2 == 1) {
                r *= r;
            }
        }
        return r;
    }

    public double myPow(double x, int n) {
        long m = n; // n为负数时取相反数可能溢出
        return m < 0 ? (1. / pow(x, -m)) : pow(x, m); // n可能为负数
    }
}
