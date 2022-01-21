/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 *
 * @author chendong09
 * @since 2022/01/21
 */
public class Q26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return 1;
        }
        int size = 1;
        int currentNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentNum != nums[i]) {
                nums[size] = nums[i];
                currentNum = nums[i];
                size++;
            }
        }
        return size;
    }

    private void swap(int[] a, int i, int j) {

    }
}
