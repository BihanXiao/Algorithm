class Solution {
    /**
     * Challenge: Do not use additional array for this question. A have enough space.
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = A.length - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] <= B[j]) {
                A[index--] = B[j--];
            } else {
                A[index--] = A[i--];
            }
        }

        // One of A, B is empty now.
        while (i >= 0) {
            A[index--] = A[i--];
        }

        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
}
