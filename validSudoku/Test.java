package validSudoku;

public class Test {
	public static void main(String[] args) {
		char[][] board = new char[9][9];
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				board[i][j] = '.';
			}
		}
		Solution sol = new Solution();
		System.out.println(sol.isValidSudoku(board));
	}
}
