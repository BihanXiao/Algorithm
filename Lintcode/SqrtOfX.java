public class Solution {
    /**
     * @param x: An integer
     * @param return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }

        float start = 0;
        float end = x;
        float middle = 0;
        while ((end - start) > 1e-2) {
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
        }
        if (start * start <= x) {
            return (int) start;
        }
        return -1;
    }
}
