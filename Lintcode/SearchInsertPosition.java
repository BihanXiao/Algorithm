public class Solution {
    /**
     * @param A: a sorted integer array.
     * @param target: an integer to be inserted.
     * @return: an integer
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
	// Version1: find the first position >= target.
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (nums[middle] <= target) {
                start = middle;
            } else {
                end = middle;
            }
        }

        if (nums[start] >= target) {
            return start;
        }
        if (nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
