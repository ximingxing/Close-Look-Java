import java.util.Stack;

/**
 * Description:
 * <p>
 * 使用堆栈模拟递归调用pow.
 * <p>
 * Created By xxm
 */
public class Solution2 {

    private double pow(double x, long n) {
        Stack<long> stack = new Stack<long>();
        //
        for (stack.push(n); stack.peek() > 1; stack.push(stack.peek() / 2)) ;
        double r = x;
        for (stack.pop(); !stack.isEmpty(); ) {
            r *= r;
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
