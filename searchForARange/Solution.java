package searchForARange;

public class Solution {
	int biSearch(int[] A, int target, int low, int high) {
		if(low==high) {
			if(A[low]==target) {
				return low;
			}
			else {
				return -1;
			}
		}
		else {
			int mid = (low+high)/2;
			if(target<=A[mid]) {
				return biSearch(A, target, low, mid);
			}
			else {
				return biSearch(A, target, mid+1, high);
			}
		}
	}
	public int[] searchRange(int[] A, int target) {
		int idx = biSearch(A, target, 0, A.length-1);
		int[] pos = new int[2];
		if(idx<0) {
			pos[0] = -1; pos[1] = -1;
			return pos;
		}
		int l = idx, r = idx;
		while(l>=0 && A[l]==target) {
			l--;
		}
		while(r<A.length && A[r]==target) {
			r++;
		}
		pos[0] = l+1; pos[1] = r-1;
		return pos;
    }

}
