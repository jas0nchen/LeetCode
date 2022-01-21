/**
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * [1,3,5,6]
 * 2
 *
 * @author chendong09
 * @since 2022/01/21
 */
public class Q35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int i = binarySearch(nums, target);
        if (nums[i] == target) {
            return i;
        }
        if (nums[i] < target) {
            return i+1;
        }
        return 0;
    }

    private int binarySearch(int[] a, int target) {
        int l = 0, r = a.length - 1, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
