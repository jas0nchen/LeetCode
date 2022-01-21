/**
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * @author chendong09
 * @since 2022/01/21
 */
public class Offer53 {

    public int search(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false) - 1;
        if (start <= end && end < nums.length && nums[start] == target && nums[end] == target){
            return end - start + 1;
        }
        return 0;
    }

    private int binarySearch(int[] a, int target, boolean lower) {
        int l = 0, r = a.length - 1, ans = a.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] > target || (lower && a[mid] >= target)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
