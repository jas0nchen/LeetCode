import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * [3,2,3,1,2,4,5,5,6]
 * 4
 * <p>
 * [3,2,1,5,6,4]
 * 2
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * @author chendong09
 * @since 2021/12/20
 **/
public class Q215 {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            // 匹配索引位置，直接返回
            return a[q];
        } else {
            // 继续排序查找
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        // 随机取一个值作为基准
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        // 将小于基准的都置于左侧，大于基准的都置于右侧
        return partition(a, l, r);
    }

    /**
     * 对数组进行排序，使得返回值左侧为小于等于返回下标位置的值，右侧均大于返回下标位置的值。即：a[l]..a[i - 1] <= a[i] <= a[i + 1]..a[r]
     *
     * 两部分操作：
     * 1、以最右侧值为基准值，对数组进行排序
     * 2、将最右侧值放置到已排序子数组最后
     *
     * 如：1、3、5、2、4、9、2 -> 1、2、5、3、4、9、2 -> 1、2、2、3、4、9、5
     *
     * @param a
     * @param l
     * @param r
     * @return
     */
    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        // 以最右边的值为基准值，将所有小于等于基准值的都移动到左边，大于的都移动到右边
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        // 将基准值移动到已排序的子数组右侧，此时[l, i + 1]都是已排序的
        swap(a, i + 1, r);
        // 返回已排序的最后一位索引下标
        return i + 1;
    }

    /**
     * 交换位置
     *
     * @param a 数组
     * @param i 索引i
     * @param j 索引j
     */
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
