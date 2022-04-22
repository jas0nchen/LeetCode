import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 *
 * @author chendong09
 * @version 1.0.0
 * @since 2022/04/22
 */
public class Q7 {

    /**
     * 输入：x = 123
     * 输出：321
     *
     * 输入：x = -123
     * 输出：-321
     *
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
