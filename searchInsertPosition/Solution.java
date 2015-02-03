package searchInsertPosition;

public class Solution {
	int biSearch(int[] A, int target, int low, int high) {
		if(high==low) {
			if(A[low] == target) {
				return low;
			}
			if(A[high] < target) {
				return high+1;
			}
			return low;
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
	public int searchInsert(int[] A, int target) {
		if(target<A[0]) {
			return 0;
		}
		if(target>A[A.length-1]) {
			return A.length;
		}
		return biSearch(A, target, 0, A.length-1);
    }
}
