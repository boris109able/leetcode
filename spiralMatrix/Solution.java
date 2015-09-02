package spiralMatrix;

import java.util.*;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if(matrix==null || matrix.length==0 ||matrix[0].length==0) {
			return result;
		}
		int m = matrix.length;
		int n = matrix[0].length;
        int u=0, d=m-1, l=0, r=n-1;
        while(true) {
        	for(int i=l;i<=r;i++) {
        		result.add(matrix[u][i]);
        	}
        	u++;
        	if(u>d) {
        		break;
        	}
        	for(int i=u;i<=d;i++) {
        		result.add(matrix[i][r]);
        	}
        	r--;
        	if(l>r) {
        		break;
        	}
        	for(int i=r;i>=l;i--) {
        		result.add(matrix[d][i]);
        	}
        	d--;
        	if(u>d) {
        		break;
        	}
        	for(int i=d; i>=u; i--) {
        		result.add(matrix[i][l]);
        	}
        	l++;
        	if(l>r) {
        		break;
        	}
        }
        return result;
    }
}
