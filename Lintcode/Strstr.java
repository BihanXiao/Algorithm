class Solution {
    /**
     * Returns a index to the first occurence of target in source,
     * or -1 if target is not part of source.
     * @param source string to be scanned.
     * @param target string containning the sequence of characters to be match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }

            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}