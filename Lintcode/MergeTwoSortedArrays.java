class Solution {
    /**
     * Challenge: How can you optimize your algorithm if one array is very large and
     * the other is very small.
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] merged = new int[A.length + B.length];
        int i = A.length - 1;
        int j = B.length - 1;
        int index = merged.length - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] <= B[j]) {
                merged[index--] = B[j--];
            } else {
                merged[index--] = A[i--];
            }
        }

        while (i >= 0) {
            merged[index--] = A[i--];
        }

        while (j >= 0) {
            merged[index--] = B[j--];
        }

        return merged;
    }
}
