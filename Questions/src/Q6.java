import java.util.ArrayList;
import java.util.List;

/**
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * P     I
 *
 *
 * @author chendong09
 * @version 1.0.0
 * @since 2022/04/22
 */
public class Q6 {

    /**
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) {
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
