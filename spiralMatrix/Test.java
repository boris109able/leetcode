package spiralMatrix;

public class Test {
	public static void main(String[] args) {
		int m=4, n=4;
		int[][] matrix = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n;j++) {
				matrix[i][j] = i*n+j+1;
			}
		}	
		Solution sol = new Solution();
		System.out.println(sol.spiralOrder(matrix));
	}
}
