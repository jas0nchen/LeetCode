import java.util.List;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * @author chendong09
 * @since 2022/04/08
 */
public class Q557 {

    /**
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : splits) {
            sb.append(reverseWord(word)).append(" ");
        }
        return sb.substring(0, sb.length());
    }

    private String reverseWord(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        char temp;

        while (l <= r) {
            temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            l++;
            r--;
        }
        return new String(chars);
    }
}
