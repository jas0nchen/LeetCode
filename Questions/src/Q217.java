import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * @author chendong09
 * @since 2022/03/30
 */
public class Q217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }
}
