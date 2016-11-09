class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
        if (nums == null) {
            return powerSet;
        }

        ArrayList<Integer> subset = new ArrayList<Integer>();
        Arrays.sort(nums);    // Arrays.sort()
        subsetsHelper(powerSet, subset, nums, 0);

        return powerSet;
    }

    private void subsetsHelper(ArrayList<ArrayList<Integer>> powerSet,
                               ArrayList<Integer> subset,
                               int[] nums,
                               int position) {
        powerSet.add(new ArrayList<Integer>(subset));

        for (int i = position; i < nums.length; i++) {    // array.length
            subset.add(nums[i]);
            subsetsHelper(powerSet, subset, nums, i + 1);
            subset.remove(subset.size() - 1);    // list.size()
        }
    }
}
