package validSudoku;

import java.util.Hashtable;

public class Solution {
	void clear(int[] check) {
		for(int i=0; i<check.length; i++) {
			check[i] = 0;
		}
	}
	boolean check(int[] check) {
		for(int i=0; i<check.length; i++) {
			if(check[i]>1) {
				return false;
			}
		}
		return true;
	}
	public boolean isValidSudoku(char[][] board) {
		int size = board.length;
		int[] check = new int[size];
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
		int i,j;
		for(i=0; i<size; i++) {
			clear(check);
			for(j=0; j<size; j++) {
				if(board[i][j]!='.') {
					check[map.get(board[i][j])]++;
				}
			}
			if(!check(check)) {
				return false;
			}
		}
		for(j=0; j<size; j++) {
			clear(check);
			for(i=0; i<size; i++) {
				if(board[i][j]!='.') {
					check[map.get(board[i][j])]++;
				}
			}
			if(!check(check)) {
				return false;
			}
		}
		int bL = 3, nB = 3;
		for(int bi = 0; bi<nB; bi++) {
			for(int bj = 0; bj<nB; bj++) {
				clear(check);
				for(i = 0; i<bL; i++) {
					for(j = 0; j<bL; j++) {
						if(board[bi*bL+i][bj*bL+j]!='.') {
							check[map.get(board[bi*bL+i][bj*bL+j])]++;
						}
					}
				}
				check(check);
				if(!check(check)) {
					return false;
				}
			}
		}
		return true;
    }
}
