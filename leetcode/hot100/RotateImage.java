import java.util.Arrays;

/**
 * LeetCode 48. 旋转图像（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/rotate-image/
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 示例 1：
 *   输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *   输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 示例 2：
 *   输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 *   输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * 提示：
 *   n == matrix.length == matrix[i].length
 *   1 <= n <= 20
 *   -1000 <= matrix[i][j] <= 1000
 */
class RotateImageSolution {
    public void rotate(int[][] matrix) {
        // 在这里写你的解法
        int left = 0;
        int n = matrix.length;
        while(left < (n/2 + 1)){
            int right = n - left -1;
            int tmp1,tmp2, tmp3 ;
            for (int i = 0; i< right-left;i++){
                tmp1 = matrix[left][left+i];
                tmp2 = matrix[left + i][right];
                tmp3 = matrix[right][right - i];
                matrix[left][left+i] = matrix[right - i][left];
                matrix[left + i][right] = tmp1;
                matrix[right][right - i] = tmp2;
                matrix[right - i][left] = tmp3;
            }
            left ++;
        }
    }
}

public class RotateImage {
    public static void main(String[] args) {
        RotateImageSolution s = new RotateImageSolution();

        check(s, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, "case1");
        check(s, new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}},
                new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}}, "case2");
        check(s, new int[][]{{1}}, new int[][]{{1}}, "case3");
    }

    private static void check(RotateImageSolution s, int[][] matrix, int[][] expected, String name) {
        int[][] copy = copyOf(matrix);
        s.rotate(copy);
        boolean ok = Arrays.deepEquals(copy, expected);
        System.out.printf("[%s] %s -> %s (期望 %s)%n",
                ok ? "PASS" : "FAIL",
                name,
                Arrays.deepToString(copy),
                Arrays.deepToString(expected));
    }

    private static int[][] copyOf(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return copy;
    }
}
