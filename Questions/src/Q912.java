/**
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * @author chendong09
 * @since 2022/01/20
 */
public class Q912 {

    private int[] tmp;

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }

    /**
     * 基础解法
     */
//    public int[] sortArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return nums;
//        }
//        quickSort(nums, 0, nums.length - 1);
//        return nums;
//    }

//    private void quickSort(int[] a, int l, int r) {
//        if (l < r) {
//            int i, j, x;
//            i = l;
//            j = r;
//            x = a[i];
//            while (i < j) {
//                while (i < j && a[j] > x) {
//                    j--;
//                }
//                if (i < j) {
//                    a[i++] = a[j];
//                }
//                while (i < j && a[i] < x) {
//                    i++;
//                }
//                if (i < j) {
//                    a[j--] = a[i];
//                }
//            }
//            a[i] = x;
//            quickSort(a, l, i - 1);
//            quickSort(a, i + 1, r);
//        }
//    }
}
