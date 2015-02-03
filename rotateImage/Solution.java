package rotateImage;

public class Solution {
	public void rotate(int[][] matrix) {
		int len=matrix.length,tmp;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				tmp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=tmp;
			}
		}
		
		Test test=new Test();
		System.out.println();
		test.print(matrix);
		int l,r;
		for(int i=0;i<len;i++){
			l=0;r=len-1;
			while(l<r){
				tmp=matrix[i][l];
				matrix[i][l]=matrix[i][r];
				matrix[i][r]=tmp;
				l++;r--;
			}
		}     
    }
}
