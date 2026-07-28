import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 54. 螺旋矩阵（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/spiral-matrix/
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 *   输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *   输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 *   输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 *   输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 提示：
 *   m == matrix.length
 *   n == matrix[i].length
 *   1 <= m, n <= 10
 *   -100 <= matrix[i][j] <= 100
 */
class SpiralMatrixSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 在这里写你的解法
        ArrayList<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int h = 0;
        int w = 0;
        while (list.size() < m*n){
            int j = h;
            int i = w;
            for(; j<m-h;j++){
                if(i==w){
                    for(;i<n-w;i++){
                        list.add(matrix[j][i]);
                    }
                }else {
                    list.add(matrix[j][i - 1]);
                }
            }
            i--;
            j--;
            if(i > w && j > h){
                for(; j>h; j--){
                    if(i> w){
                        for(; i>w ;i--){
                            list.add(matrix[j][i-1]);
                        }
                    }else{
                        list.add(matrix[j][i]);
                    }
                }
            }
            h++;
            w++;

        }
        return list;
    }
}

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrixSolution s = new SpiralMatrixSolution();

        check(s, new int[][]{{1}, {4}, {7}},
                Arrays.asList(1, 4, 7), "case1");
        check(s, new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), "case2");
        check(s, new int[][]{{1}}, Arrays.asList(1), "case3");
    }

    private static void check(SpiralMatrixSolution s, int[][] matrix, List<Integer> expected, String name) {
        List<Integer> result = s.spiralOrder(matrix);
        boolean ok = expected.equals(result);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                result,
                expected);
    }
}
