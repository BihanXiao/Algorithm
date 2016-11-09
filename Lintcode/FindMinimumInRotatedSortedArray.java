public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;    // I am not sure about why return -1, it is a integer...
        }

        int start = 0;
        int end = nums.length - 1;
        int middle;
        int target = nums[nums.length - 1];
        // find the first element <= target
        // If we compare middle with nums[0], when the array is rotate on the 0 position(which is not really rotated), then we will dump the left of middle, and it will be wrong!
        // The last position will always exists, but the rotated first position may be not.
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (nums[middle] <= target) {
                end = middle;
            } else if (nums[middle] > target) {
                start = middle;
            }
        }
        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
