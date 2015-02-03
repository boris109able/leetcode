package firstMissingPositive;

public class Solution {
	public void print(int[] A) {
		for(int i=0;i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	int removeNonpositive(int[] A) {
		int l=0, r=A.length-1, tmp;
		while(l<r) {
			if(A[l]<=0) {
				tmp = A[l];
				A[l] = A[r];
				A[r] = tmp;
				r--;
			}
			else {
				l++;
			}
		}
		if(A[l]>0) {
			return l+1;
		}
		else {
			return l;
		}
	}
	int abs(int a) {
		if(a<0) {
			return -a;
		}
		else {
			return a;
		}
	}
	public int firstMissingPositive(int[] A) {
		if(A.length==0) {
			return 1;
		}
		int rl = removeNonpositive(A);
		System.out.println(rl);
		print(A);
		if(rl==0) {
			return 1;
		}
		int tmp, i;
		for(i=0; i<rl; i++) {
			tmp = abs(A[i])-1;
			if(tmp<rl) {
				A[tmp] = -abs(A[tmp]);
			}
		}
		print(A);
		for(i=0; i<rl; i++) {
			if(A[i]>0) {
				return i+1;
			}
		}
		return i+1;
    }
}
