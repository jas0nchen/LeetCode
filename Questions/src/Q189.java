/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
 *
 * @author chendong09
 * @since 2022/04/01
 */
public class Q189 {

    /**
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    /**
     * 求最大公约数
     *
     * gcd(3, 7)
     * gcd(7, 3)
     * gcd(3, 1)
     * gcd(1, 1)
     * gcd(1, 0)
     * 1
     *
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
