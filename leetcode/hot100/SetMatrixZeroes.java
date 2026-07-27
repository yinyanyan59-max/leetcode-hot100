import java.util.Arrays;

/**
 * LeetCode 73. 矩阵置零（热题 HOT 100）
 * 链接: https://leetcode.cn/problems/set-matrix-zeroes/
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 *   输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 *   输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 示例 2：
 *   输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 *   输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * 提示：
 *   m == matrix.length
 *   n == matrix[0].length
 *   1 <= m, n <= 200
 *   -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 * 进阶：
 *   一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
 *   一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 *   你能想出一个仅使用常量空间的解决方案吗？
 */
class SetMatrixZeroesSolution {
    public void setZeroes(int[][] matrix) {
        // 在这里写你的解法
    }
}

public class SetMatrixZeroes {
    public static void main(String[] args) {
        SetMatrixZeroesSolution s = new SetMatrixZeroesSolution();

        check(s, new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
                new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, "case1");
        check(s, new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}},
                new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, "case2");
        check(s, new int[][]{{1}}, new int[][]{{1}}, "case3");
    }

    private static void check(SetMatrixZeroesSolution s, int[][] matrix, int[][] expected, String name) {
        int[][] copy = copyOf(matrix);
        s.setZeroes(copy);
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
