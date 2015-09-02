package rotateImage;

public class Test {
	void fill(int[][] matrix) {
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				matrix[i][j]=2*i+j+1;//(int)(100*Math.random());
			}
		}
	}
	void print(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				System.out.print(matrix[i][j]+"	");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		int n=2;
		int[][] matrix=new int[n][n];
		Test test=new Test();
		test.fill(matrix);
		test.print(matrix);
		Solution sol=new Solution();
		sol.rotate(matrix);
		System.out.println();
		test.print(matrix);	
	}
}
