public class Solution {
    /**
     * @param nums: The integer array sorted in ascending order.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                // Find the last position
                start = middle;
            } else if (target < nums[middle]) {
                end = middle;
            } else {
                start = middle;
            }
        }
        // Find the first position
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
