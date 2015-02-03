package sudokuSolver;

public class Test {
	public static void main(String[] args) {
		char[][] board = new char[9][9];
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				board[i][j] = '.';
			}
		}
		/*for(int i=0; i<9; i++) {
	
			board[0][i] = Integer.toString(i+1).charAt(0);
		}
		/*
		board[0][0] = '1';
		board[0][1] = '2';
		board[0][2] = '3';
		board[0][3] = '4';
		*/
		Solution sol = new Solution();	
		sol.solveSudoku(board);
		sol.print(board);
	}
}
