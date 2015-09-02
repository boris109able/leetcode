package minimumPathSum;

import java.util.Arrays;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] curr = new int[n];
        int[] prev = new int[n];
        curr[0] = grid[0][0];
        for(int j=1;j<n;j++) {
        	curr[j] = curr[j-1]+grid[0][j];
        }
        prev = Arrays.copyOf(curr, n);
        for(int i=1;i<m;i++) {
        	curr[0] = prev[0]+grid[i][0];
        	for(int j=1;j<n;j++) {
        		curr[j] = Math.min(prev[j], curr[j-1])+grid[i][j];
        	}
        	prev = Arrays.copyOf(curr, n);
        }
        return curr[n-1];
    }
}