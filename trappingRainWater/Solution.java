package trappingRainWater;

import java.util.Stack;

public class Solution {
	public void print(int[] A) {
		for(int i=0;i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	public int trap(int[] A) {
		if(A.length<=2) {
			return 0;
		}
		int l=0, r=A.length-1, i, height, sum=0, tmp;
		while(l<r) {
			while(l<r && A[l]<=A[l+1]) {
				l++;
			}
			while(l<r && A[r-1]>=A[r]) {
				r--;
			}
			System.out.println(l+" "+r);
			height = Math.min(A[l], A[r]);
			for(i=l+1;i<r;i++) {
				tmp = (height-A[i]>0)? height-A[i]:0;
				sum += tmp;
				A[i] +=  tmp;
			}		
			if(l>=r) {
				break;
			}
		}
		return sum;
    }
	public int trap2(int[] A) {
		if(A.length<=2) {
			return 0;
		}
		int sum=0, i, left, right, tmp, height;
		Stack<Integer> st = new Stack<Integer>();
		for(i=0;i<A.length;i++) {
			if(i==0) {
				 if(A[i]>A[i+1]) {
					 st.push(i);
				 }
			}
			if(i==A.length-1 && A[i-1]<A[i]) {
				st.push(i);
			}
			if(i!=0 && i!=A.length-1 && A[i-1]<A[i] && A[i]>A[i+1]) {
				st.push(i);
			}
		}
		while(st.size()>1) {
			right = st.pop();
			left = st.pop();
			if(A[left]<A[right]) {
				st.push(right);
			}
			else if(A[left]>A[right]) {
				st.push(left);
			}
			height = Math.min(A[left], A[right]);
			for(i=left;i<=right;i++) {
				tmp = (height-A[i]>0)? height-A[i]:0;
				sum += tmp;
				A[i] +=  tmp;
			}
		}
		return sum;
    }
}
