public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        // How about matrix[1], matrix[2]?
        // What if they have value(Have reference for 1D arrays and initiated)?
        // Is matrix[0] a certain kind of expression?

        int m = matrix.length;
        int n = matrix[0].length;
	// Using the two times of binary search.
        // Here is why, we just use matrix.length and matrix[0].length, and we have to initiate all rows at the same time.
        int start = 0;
        int end = m - 1;
        int middle;
	int row;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (matrix[middle][0] == target) {
                return true;
            } else if (matrix[middle][0] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        // why we cannot write two seperate if above? why we have to use else if?
        // BECAUSE, this part of the code does not return any thing directly, unlike searchInsert, the codes after the first condition will be executed!!!

        start = 0;
        end = n - 1;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (matrix[row][middle] == target) {
                return true;
            } else if (matrix[row][middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }

        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;
    }
}
