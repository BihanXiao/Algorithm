public class Solution {
    /**
     * @param x: An integer
     * @param return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }

        long start = 0;
        long end = x;
        long middle = 0;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (middle * middle == x) {
                return (int) middle;
            } else if (x < middle * middle) {
                end = middle;
            } else {
                start = middle;
            }
        }

        if (end * end <= x) {
            return (int) end;
        } else {
            return (int) start;
        }
    }
}
