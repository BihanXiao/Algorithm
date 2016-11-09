public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return the length of the new array
     */
    public int removeDuplicates(int[] nums) {
	// Here, I use the same idea of Remove Duplicates From Sorted Array.
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int current = 1;
        for (int next = current + 1; next < nums.length; next++) {
            if (nums[next] != nums[current - 1]) {
                current++;
                nums[current] = nums[next];
            }
        }
        return current + 1;
    }
}
