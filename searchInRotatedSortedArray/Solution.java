package searchInRotatedSortedArray;

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
			if(A[low]<A[mid]) {
				if(target>=A[low] && target<=A[mid]) {
					return biSearch(A,target,low,mid);
				}
				else {
					return biSearch(A,target,mid+1,high);
				}
			}
			else {
				if(target>=A[mid+1] && target<=A[high]) {
					return biSearch(A,target,mid+1,high);
				}
				else {
					return biSearch(A,target,low,mid);
				}
			}
		}
	}
	public int search(int[] A, int target) {
		return biSearch(A, target, 0, A.length-1);
    }
}
