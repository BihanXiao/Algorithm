public class Solution {
    /**
     * @param nums: an array fo integers
     * @return :return and integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int current = 0;
        for (int next = 0; next < nums.length; next++) {
            if (nums[next] != nums[current]) {
                nums[++current] = nums[next];
            }
        }
        return current + 1;
    }
}
// comparing the nums[next] with the last number that is unique nums[current], or the previous one nums[next - 1]
// nums[current++] will be wrong!!! It will use the current position first, then add 1 to it.


