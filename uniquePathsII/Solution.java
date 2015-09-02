package uniquePathsII;

import java.util.Arrays;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) {
        	return 0;
        }
        int[] curr = new int[n];
        int[] prev = new int[n];
        curr[0] = 1;
        for(int i=1;i<n;i++) {
        	if(obstacleGrid[0][i]==1) {
        		curr[i]=0;
        	}
        	else {
        		curr[i]=curr[i-1];
        	}
        }
        prev = Arrays.copyOf(curr, n);
        /*for(int i=0;i<n;i++) {
        	System.out.print(curr[i]+"\t");
        }
        System.out.println();*/
        for(int count=1;count<m;count++) {
        	if(obstacleGrid[count][0]==1) {
        		curr[0] = 0;
        	}
        	else {
        		curr[0] = prev[0];
        	}
        	for(int j=1;j<n;j++) {
        		if(obstacleGrid[count][j]==1) {
            		curr[j]=0;
            	}
            	else {
            		curr[j]=curr[j-1]+prev[j];
            	}
        	}
        	prev = Arrays.copyOf(curr, n);
        }
        return curr[n-1];
    }
}
