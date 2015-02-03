package sudokuSolver;

import java.util.ArrayList;
import java.util.Hashtable;

public class Solution {
	void deepcopy(char[][] a, char[][] b) {
		int size = 9, i, j;
		for(i=0; i<size; i++) {
			for(j=0; j<size; j++) {
				a[i][j] = b[i][j];
			}
		}
	}
	void deepcopy(int[][] a, int[][] b) {
		int size = 9, i, j;
		for(i=0; i<size; i++) {
			for(j=0; j<size; j++) {
				a[i][j] = b[i][j];
			}
		}
	}
	void deepcopy(int[][][] a, int[][][] b) {
		int L=3, size = 9, i, j, k;
		for(i=0; i<L; i++) {
			for(j=0; j<L; j++) {
				for(k=0; k<size; k++) {
					a[i][j][k] = b[i][j][k];
				}
			}
		}
	}
	void solve(char[][] board, int[][] row, int[][] col, int[][][] block, int[][] score, int num, int[] flag) {	
		if(flag[0]>0) {
			return;
		}
		if(num==0) {
			flag[0]=1;
			return;
		}
		int i,j, posi=0, posj=0, max=-2;
		int size = 9;
		// find maximum score
		for(i=0;i<size;i++) {
			for(j=0; j<size; j++) {
				if(score[i][j]>max) {
					posi = i;
					posj = j;
					max = score[i][j];
				}
			}
		}
		// find exploration space
		ArrayList<Integer> space = new ArrayList<Integer>();
		for(int k=0; k<size; k++) {
			if(row[posi][k]==0 && col[posj][k]==0 && block[posi/3][posj/3][k]==0) {
				space.add(k);
			}
		}	
		/*
		System.out.println("------------------------------------------");
		print(board);		
		System.out.println(posi+" "+posj+" "+space);
		System.out.println("------------------------------------------");
		*/
		// if space is empty which means there is a contradiction 
		// in the sudoku, then return
		if(space.isEmpty()) {
			return;
		}
		int fill;
		int[][] trow = new int[9][9]; 
		int[][] tcol = new int[9][9]; 
		int[][][] tblock = new int[3][3][9];
		int[][] tscore = new int[9][9];
		char[][] tboard = new char[9][9];
		for(int k=0; k<space.size(); k++) {			
			deepcopy(trow, row);
			deepcopy(tcol, col);
			deepcopy(tblock, block);
			deepcopy(tscore, score);
			deepcopy(tboard, board);		
			fill = space.get(k);
			tboard[posi][posj] = Integer.toString(fill+1).charAt(0);
			
			System.out.println("------------------------------------------");
			print(tboard);		
			System.out.println(posi+" "+posj+" "+space);
			System.out.println("------------------------------------------");
			
			trow[posi][fill] = 1;
			tcol[posj][fill] = 1;
			tblock[posi/3][posj/3][fill] = 1;
			tscore[posi][posj] = -1;
			for(int r = 0; r<size; r++) {
				if(tscore[r][posj]>=0) {
					tscore[r][posj]++;				
				}
			}
			for(int c = 0; c<size; c++) {
				if(tscore[posi][c]>=0) {
					tscore[posi][c]++;				
				}
			}
			for(int r=0; r<3; r++) {
				for(int c=0; c<3; c++) {
					if(tscore[posi/3+r][posj/3+c]>=0 && posi/3+r!=posi && posj/3+c!=posj) {
						tscore[posi/3+r][posj/3+c]++;
					}
				}
			}
			solve(tboard, trow, tcol, tblock, tscore, num-1, flag);
			if(flag[0]>0) {
				deepcopy(board, tboard);
				return;
			}
		}
	}
	void print(int[][] a) {
		int size = 9;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(a[i][j]+"	");
			}
			System.out.println();
		}
	}
	void print(int[][][] a) {
		int L = 3;
		int size = 9;
		for(int i=0; i<L; i++) {
			for(int j=0; j<L; j++) {
				for(int k=0; k<size; k++) {
					System.out.print(a[i][j][k]+" ");					
				}		
				System.out.println();
			}
		}
	}
	void print(char[][] a) {
		int size = 9;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void solveSudoku(char[][] board) {
		Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();
		map.put('1', 0);
		map.put('2', 1);
		map.put('3', 2);
		map.put('4', 3);
		map.put('5', 4);
		map.put('6', 5);
		map.put('7', 6);
		map.put('8', 7);
		map.put('9', 8);
		int size = 9;
		int[][] row = new int[9][9]; 
		int[][] col = new int[9][9]; 
		int[][][] block = new int[3][3][9];
		int[][] score = new int[9][9];
		int num = 9*9;
		int[] flag = new int[]{-1};
		int i,j, tmp;
		for(i=0; i<size; i++) {
			for(j=0; j<size; j++) {
				if(board[i][j]!='.') {
					tmp = map.get(board[i][j]);
					row[i][tmp] = 1;
					col[j][tmp] = 1;
					block[i/3][j/3][tmp] = 1;
					num--; 
				}
			}
		}
		int count;
		for(i=0; i<size; i++) {
			for(j=0; j<size; j++) {
				if(board[i][j]=='.') {
					count=0;
					for(int k=0; k<size; k++) {
						if(row[i][k]>0 || col[j][k]>0 || block[i/3][j/3][k]>0) {
							count++;
						}
					}
					score[i][j] = count;
				}
				else {
					score[i][j] = -1;
				}
			}
		}
		//print(row);
		//print(col);
		//System.out.print("block: ");print(block);
		//print(score);
		solve(board, row, col, block, score, num, flag);     
    }
}
