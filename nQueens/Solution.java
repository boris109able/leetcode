package nQueens;

import java.util.*;

public class Solution {
	public void toString(List<List<String>> result, int[] pos) {
		List<String> tmp = new ArrayList<String>();
		String tstr;
		int n = pos.length;
		char[] schar = new char[n];
		Arrays.fill(schar, '.');
		for(int i=0; i<n; i++) {
			schar[pos[i]] = 'Q';
			tstr = new String(schar);
			tmp.add(tstr);
			schar[pos[i]] = '.';
		}
		result.add(tmp);
	}
	public void nQueensBackTrack(int n, List<List<String>> result, int currentLayer, int[] pos) {
		if(currentLayer == n) {
			toString(result, pos);
		}
		else {
			boolean[] possiblePos = new boolean[n];
			Arrays.fill(possiblePos, true);
			int m, l, r;
			for(int i=0; i<currentLayer; i++) {
				m = pos[i];
				l = pos[i] - (currentLayer-i);
				r = pos[i] + (currentLayer-i);
				possiblePos[m] = false;
				if(l>=0) {
					possiblePos[l] = false;
				}
				if(r<n) {
					possiblePos[r] = false;
				}						
			}
			for(int j=0; j<n; j++) {
				if(possiblePos[j]) {
					pos[currentLayer] = j;
					nQueensBackTrack(n, result, currentLayer+1, pos);
				}
			}
		}
	}
	public List<List<String>> solveNQueens(int n) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	int[] pos = new int[n];
    	nQueensBackTrack(n, result, 0, pos);
    	return result;
    }
}
