import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * @author chendong09
 * @since 2022/01/13
 */
public class Q54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int colume = left; colume <= right; colume++) {
                result.add(matrix[top][colume]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int colume = right - 1; colume > left; colume--) {
                    result.add(matrix[bottom][colume]);
                }
                for (int row = bottom; row > top; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return result;
    }
}
