package spiralMatrixII;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] a = sol.generateMatrix(1);
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
