package uniquePaths;

public class Solution {
    public int uniquePaths(int m, int n) {
    	//if(m==1 || n==1) {
    	//	return 1;
    	//}
    	int tmp;
    	if(m>n) {
    		tmp = n;
    		n = m;
    		m = tmp;
    	}
    	int[] prev = new int[n];
    	int[] curr = new int[n];
    	for(int i=0;i<n;i++) {
    		curr[i]=1;
    		prev[i]=1;
    	}
    	for(int count=1;count<m;count++) {
    		curr[0]=1;
    		for(int i=1;i<n;i++) {
    			curr[i] = curr[i-1]+prev[i];
    			prev[i] = curr[i];
    		}
    	}
    	return curr[n-1];
    }
}