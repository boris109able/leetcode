package spiralMatrixII;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int i, l=0,r=n-1,u=0,d=n-1,num=1;
        while(true) {
        	for(i=l;i<=r;i++) {
        		result[u][i] = num;
        		num++;
        	}
        	u++;
        	if(u>d) {
        		break;
        	}
        	for(i=u;i<=d;i++) {
        		result[i][r] = num;
        		num++;
        	}
        	r--;
        	if(l>r) {
        		break;
        	}
        	for(i=r;i>=l;i--) {
        		result[d][i] = num;
        		num++;
        	}
        	d--;
        	if(u>d) {
        		break;
        	}
        	for(i=d;i>=u;i--) {
        		result[i][l] = num;
        		num++;
        	}
        	l++;
        	if(l>r) {
        		break;
        	}
        }
        return result;
    }
}