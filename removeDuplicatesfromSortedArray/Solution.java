package removeDuplicatesfromSortedArray;

public class Solution {
	public int removeDuplicates(int[] A) {
        int l = 0, r = 1;
        if(A.length<1) {
        	return A.length;
        }
        int tmp;
        while(r<A.length) {
        	if(A[r]==A[l]) {
        		r++;
        	}
        	else {
        		l++;
        		tmp = A[r];
        		A[r] = A[l];
        		A[l] = tmp;
        		r++;
        	}
        }
        for(int i=0; i<A.length; i++) {
        	System.out.print(A[i]+" ");
        }
        System.out.println();
        return l+1;
    }
}
