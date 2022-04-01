/**
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * @author chendong09
 * @since 2022/04/01
 */
public class Q977 {

    /**
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        // 寻找最后一个负数
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        // index表示最新的排序数组的索引下标，从0开始
        int index = 0, i = negative, j = negative + 1;
        // 从最后一个负数开始做双指针，左指针向左移动，右指针向右移动
        while (i >= 0 || j < n) {
            if (i < 0) {
                // 没有负数了，直接按顺序添加正数的平方
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                // 没有正数了，直接按顺序添加负数的平方
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                // 比较负数和正数平方大小，按序添加
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }
}
