public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int pivot = pivotSearch(A);
        if (A[0] <= target) {
	    // determine the array is rotated or not.
            if (pivot - 1 < 0) {
                return binarySearch(A, 0, A.length - 1, target);
            } else {
                return binarySearch(A, 0, pivot - 1, target);
            }
        } else {
            return binarySearch(A, pivot, A.length - 1, target);
        }
    }

    // return the index of the minimum element in the array
    private int pivotSearch(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int tail = A[A.length - 1];

        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if (A[middle] == tail) {
                return middle;
            } else if (A[middle] < tail) {
                end = middle;
            } else {
                start = middle;
            }
        }

        if (A[start] <= tail) {
            return start;
        } else {
            return end;
        }
    }

    // binary search the right portion may containning target.
    private int binarySearch(int[] A, int start, int end, int target) {
        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if (A[middle] == target) {
                return middle;
            } else if (A[middle] < target) {
                start = middle;
            } else {
                end = middle;
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
