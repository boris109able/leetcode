package minimumPathSum;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int m=3,n=3;
		int[][] grid = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				grid[i][j]=i+j;
			}
		}
		System.out.println(sol.minPathSum(grid));
	}
}