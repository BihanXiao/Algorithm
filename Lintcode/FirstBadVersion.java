class Solution {
    public int findFirstBadVersion(int n) {
        if (n < 1) {
            return -1;
        }

        int start = 1;
        int end = n;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(middle)) {
                end = middle;
            } else {
                start = middle;
            }
        }

        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        if (SVNRepo.isBadVersion(end)) {
            return end;
        }
        return -1;
    }
}
