public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

	// just using one binary search
        int m = matrix.length;    // the total number of rows.
        int n = matrix[0].length;    // the total number of columns.
        int total = m * n;
        int start = 0;
        int end = total - 1;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            int row = middle / n;
            int column = middle % n;
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }
        if (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target) {
            return true;
        }
        return false;
    }
}
