public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        // I don't know why, but this is much faster then binary search twice.
        // learn the classification method.
        int start = 0;
        int end = A.length - 1;
        int middle;
        while (start + 1 < end) {
            middle  = start + (end - start) / 2;
            if (A[start] <= A[middle]) {
                // middle is on the leftside of pivot, redline
                if (A[start] <= target && target <= A[middle]) {
                    end = middle;
                } else {
                    start = middle;
                }
            } else {
                // middle is on the rightside of pivot, greenline
                if (A[middle] <= target && target <= A[A.length - 1]) {
                    start = middle;
                } else {
                    end = middle;
                }
            }
        }
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}
