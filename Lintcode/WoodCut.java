public class Solution {
    public int woodCut(int[] L, int k) {
	if (L == null || L.length == 0) {
	    return 0;
	}
	int length = findLongest(L);
	int start = 1;
	int end = length;
	int mid;
	while (start + 1 < end) {
	    mid = start + (end - start) / 2;
	    if (sumOfPieces(L, mid) >=  k) {
		start = mid;
	    } else {
		end = mid;
	    }
	}

	if (sumOfPieces(L, end) >= k) {
	    return end;
	} else if (sumOfPieces(L, start) >= k) {
	    return start;
	} else {
	    return -1;
	}	
    }

    private static int sumOfPieces(int[] L, int length) {
	int sum = 0;
	for (int num : L) {    // If L is empty, will this work?
	    sum += num / length;
	}
	return sum;
    }
    
    private static int findLongest(int[] L) {
	int max = 0;    // Here, if the array is empty. You will get an run time error.
	for (int num : L) {    // If L is empty, will this work? Will there be any exceptions?
	    if (num > max) {
		max = num;
	    }  
	}
	return max;
    }
}
