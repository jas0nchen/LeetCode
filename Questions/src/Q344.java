/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *
 * @author chendong09
 * @since 2022/04/08
 */
public class Q344 {

    /**
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        char temp;

        while (l <= r) {
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
