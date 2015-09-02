package removeElement;

public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length==0) {
            return 0;
        }
        if(A.length==1) {
            return (A[0]==elem)? 0:1;
        }
        int l=0, r=A.length-1;
        while(l<=r) {
            if(A[l]==elem) {
                A[l]=A[r];
                A[r]=elem;
                r--;
            }
            else {
                l++;
            }
        }
        for(int i=0; i<A.length; i++) {
        	System.out.print(A[i]+" ");
        }
        System.out.println();
        return l;
    }
}