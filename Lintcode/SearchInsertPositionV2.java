public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Version 2: find last position < target, then plus 1.
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (nums[middle] >= target) {
                end = middle;
            } else {
                start = middle;
            }
        }

        if (nums[end] < target) {
            return end + 1;
        }
        if (nums[start] < target) {
            return start + 1;
        } else {
            return start;
        }
    }
}
