package nQueens;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		int[] pos = new int[] {0,1,2,3};
		Solution sol = new Solution();
		List<List<String>> result = new ArrayList<List<String>>();
		/*sol.toString(result, pos);
		
		System.out.println(result);*/	
		
		result = sol.solveNQueens(3);
		for(List<String> tmp: result) {
			for(String tstr: tmp) {
				System.out.println(tstr);
			}		
			System.out.println();
		}
	}
}
