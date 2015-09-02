package uniquePathsII;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int m=3,n=3;
		int[][] obstacleGrid = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				obstacleGrid[i][j]=0;
			}
		}
		obstacleGrid[1][1]=1;
		/*for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(obstacleGrid[i][j]+"\t");
			}
			System.out.println();
		}*/
		System.out.println(sol.uniquePathsWithObstacles(obstacleGrid));
	}

}
