/**
 * Defination of ArrayReader:
 *
 * class ArrayReader {
 * // get the number at index, return -1 if not exists.
 * public int get(int index);
 * }
 */
public class Solution {
    public int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader == null || reader.get(0) == -1) {
            return -1;
        }
        // determined the smallest(sort of) search end index
        // the array will be filled with -1 in the last part!
        int searchEnd = 0;
        while ((reader.get(searchEnd) != -1) && reader.get(searchEnd) < target) {
            searchEnd = searchEnd * 2 + 1;
        }

        int start = 0;
        int end = searchEnd;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if ((reader.get(middle) >= target) || (reader.get(middle) == -1)) {
                end = middle;
            } else {
                start = middle;    // middle < target and middle exist
            }
        }

        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}
