public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] range = new int[2];
        if (A == null || A.length == 0) {
            range[0] = -1;
            range[1] = -1;
            return range;
        }

        int start = 0;
        int end = A.length - 1;
        int middle;

        // search for the left bound
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (target <= A[middle]) {
                end = middle;
            } else {
                start = middle;
            }
        }
        if (A[start] == target) {
            range[0] = start;
        } else if (A[end] == target) {
            range[0] = end;
        } else {
            range[0] = -1;
            range[1] = -1;
            return range;
        }

        // search for the right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (target < A[middle]) {
                end = middle;
            } else {
                start = middle;
            }
        }
        if (A[end] == target) {
            range[1] = end;
        } else {
            range[1] = start;    // since there is a left bound, so there must exist another bound
        }
        return range;
    }
}
