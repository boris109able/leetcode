package nQueensII;

import java.util.*;

public class Solution {
	public void nQueensBackTrack(int n, int[] result, int currentLayer, int[] pos) {
		if(currentLayer == n) {
			result[0]++;
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
	public int totalNQueens(int n) {
		int[] result = new int[1];
		result[0] = 0;
    	int[] pos = new int[n];
    	nQueensBackTrack(n, result, 0, pos);
    	return result[0];
        
    }
}
