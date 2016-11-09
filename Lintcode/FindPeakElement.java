public class Solution {
    public int findPeak(int[] A) {
        int start = 1;
        int end = A.length - 1;
        int middle;

        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (A[middle] < A[middle - 1]) {
                end  = middle;
            } else {
                start = middle;
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}
